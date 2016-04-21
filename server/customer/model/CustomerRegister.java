package server.customer.model;

import java.util.ArrayList;
import java.util.Date;

public class CustomerRegister {

    private ArrayList<Customer> customerList;


    public CustomerRegistered() {
	customerList = new ArrayList<>();
    }

    public void newCustomer(String firstName, String lastName, String email, String telephone) {

    	Date registrationDate = new Date(); // Now

    try {	
    Insert dbEntry = new Insert();
    dbEntry.insertCustomer(firstName, lastName, email, telephone, registrationDate);

    }
    }

    public boolean checkCustomer(String email) {

    }
}
