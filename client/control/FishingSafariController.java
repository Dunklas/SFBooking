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
    modifyView.fillList(fishingStorage.getList());

    addListeners();
    

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

  /**
  * Listeners
  */

  ActionListener saveListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();

if(comp.getName().equals("saveFishingSafari")){
      mainView.buildFishingSafari();
      FishingSafari safari = mainView.getFishingSafari();
      fishingStorage.put(safari);
      modifyView.fillList(fishingStorage.getList());
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
      }
    }
  };

  ActionListener datePickerListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName()=="selectStartDate"){
        bottomView.setText("startTime",topView.getSelectedDate("startDate"));
      }
      else if(comp.getName()=="selectEndDate"){
        bottomView.setText("endTime",topView.getSelectedDate("endDate"));
      }
    }
  };

  ItemListener destinationListener = new ItemListener(){
    public void itemStateChanged(ItemEvent e){

        SafariDestination selectedDestination = safariStorage.get(bottomView.getSelectedItem("destinationPicker"));
        bottomView.setText("equipmentReq",selectedDestination.getEquipmentReq());        
      
    }
  };

}