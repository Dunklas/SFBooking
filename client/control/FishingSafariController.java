package client.control;

import client.ui.FishingSafariTopView;
import client.ui.FishingSafariBottomView;
import client.ui.FishingSafariView;
import client.ui.ModifyFishingSafariView;
import server.planning.model.FishingSafari;
import server.planning.model.SafariDestination;
import server.utils.storage.FishingSafariStorage;
import server.utils.storage.FishingSafariStorageFactory;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.StorageException;
import server.utils.logs.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.*;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.awt.event.*;


public class FishingSafariController implements Observer{
  FishingSafariTopView topView;
  FishingSafariBottomView bottomView;
  ModifyFishingSafariView modifyView;
  FishingSafariView mainView;

  HashMap<String,JComponent> topMap;
  HashMap<String,JComponent> bottomMap;
  HashMap<String,JComponent> modifyMap;

  FishingSafariStorage fishingStorage = FishingSafariStorageFactory.getStorage();
  //FishingSafariStorage fishingStorage = FishingSafariStorageFactory.getGUITestStorage();
  SafariDestinationStorage safariStorage = SafariDestinationStorageFactory.getStorage();
  //SafariDestinationStorage safariStorage = SafariDestinationStorageFactory.getGUITestStorage();

  SafariDestination destination;
  FishingSafari fishingSafari; 

  Log log = new Log();

  public FishingSafariController(FishingSafariTopView top,
    FishingSafariBottomView bottom,FishingSafariView main,ModifyFishingSafariView mod){
    topView=top;
    bottomView=bottom;
    mainView = main;
    modifyView=mod;

    topMap = topView.getCompMap();
    bottomMap = bottomView.getCompMap();
    modifyMap = modifyView.getCompMap();

    try{
    bottomView.fillDestinationPicker(safariStorage.getList());
    modifyView.fillList(fishingStorage.getList());
    }
    catch(StorageException se){
      JOptionPane.showMessageDialog(null,se.getMessage());
    }

    addListeners();
    fishingStorage.addObserver(this);
    safariStorage.addObserver(this);
    

  }
    public void addListeners(){
    JButton startDateButton = (JButton) topMap.get("selectStartDate");
    startDateButton.addActionListener(datePickerListener);

    JButton endDateButton = (JButton) topMap.get("selectEndDate");
    endDateButton.addActionListener(datePickerListener);

    JButton saveSafari = (JButton) bottomMap.get("saveFishingSafari");
    saveSafari.addActionListener(saveListener);

    JComboBox<String> destinationPicker = (JComboBox<String>) bottomMap.get("destinationPicker");
    destinationPicker.addItemListener(destinationListener);

    JButton selectButton = (JButton) modifyMap.get("selectButton");
    selectButton.addActionListener(selectListener);


  }

  public void update(Observable obs, Object obj){
    if(obs instanceof FishingSafariStorage){
      ArrayList<FishingSafari> updatedFishingSafariList = (ArrayList<FishingSafari>) obj;
      modifyView.fillList(updatedFishingSafariList);
    }
    else if(obs instanceof SafariDestinationStorage){
      ArrayList<SafariDestination> updatedSafariDestinationList = (ArrayList<SafariDestination>) obj;
      bottomView.fillDestinationPicker(updatedSafariDestinationList);
    }
  }

  /**
  * Listeners
  */

  ActionListener saveListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();

if(comp.getName().equals("saveFishingSafari")){
      mainView.buildFishingSafari();
      FishingSafari safari = mainView.getFishingSafari();
      try{
        fishingStorage.put(safari);
        
      }
      catch(StorageException se){
        JOptionPane.showMessageDialog(null,se.getMessage());
      }
      bottomView.clearSelection();
    }
  }
  };
  ActionListener selectListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName().equals("selectButton")){
        FishingSafari selectedSafari = modifyView.getSelectedFishingSafari();
        mainView.populateFishingSafari(selectedSafari);
        bottomView.setText("startTime",topView.getSelectedDate("startDate"));
        bottomView.setEnabled("startTime",false);
        bottomView.setText("endTime",topView.getSelectedDate("endDate"));
        bottomView.setEnabled("endTime",false);
        bottomView.setSelectedDestinationIndex(selectedSafari.getSafariDestination());
      }
    }
  };

  ActionListener datePickerListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName().equals("selectStartDate")){
        bottomView.setText("startTime",topView.getSelectedDate("startDate"));
      }
      else if(comp.getName().equals("selectEndDate")){
        bottomView.setText("endTime",topView.getSelectedDate("endDate"));
      }
    }
  };

  ItemListener destinationListener = new ItemListener(){
    public void itemStateChanged(ItemEvent e){
      try{
        SafariDestination selectedDestination = safariStorage.get(bottomView.getSelectedItem("destinationPicker"));
        bottomView.setText("equipmentReq",selectedDestination.getEquipmentReq());        
      }
      catch(StorageException se){
        JOptionPane.showMessageDialog(null,se.getMessage());
      }
    }
  };

}