package server.planning.control;

import client.ui.FishingSafariTopView;
import client.ui.FishingSafariBottomView;
import client.ui.ModifyFishingSafariView;
import server.planning.model.FishingSafari;
import server.planning.model.SafariDestination;
import server.utils.storage.FishingSafariStorage;
import server.utils.storage.FishingSafariStorageFactory;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageFactory;

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
    modifyMap=mod;

    topMap = topView.getCompMap();
    bottomMap = bottomView.getCompMap();
    modifyMap = modifyView.getCompMap();

    bottomView.fillDestinationPicker(storage.getList());


  }

}