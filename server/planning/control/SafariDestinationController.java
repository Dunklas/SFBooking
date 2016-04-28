package server.planning.control;

import client.ui.SafariDestinationView;
import client.ui.ModifySafariDestinationView;
import server.utils.storage.SafariDestinationStorageFactory;
import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationDB;

public class SafariDestinationController{
  
  SafariDestinationView safariView;
  ModifySafariDestinationView modifyView;
  HashMap<String,Component> safariMap;
  HashMap<String,Component> modifyMap;

  SafariDestinationStorage storage = SafariDestinationStorageFactory.getStorage();

  public SafariDestinationController(SafariDestinationView sdv,ModifySafariDestinationView msdv){
    safariView = sdv;
    modifyView = msdv;
    safariMap = safariView.getCompMap();
    modifyMap = modifyView.getCompMap();
  }



  /**
  * Listeners
  */

  ActionListener saveListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      Component comp = (Component) e.getSource();
      if(comp.getName("saveNewSafariButton")){

      }
    }
  };
}