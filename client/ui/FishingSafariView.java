package client.ui;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.SafariDestinationGUIStorage;
import server.planning.model.SafariDestination;
import server.planning.model.FishingSafari;
import org.jdatepicker.*;
import org.jdatepicker.impl.*;


public class FishingSafariView extends JPanel{
  
FishingSafariTopView topView;
FishingSafariBottomView bottomView;


SafariDestinationStorage destinationStorage = SafariDestinationStorageFactory.getGUITestStorage();

FishingSafari fishingSafari;
SafariDestination destination;

HashMap<String,JComponent> topMap;
HashMap<String,JComponent> bottomMap;

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
destination = destinationStorage.get(selectedDestination);

JDatePickerImpl startDatePicker = (JDatePickerImpl) topMap.get("startDate");
Date selectedStartDate = (Date) startDatePicker.getModel().getValue();

JDatePickerImpl endDatePicker = (JDatePickerImpl) topMap.get("endDate");
Date selectedEndDate = (Date) endDatePicker.getModel().getValue();

fishingSafari = new FishingSafari(destination,selectedStartDate,selectedEndDate,0);

}
public FishingSafari getFishingSafari(){
  return fishingSafari;
}


}
