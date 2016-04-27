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

    public int getBookingStatus(){
	return bookingStatus;    
    }

    public double getPrice(){
	return price;    
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

    public Date getFinalConfirmationSent(){
	return finalConfirmationSent;
    }

    public Date getPaymentRecieved(){
	return paymentReceived;
    }

    public Date getBookingCancelled(){
    return bookingCancelled;    
    }

    public Date getBooked(){
    return booked;    
    }

    public Date getRefunded(){
    return refunded;    
    }

}
