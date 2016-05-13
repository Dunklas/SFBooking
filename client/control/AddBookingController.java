package client.control;

import server.booking.model.Booking;
import server.booking.handler.BookingHandler;
import server.customer.model.Customer;
import server.planning.model.FishingSafari;
import server.planning.handler.PlanningHandler;
import server.utils.storage.CustomerStorage;
import server.utils.storage.CustomerStorageFactory;
import server.utils.storage.BookingStorage;
import server.utils.storage.BookingStorageFactory;
import server.utils.storage.FishingSafariStorage;
import server.utils.storage.FishingSafariStorageFactory;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.StorageException;
import client.ui.AddBookingView;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.event.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.util.HashMap;

public class AddBookingController{
  
  AddBookingView addView;
 
  HashMap<String,JComponent> addMap;

  BookingStorage bookingStorage = BookingStorageFactory.getStorage();
  CustomerStorage customerStorage = CustomerStorageFactory.getStorage();
  FishingSafariStorage safariStorage = FishingSafariStorageFactory.getStorage();
  SafariDestinationStorage destinationStorage = SafariDestinationStorageFactory.getStorage();

  PlanningHandler planningHandler = new PlanningHandler();

  Customer customer;
  FishingSafari safari;
  Booking booking;


  public AddBookingController(AddBookingView abv){
    addView = abv;
    addMap = addView.getCompMap();
    

    addListeners();

    try{
    addView.updateFishingSafariList(safariStorage.getByStatus(0,1));
    addView.updateDestinationPicker(destinationStorage.getList());
    }
    catch(StorageException se){
      JOptionPane.showMessageDialog(null,se.getMessage());
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
   JButton saveCustomerButton = (JButton) addMap.get("saveCustomerButton");
   saveCustomerButton.addActionListener(customerListener);

   JButton selectButton = (JButton) addMap.get("selectButton");
   selectButton.addActionListener(selectListener);
  }

  /**
  * Listeners
  */

  ActionListener saveListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      customer = addView.getCustomer();
      safari = addView.getSelectedFishingSafari();
      int participants = addView.getParticipants();

      booking = new Booking(safari,customer,participants);
      try{
      bookingStorage.put(booking);
    }
    catch(StorageException se){
      JOptionPane.showMessageDialog(null,se.getMessage());
    }
    }
  };

  ActionListener clearListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      addView.clearSelection();
    }
  };

  ActionListener cancelListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){

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

  ActionListener customerListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      try{
      if(comp.getName().equals("getCustomerButton")){
        customer = customerStorage.get(addView.getText("customerEmail"));
        addView.populateCustomerInfo(customer);
      }
      else if(comp.getName().equals("saveCustomerButton")){
        addView.buildCustomer();
        customerStorage.put(addView.getCustomer());
      }
    }
    catch(StorageException se){
      se.printStackTrace();
    }
  }
  };

  ActionListener selectListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      addView.clearSelection();
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

