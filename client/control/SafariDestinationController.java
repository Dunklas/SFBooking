package client.control;

import client.ui.SafariDestinationView;
import client.ui.ModifySafariDestinationView;
import server.planning.model.SafariDestination;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageDB;
import server.utils.storage.SafariDestinationGUIStorage;
import server.utils.storage.StorageException; 
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class SafariDestinationController implements Observer{
  
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


    try{modifyView.fillList(storage.getList());}
    catch(StorageException se){JOptionPane.showMessageDialog(null,se.getMessage());}

    addListeners();
    storage.addObserver(this);

  }

  public void addListeners(){
    JButton saveButton = (JButton) safariMap.get("saveNewSafariButton");
    saveButton.addActionListener(saveListener);

    JButton selectButton = (JButton) modifyMap.get("selectButton");
    selectButton.addActionListener(selectListener);
  }
  public void update(Observable observable, Object object){
    ArrayList<SafariDestination> updatedList = (ArrayList<SafariDestination>) object;
    modifyView.fillList(updatedList);
    System.out.println("Test");
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
         
         try{storage.put(destination);}
         catch(StorageException se){JOptionPane.showMessageDialog(null,se.getMessage());}

         safariView.showButton(safariMap.get("activeButton").getName(),false);
         safariView.showButton(safariMap.get("inactiveButton").getName(),false);
         safariView.clearSelection();
         //modifyView.fillList(storage.getList()); // fills the list again

      }
    }
  };

  ActionListener selectListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName()=="selectButton"){
         safariView.showButton(safariMap.get("activeButton").getName(),true);
         safariView.showButton(safariMap.get("inactiveButton").getName(),true);
         
         try{destination = storage.get(modifyView.getSelectedDestination());}
         catch(StorageException se){JOptionPane.showMessageDialog(null,se.getMessage());}

         safariView.populateSafariDestination(destination); // argument från storage ska in here..
      }
    }
  };
}