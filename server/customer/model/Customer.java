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
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.telephone = telephone;
    	this.registered = registered;
    }

    public int getId(){
    	return customerID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getlastName(){
    	return lastName;
    }

    public String getEmail(){
    	return email;
    }

    public String getTelephone(){
    	return telephone;
    }

    public Date getRegistered(){
    	return registered;
    }

    public Date getUnregistered(){
    	return unregistered;
    }




}
