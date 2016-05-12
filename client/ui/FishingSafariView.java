package client.ui;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.StorageException;
import server.planning.model.SafariDestination;
import server.planning.model.FishingSafari;
import org.jdatepicker.*;
import org.jdatepicker.impl.*;
import java.text.DateFormat;


public class FishingSafariView extends JPanel{
  
FishingSafariTopView topView;
FishingSafariBottomView bottomView;


//SafariDestinationStorage destinationStorage = SafariDestinationStorageFactory.getGUITestStorage();
SafariDestinationStorage destinationStorage = SafariDestinationStorageFactory.getStorage();

FishingSafari fishingSafari;
SafariDestination destination;

HashMap<String,JComponent> topMap;
HashMap<String,JComponent> bottomMap;

DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

public FishingSafariView(FishingSafariTopView top, FishingSafariBottomView bottom){
  topView = top;
  bottomView = bottom;

  topMap = topView.getCompMap();
  bottomMap = bottomView.getCompMap();
  this.setLayout(new GridLayout(2,1));
  this.add(topView);
  this.add(bottomView);
}

public void buildFishingSafari(){
JComboBox<String> destinationPicker = (JComboBox<String>) bottomMap.get("destinationPicker");
String selectedDestination = destinationPicker.getSelectedItem().toString();

try{destination = destinationStorage.get(selectedDestination);}
catch(StorageException se){JOptionPane.showMessageDialog(null,se.getMessage());}

JDatePickerImpl startDatePicker = (JDatePickerImpl) topMap.get("startDate");
Date selectedStartDate = (Date) startDatePicker.getModel().getValue();

JDatePickerImpl endDatePicker = (JDatePickerImpl) topMap.get("endDate");
Date selectedEndDate = (Date) endDatePicker.getModel().getValue();

fishingSafari = new FishingSafari(destination,selectedStartDate,selectedEndDate,0);

}
public FishingSafari getFishingSafari(){
  return fishingSafari;
}

public void populateFishingSafari(FishingSafari safari){
    

  JDatePickerImpl startDatePicker = (JDatePickerImpl) topMap.get("startDate");
  String start = df.format(safari.getStartDate());
  startDatePicker.getJFormattedTextField().setText(start);
  
  JDatePickerImpl endDatePicker = (JDatePickerImpl) topMap.get("endDate");
  JFormattedTextField endDateText = endDatePicker.getJFormattedTextField();
  String end = df.format(safari.getEndDate());  
  endDateText.setText(end);
}





}
