package server.customer.model;

import java.util.ArrayList;
import java.util.Date;
import server.utils.Insert;
import server.utils.Select;

public class CustomerRegister {

    private ArrayList<Customer> customerList;


    public CustomerRegister() {
	customerList = new ArrayList<>();
    }

    public void newCustomer(String firstName, String lastName, String email, String telephone) {

    	Date registrationDate = new Date(); // Now
	
	try {	
	    Insert dbEntry = new Insert();
	    dbEntry.insertCustomer(firstName, lastName, email, telephone, registrationDate);
	} catch (Exception x) {
	    x.printStackTrace();
	}
    }

    public Customer getCustomer(String email) {

	Customer customerToGet = null;

	try {
	    Select dbQuery = new Select();
	    customerToGet = dbQuery.selectCustomer(email);
	} catch (Exception x) {
	    x.printStackTrace();
	}

	return customerToGet;
    }
}
