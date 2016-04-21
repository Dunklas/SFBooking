package server.customer.model;

import java.util.ArrayList;
import java.util.Date;
import server.utils.Insert;

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

    }
    catch (Exception x){
    	x.printStackTrace();
    }
    }

    public boolean checkCustomer(String email) {
    return true;
    }
}
