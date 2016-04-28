package server.utils.storage;
import server.customer.model.*;
import java.util.Formatter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerStorageDB implements CustomerStorage {
   


    private CustomerStorageDB(){

    }

    public void put(Customer toDB){
	if (toDB.getId()== null){
	    String sql = String.format("INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL, PHONE_NR, REGISTERED) VALUES (%s, &s, %s, %s, %t", c.getFirstName(), c.getlastName(), c.getEmail(), c.getTelephone(), c.getRegistered());
	    DBHelper.getInstance().update(sql);
	} else {
	    Customer fromDB = get(toDB.get());
	    
	}
    }

    public Customer get(String email){
	String sql = String.format("SELECT * FROM customer where EMAIL = %s", email);
	ResultSet rs = DBHelper.getInstance().query(sql);
	java.util.Date d = new java.util.Date(0);
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
	java.util.Date d = new java.util.Date(0);
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
