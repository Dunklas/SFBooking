package server.planning.control;

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
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.*;
import javax.swing.JComponent;
import java.awt.event.*;


public class FishingSafariController{
  FishingSafariTopView topView;
  FishingSafariBottomView bottomView;
  ModifyFishingSafariView modifyView;
  FishingSafariView mainView;

  HashMap<String,JComponent> topMap;
  HashMap<String,JComponent> bottomMap;
  HashMap<String,JComponent> modifyMap;

  //FishingSafariStorage fishingStorage = FishingSafariStorageFactory.getStorage();
  FishingSafariStorage fishingStorage = FishingSafariStorageFactory.getGUITestStorage();
  //SafariDestinationStorage safariStorage = SafariDestinationStorageFactory.getStorage();
  SafariDestinationStorage safariStorage = SafariDestinationStorageFactory.getGUITestStorage();

  SafariDestination destination;
  FishingSafari fishingSafari; 

  public FishingSafariController(FishingSafariTopView top,
    FishingSafariBottomView bottom,FishingSafariView main,ModifyFishingSafariView mod){
    topView=top;
    bottomView=bottom;
    mainView = main;
    modifyView=mod;

    topMap = topView.getCompMap();
    bottomMap = bottomView.getCompMap();
    modifyMap = modifyView.getCompMap();

    bottomView.fillDestinationPicker(safariStorage.getList());


  }
  /*public void addListeners(){
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



  }*/

}