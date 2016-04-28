package server.booking.model;

import server.planning.model.FishingSafari;
import server.customer.model.Customer;
import java.sql.Date;

public class Booking {

    private int bookingID;
    private int bookingStatus; // 0 = Preliminary, 1 = Payed, 2 = Confirmed, 3 = Completed, 4 = Cancelled by customer, 5 = Cancelled
    private int nrParticipants;
    private double price;
    private FishingSafari fishingSafari;
    private Customer customer;

    private Date preliminaryConfirmationSent;
    private Date finalConfirmationSent;
    private Date paymentReceived;
    private Date bookingCancelled;
    private Date booked;
    private Date refunded;

    public Booking(FishingSafari safari, Customer customer) {
	this.fishingSafari = safari;
	this.customer = customer;
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

    public Date getPreliminaryConfirmationSent(){
	return preliminaryConfirmationSent;    
    }

    public void setPreliminaryConfirmationSent(Date date){
	this.preliminaryConfirmationSent = date;
    }

    public Date getFinalConfirmationSent(){
	return finalConfirmationSent;
    }

    public void setFinalConfirmationSent(Date date) {
	this.finalConfirmationSent = date;
    }

    public Date getPaymentReceived(){
	return paymentReceived;
    }

    public void setPaymentReceived(Date date){
	this.paymentReceived = date;
    }

    public Date getBookingCancelled(){
    return bookingCancelled;    
    }

    public void setBookingCancelled(Date date){
	this.bookingCancelled = date;
    }

    public Date getBooked(){
    return booked;    
    }

    public void setBooked(Date date){
	this.booked = date;
    }

    public Date getRefunded(){
    return refunded;    
    }

    public void setRefunded(Date date){
	this.refunded = date;
    }
}
