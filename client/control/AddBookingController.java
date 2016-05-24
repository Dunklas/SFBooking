package client.control;

import server.booking.model.Booking;
import server.booking.handler.BookingHandler;
import server.customer.model.Customer;
import server.planning.model.FishingSafari;
import server.planning.handler.PlanningHandler;
import server.planning.model.SafariDestination;
import server.payment.handler.PaymentHandler;
import server.utils.storage.CustomerStorage;
import server.utils.storage.CustomerStorageFactory;
import server.utils.storage.BookingStorage;
import server.utils.storage.BookingStorageFactory;
import server.utils.storage.FishingSafariStorage;
import server.utils.storage.FishingSafariStorageFactory;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.StorageException;
import server.utils.logs.Log;
import client.ui.AddBookingView;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.event.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

public class AddBookingController implements Observer{
  
  AddBookingView addView;
 
  HashMap<String,JComponent> addMap;

  BookingStorage bookingStorage;
  CustomerStorage customerStorage;
  FishingSafariStorage fishingSafariStorage;
  SafariDestinationStorage destinationStorage;

  PlanningHandler planningHandler = new PlanningHandler();
  PaymentHandler paymentHandler = new PaymentHandler();

  Customer customer;
  FishingSafari safari;
  Booking booking;

  Log log = new Log();


  public AddBookingController(AddBookingView abv,BookingStorage bookingStorage,CustomerStorage customerStorage
    ,FishingSafariStorage fishingSafariStorage,SafariDestinationStorage destinationStorage){
    this.bookingStorage = bookingStorage;
    this.customerStorage = customerStorage;
    this.fishingSafariStorage = fishingSafariStorage;
    this.destinationStorage = destinationStorage;

    addView = abv;
    addMap = addView.getCompMap();
    

    addListeners();
    

    try{
    addView.updateFishingSafariList(fishingSafariStorage.getByStatus(0,1));
    addView.updateDestinationPicker(destinationStorage.getList());
    }
    catch(StorageException se){
      JOptionPane.showMessageDialog(null,se.getMessage());
    }
  }
  public void update(Observable obs, Object obj){
    if(obs instanceof FishingSafariStorage){
      try{
      ArrayList<FishingSafari> updatedFishingSafariList = fishingSafariStorage.getByStatus(0,1);
      addView.updateFishingSafariList(updatedFishingSafariList);
      }
      catch(StorageException se){
        log.put(se.getMessage());
      }
    }
    else if(obs instanceof SafariDestinationStorage){
      ArrayList<SafariDestination> updatedDestinationList = (ArrayList<SafariDestination>) obj;
      addView.updateDestinationPicker(updatedDestinationList);
    }
  }

  public void addListeners(){
   JButton saveButton = (JButton) addMap.get("saveButton");
   saveButton.addActionListener(saveListener);

   JButton clearButton = (JButton) addMap.get("clearButton");
   clearButton.addActionListener(clearListener);

   JButton cancelButton = (JButton) addMap.get("cancelButton");
   cancelButton.addActionListener(cancelListener);

   JButton backButton = (JButton) addMap.get("backButton");
   backButton.addActionListener(backListener);

   JButton rentButton = (JButton) addMap.get("rentButton");
   rentButton.addActionListener(equipmentListener);
   JButton regretButton = (JButton) addMap.get("regretButton");
   regretButton.addActionListener(equipmentListener);

   JButton getCustomerButton = (JButton) addMap.get("getCustomerButton");
   getCustomerButton.addActionListener(customerListener);
   

   JButton selectButton = (JButton) addMap.get("selectButton");
   selectButton.addActionListener(selectListener);

   JButton simulateButton = (JButton) addMap.get("simulateButton");
   simulateButton.addActionListener(simulateListener);
  }

  /**
  * Listeners
  */

  ActionListener saveListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      safari = addView.getSelectedFishingSafari();
      int nrParticipants = addView.getParticipants();

      if(addView.getCustomer()==null){
      addView.buildCustomer();
      customer = addView.getCustomer();
      
    }
    else{
      customer = addView.getCustomer();
    }
      try{
      customerStorage.put(customer); // has to fetch this customer before inserting new booking below
      booking = new Booking(safari,customerStorage.get(customer.getEmail()),nrParticipants);
      bookingStorage.put(booking);
      addView.clearSelection();
      safari = null;
      customer = null;
    }
    catch(StorageException se){
      JOptionPane.showMessageDialog(null,se.getMessage());
    }
    }
  };

  ActionListener clearListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      safari = null;
      customer = null;
      addView.clearSelection();
    }
  };

  ActionListener cancelListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      safari = null;
      customer = null;
      addView.clearSelection();
    }
  };

  ActionListener backListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){

    }
  };

  ActionListener equipmentListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName().equals("rentButton")){

      }
      else if(comp.getName().equals("regretButton")){

      }

    }
  };

  ActionListener simulateListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      try{
      paymentHandler.paymentCheck();
      }
      catch(StorageException se){
        log.put(se.getMessage());
      }
    }
  };

  ActionListener customerListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      try{
      if(comp.getName().equals("getCustomerButton")){
        customer = customerStorage.get(addView.getText("customerEmail"));
        addView.populateCustomerInfo(customer);
      }
 
    }
    catch(StorageException se){
      se.printStackTrace();
    }
  }
  };

  ActionListener selectListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      
      safari = addView.getSelectedFishingSafari();
      addView.setFishingSafari(safari);
      addView.populateFishingSafariInfo(safari);
      try{
      addView.updateParticipantsPicker(planningHandler.availabilityCheck(safari));
    }
    catch(StorageException se){
      JOptionPane.showMessageDialog(null,se.getMessage());
    }
    }
  };

}

