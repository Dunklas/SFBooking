package server.planning.control;

import client.ui.FishingSafariTopView;
import client.ui.FishingSafariBottomView;
import client.ui.ModifyFishingSafariView;
import server.planning.model.FishingSafari;
import server.planning.model.SafariDestination;
import server.utils.storage.FishingSafariStorage;
import server.utils.storage.FishingSafariStorageFactory;

public class FishingSafariController{
  FishingSafariTopView topView;
  FishingSafariBottomView bottomView;
  ModifyFishingSafariView modifyView;

  HashMap<String,JComponent> topMap;
  HashMap<String,JComponent> bottomMap;
  HashMap<String,JComponent> modifyMap;

  FishingSafariStorage = server.utils.storage.FishingSafariStorageFactory.getStorage();

  public FishingSafariController(FishingSafariTopView top,
    FishingSafariBottomView bottom,ModifyFishingSafariView mod){
    topView=top;
    bottomView=bottom;
    modifyMap=mod;

    topMap = topView.getCompMap();
    bottomMap = bottomView.getCompMap();
    modifyMap = modifyView.getCompMap();

    bottomView.fillDestinationPicker(storage.getList());


  }

}