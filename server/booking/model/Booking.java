package server.booking.model;

import server.planning.model.FishingSafari;
import server.customer.model.Customer;
import java.util.Date;

public class Booking {

    private int bookingID;
    private int bookingStatus; // 0 = Preliminary, 1 = Payed, 2 = Confirmed, 3 = Completed, 4 = Cancelled by customer, 5 = Cancelled
    private int nrParticipants;
    private double price;
    private FishingSafari fishingSafari;
    private Customer customer;

    private Date booked;


    public Booking(FishingSafari safari, Customer customer, int nrParticipants) {
	this.fishingSafari = safari;
	this.customer = customer;
	this.nrParticipants = nrParticipants;
	this.price = 500*nrParticipants; // Always 500 for now, since we haven't implemented price
   
	//bookingStatus always get 0, since that's default for int instance variables
    }

    public String toString() {
	return String.format("Id: %d Status: %d Customer: %s FishingSafari: %s Nr participants: %d Price: %f", bookingID, bookingStatus, customer.toString(), fishingSafari.toString(), nrParticipants, price);
    }

    public int getBookingID(){
	return bookingID;    
    }

    public void setBookingID(int id){
	this.bookingID = id;
    }

    public int getBookingStatus(){
	return bookingStatus;    
    }

    public void setBookingStatus(int status) {
	this.bookingStatus = status;
    }

    public int getNrParticipants() {
	return nrParticipants;
    }

    public void setNrParticipants(int nr) {
	this.nrParticipants = nr;
    }

    public double getPrice(){
	return price;    
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public FishingSafari getFishingSafari(){
	return fishingSafari;    
    }

    public Customer getCustomer(){
	return customer;    
    }



    public Date getBooked(){
    return booked;    
    }

    public void setBooked(Date date){
	this.booked = date;
    }
}
