package client.control;

import client.ui.*;
import client.control.*;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MainController{
  /**
  * Init SafariDestination components
  */
  SafariDestinationView destinationView = new SafariDestinationView();
  ModifySafariDestinationView modifyDestinationView = new ModifySafariDestinationView();
  SafariDestinationController destinationController = new SafariDestinationController(destinationView,modifyDestinationView);

  /**
  * Init FishingSafari components
  */
  FishingSafariTopView fishingSafariTopView = new FishingSafariTopView();
  FishingSafariBottomView fishingSafariBottomView = new FishingSafariBottomView();
  FishingSafariView fishingSafariView = new FishingSafariView(fishingSafariTopView,fishingSafariBottomView);
  ModifyFishingSafariView modifyFishingSafariView = new ModifyFishingSafariView();
  FishingSafariController fishingSafariController = new FishingSafariController(fishingSafariTopView
    ,fishingSafariBottomView,fishingSafariView,modifyFishingSafariView);

  /**
  * Init Booking components
  */
  AddBookingView addBookingView = new AddBookingView();
  AddBookingController addBookingController = new AddBookingController(addBookingView);

  /**
  * Init MainWindow
  */
  MainWindow mainWindow = new MainWindow();

  public void addListeners(HashMap<String,JComponent> compMap){
    JButton backButton = (JButton) compMap.get("backButton");
    backButton.addActionListener(backListener);

    JButton newBookingButton = (JButton) compMap.get("newBookingButton");
    newBookingButton.addActionListener(navigationListener);
    JButton handleBookingButton = (JButton) compMap.get("handleBookingButton");
    handleBookingButton.addActionListener(navigationListener);
    JButton handleFishingSafariButton = (JButton) compMap.get("handleFishingSafariButton");
    handleFishingSafariButton.addActionListener(navigationListener);
    JButton handleDestinationButton = (JButton) compMap.get("handleDestinationButton");
    handleDestinationButton.addActionListener(navigationListener);

    // init this method somewhere,, constructor?? mainmethod?
  }

  ActionListener backListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      // repaint window with MainWindow component
    }
  };

  ActionListener navigationListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName().equals("newBookingButton")){
        // repaint window with addbookingcomponent
      }
      else if(comp.getName().equals("handleBookingButton")){
        // repaint window with handlebookingcomponent
      }
      else if(comp.getName().equals("handleFishingSafariButton")){
        // repaint window with fishingsafaricomponent
      }
      else if(comp.getName().equals("handleDestinationButton")){
        // repaint window with destintion component
      }
    }
  };

}