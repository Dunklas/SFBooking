package server.booking.model;

public class BookingHandler {

    FishingSafariCatalogue fsCat;
    CustomerRegister cReg;
    BookingCatalogue bCat;

    public BookingHandler(FishingSafariCatalogue fsCat, CustomerRegister cReg, BookingCatalogue bCat) {
	this.fsCat = fsCat;
	this.cReg = cReg;
	this.bCat = bCat;
    }

    public List<String> startBooking() {

	return fsCat.selectAllFishingSafaris(); // Provides a list of all fishingsafaris to be displayed in GUI
    }

    public Customer checkCustomer(String email) {
	return cReg.getCustomer(email); // Returns null if no customer exists
    }

    public void newCustomer(String firstName, String lastName, String email, String telephone) {
	cReg.newCustomer(firstName, lastName, email, telephone);
    }

    public void newBooking(Customer customer, FishingSafari fs) {
	bCat.newBooking(customer, fs);
    }
}
