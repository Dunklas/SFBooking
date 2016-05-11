package client.control;

import server.booking.model.Booking;
import server.booking.handler.BookingHandler;
import server.utils.storage.BookingStorage;
import server.utils.storage.BookingStorageFactory;
import client.ui.AddBookingView;

public class AddBookingController{
  
  AddBookingView addView;
 
  HashMap<String,JComponent> addMap;

  BookingStorage storage = BookingStorageFactory.getStorage();

  public BookingController(AddBookingView abv){
    addView = abv;
    addMap = addView.getCompMap();
    

    addListeners();
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
  }

  /**
  * Listeners
  */

  ActionListener saveListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){

    }
  };

  ActionListener clearListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){

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

    }
  };

}

