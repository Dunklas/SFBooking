package server.customer.model;

import java.util.Date;

public class Customer {

    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;

    private Date registered;
    private Date unregistered;

    public Customer (int customerID, String firstName, String lastName, String email, String telephone, Date registered) {

    	this.customerID = customerID;
    }

    public int getId(){
    	return customerID;
    }


}
