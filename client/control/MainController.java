package client.control;

import client.ui.*;
import client.control.*;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;


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
  JFrame mainFrame = new JFrame();

  /**
  * Init utils
  */



  public MainController(){
    initFrame();
    addListeners(initArrayOfCompMaps());
  }

  

  public void initFrame(){
      mainFrame.setVisible(true);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(new Dimension(1000,1000));
      mainFrame.add(mainWindow);
  }

  private void setWindow(JComponent window){

  }

  private ArrayList<HashMap<String,JComponent>> initArrayOfCompMaps(){
    ArrayList<HashMap<String,JComponent>> arrayOfCompMaps = new ArrayList<HashMap<String,JComponent>>();
    arrayOfCompMaps.add(destinationView.getCompMap());
    arrayOfCompMaps.add(modifyDestinationView.getCompMap());
    arrayOfCompMaps.add(fishingSafariTopView.getCompMap());
    arrayOfCompMaps.add(fishingSafariBottomView.getCompMap());
    arrayOfCompMaps.add(modifyFishingSafariView.getCompMap());
    arrayOfCompMaps.add(addBookingView.getCompMap());

    return arrayOfCompMaps;
  }


  private void addListeners(ArrayList<HashMap<String,JComponent>> compMapArray){
    try{
      for(HashMap<String,JComponent> compMap : compMapArray){
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
    }
    }
    catch(NullPointerException npe){
      // if component found, exception is found: This is expected
    }

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
        mainFrame.remove(mainWindow);
        mainFrame.add(addBookingView);// repaint window with addbookingcomponent
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