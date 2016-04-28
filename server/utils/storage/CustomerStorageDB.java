package server.utils.storage;
import server.customer.model.*;
import java.util.Formatter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CustomerStorageDB implements CustomerStorage {
   


    CustomerStorageDB(){

    }

    public void put(Customer toDB){
	if (toDB.getId()== 0){
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String date = formatter.format(toDB.getRegistered());
	    System.out.println(date);
	     String sql = String.format("INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL, PHONE_NR, REGISTERED) VALUES (%s, %s, %s, %s, TO_DATE('%s'))", toDB.getFirstName(), toDB.getlastName(), toDB.getEmail(), toDB.getTelephone(), date);
	     System.out.println(sql);
	     DBHelper.getInstance().update(sql);
	} else {
	    Customer fromDB = get(toDB.getId());
	    
	}
    }

    public Customer get(String email){
	String sql = String.format("SELECT * FROM customer where EMAIL = '%s'", email);
	ResultSet rs = DBHelper.getInstance().query(sql);
	Customer c = null;
	try{
	while (rs.next()){
	    c = new Customer( rs.getString("FIRST_NAME"),
			      rs.getString("LAST_NAME"),
			      rs.getString("EMAIL"),
			      rs.getString("PHONE_NR"),
			      rs.getDate("REGISTERED"));

	    c.setId(rs.getInt("CUSTOMER_ID"));
	}
	} catch (SQLException se){
	    se.printStackTrace();
	}
	return c;
    }

    public Customer get(int id){
	String sql = String.format("SELECT * FROM customer where CUSTOMER_ID = %d", id);
	ResultSet rs = DBHelper.getInstance().query(sql);
	Customer c = null;
	try{
	while (rs.next()){
	    c = new Customer( rs.getString("FIRST_NAME"),
			      rs.getString("LAST_NAME"),
			      rs.getString("EMAIL"),
			      rs.getString("PHONE_NR"),
			      rs.getDate("REGISTERED"));
	    c.setId(rs.getInt("CUSTOMER_ID"));
	}
	} catch (SQLException se){
	    se.printStackTrace();
	}
	
    
	return c;
    }

}
