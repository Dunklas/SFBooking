package client.control;

import client.ui.SafariDestinationView;
import client.ui.ModifySafariDestinationView;
import server.planning.model.SafariDestination;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageDB;
import server.utils.storage.SafariDestinationGUIStorage;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SafariDestinationController{
  
  SafariDestinationView safariView;
  ModifySafariDestinationView modifyView;
  HashMap<String,JComponent> safariMap;
  HashMap<String,JComponent> modifyMap;

  //SafariDestinationStorage storage = SafariDestinationStorageFactory.getGUITestStorage();
  SafariDestinationStorage storage = SafariDestinationStorageFactory.getStorage();
  SafariDestination destination;

  public SafariDestinationController(SafariDestinationView sdv,ModifySafariDestinationView msdv){
    safariView = sdv;
    modifyView = msdv;
    safariMap = safariView.getCompMap();
    modifyMap = modifyView.getCompMap();


    modifyView.fillList(storage.getList()); // initates and gets all SafariDestinations to represent in GUI
    addListeners();
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
         storage.put(destination);
         safariView.showButton(safariMap.get("activeButton").getName(),false);
         safariView.showButton(safariMap.get("inactiveButton").getName(),false);
         safariView.clearSelection();
         modifyView.fillList(storage.getList()); // fills the list again

      }
    }
  };

  ActionListener selectListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName()=="selectButton"){
         safariView.showButton(safariMap.get("activeButton").getName(),true);
         safariView.showButton(safariMap.get("inactiveButton").getName(),true);
         destination = storage.get(modifyView.getSelectedDestination());
         safariView.populateSafariDestination(destination); // argument från storage ska in here..
      }
    }
  };
}