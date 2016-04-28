package server.planning.control;

import client.ui.SafariDestinationView;
import client.ui.ModifySafariDestinationView;
import server.planning.model.SafariDestination;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageDB;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SafariDestinationController{
  
  SafariDestinationView safariView;
  ModifySafariDestinationView modifyView;
  HashMap<String,JComponent> safariMap;
  HashMap<String,Component> modifyMap;

  SafariDestinationStorage storage = SafariDestinationStorageFactory.getStorage();
  SafariDestination destination;

  public SafariDestinationController(SafariDestinationView sdv,ModifySafariDestinationView msdv){
    safariView = sdv;
    modifyView = msdv;
    safariMap = safariView.getCompMap();
    modifyMap = modifyView.getCompMap();

    modifyView.fillList(storage.getList()); // initates and gets all SafariDestinations to represent in GUI
  }

  public void addListeners(){
    JButton saveButton = (JButton) safariMap.get("saveNewSafariButton");
    saveButton.addActionListener(saveListener);

    JButton selectButton = (JButton) modifyMap.get("selectButton");
    selectButton.addActionListener(selectListener);
  }



  /**
  * Listeners
  */

  ActionListener saveListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName()=="saveNewSafariButton"){
        safariView.buildSafariDestination();
         destination = safariView.getSafariDestination();
      }
    }
  };

  ActionListener selectListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName()=="selectButton"){
         safariView.populateSafariDestination(); // argument från storage ska in here..
      }
    }
  };
}