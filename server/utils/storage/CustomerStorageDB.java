package server.utils.storage;
import server.customer.model.*;
import java.util.Formatter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import server.utils.logs.Log;
public class CustomerStorageDB implements CustomerStorage {
   


    CustomerStorageDB(){

    }

    public void put(Customer toDB) throws StorageException{
	SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
	
	if (toDB.getId()== 0){
	    Date reg = new Date();
	    String dateNow = formatter.format(reg);
	    System.out.println(dateNow);
	     String sql = String.format("INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL, PHONE_NR, REGISTERED) VALUES ('%s', '%s', '%s', '%s', TO_DATE('%s','yyyy-mm-dd'))", 
					toDB.getFirstName(), 
					toDB.getLastName(), 
					toDB.getEmail(), 
					toDB.getTelephone(), 
					dateNow);
	     System.out.println(sql);
	     DBHelper.getInstance().update(sql);
	} else {
	    Date reg = toDB.getRegistered();
	    String regDate = formatter.format(reg);
	    String sql = String.format("UPDATE CUSTOMER SET FIRST_NAME = '%s', LAST_NAME = '%s', EMAIL = '%s', PHONE_NR = '%s', REGISTERED = TO_DATE('%s', 'yyyy-mm-dd') WHERE CUSTOMER_ID =%d", 
				       toDB.getFirstName(), 
				       toDB.getLastName(), 
				       toDB.getEmail(), 
				       toDB.getTelephone(), 
				       regDate, 
				       toDB.getId());
	    System.out.println(sql);
	    DBHelper.getInstance().update(sql);    
	
	}
	  Log.put("Suceccsfully wrote to DB");
	
    }


    public Customer get(String email) throws StorageException{
	String sql = String.format("SELECT * FROM customer where EMAIL = '%s'", email);
	ResultSet rs = DBHelper.getInstance().query(sql);
	Customer c = null;
	
	while (rs.next()){
	    c = new Customer( rs.getString("FIRST_NAME"),
			      rs.getString("LAST_NAME"),
			      rs.getString("EMAIL"),
			      rs.getString("PHONE_NR"),
			      rs.getDate("REGISTERED"));

	    c.setId(rs.getInt("CUSTOMER_ID"));
	}
	Log.put("Sucessfully fetched a Customer object from the DB");
	
	
	return c;
    }

    public Customer get(int id) throws StorageException{
	String sql = String.format("SELECT * FROM customer where CUSTOMER_ID = %d", id);
	ResultSet rs = DBHelper.getInstance().query(sql);
	Customer c = null;
	
	while (rs.next()){
	    c = new Customer( rs.getString("FIRST_NAME"),
			      rs.getString("LAST_NAME"),
			      rs.getString("EMAIL"),
			      rs.getString("PHONE_NR"),
			      rs.getDate("REGISTERED"));
	    c.setId(rs.getInt("CUSTOMER_ID"));
	}
	Log.put("Sucessfully fetched a Customer object from the DB");
	
	
	return c;
    }

}
