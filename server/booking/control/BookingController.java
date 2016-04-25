package server.booking.control;

import server.planning.model.FishingSafariCatalog;
import server.customer.model.CustomerRegister;
import server.booking.model.BookingCatalogue;


public class BookingController {

	FishingSafariCatalogue fishingSafariCatalogue;
	CustomerRegister customerRegister;
	BookingCatalogue bookingCatalogue;

	public BookingController(FishingSafariCatalogue fsc, CustomerRegister cr, BookingCatalogue bc){
      fishingSafariCatalogue = fsc;
      customerRegister = cr;
      bookingCatalogue = bc;
	}

}
