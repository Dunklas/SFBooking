package server.utils.storage;
import server.customer.model.customer;

public class CustomerStorageDB implements CustomerStorage {
   


    private CustomerStorageDB(){

    }

    public void put(Customer c){

    }

    public Customer get(String email){
	String sql = String.Format("SELECT * FROM customer where EMAIL = %s", email);
	ResultSet rs = DBHelper.getInstance().query(sql);
	java.util.Date d = new java.util.Date(0);
	Customer c = new Customer(-100, "", "", "", "", d);
	while (rs.next()){
	    c = new Customer( rs.getInt("CUSTOMER_ID"),
			      rs.getString("FIRST_NAME"),
			      rs.getString("LAST_NAME"),
			      rs.getString("EMAIL"),
			      rs.getString("PHONE_NR"),
			      rs.getDate("REGISTERED"));

	}
	return c;
    }

    public Customer get(int id){
	String sql = String.Format("SELECT * FROM customer where CUSTOMER_ID = %d", id);
	ResultSet rs = DBHelper.getInstance().query(sql);
	java.util.Date d = new java.util.Date(0);
	Customer c = new Customer(-100, "", "", "", "", d);
	while (rs.next()){
	    c = new Customer( rs.getInt("CUSTOMER_ID"),
			      rs.getString("FIRST_NAME"),
			      rs.getString("LAST_NAME"),
			      rs.getString("EMAIL"),
			      rs.getString("PHONE_NR"),
			      rs.getDate("REGISTERED"));

	}
	return c;
    }

}
