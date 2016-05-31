package client.control;

import client.ui.*;
import client.control.*;
import server.utils.storage.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Observer;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.CardLayout;


public class MainController{
   /**
  * Init StorageComponents
  */
  SafariDestinationStorage destinationStorage = SafariDestinationStorageFactory.getStorage();
  FishingSafariStorage fishingSafariStorage = FishingSafariStorageFactory.getStorage();
  BookingStorage bookingStorage = BookingStorageFactory.getStorage();
  CustomerStorage customerStorage = CustomerStorageFactory.getStorage();


  /**
  * Init SafariDestination components
  */
  SafariDestinationView destinationView = new SafariDestinationView();
  ModifySafariDestinationView modifyDestinationView = new ModifySafariDestinationView();
  SafariDestinationController destinationController = new SafariDestinationController(destinationView
    ,modifyDestinationView,destinationStorage);

  /**
  * Init FishingSafari components
  */
  FishingSafariTopView fishingSafariTopView = new FishingSafariTopView();
  FishingSafariBottomView fishingSafariBottomView = new FishingSafariBottomView();
  FishingSafariView fishingSafariView = new FishingSafariView(fishingSafariTopView,fishingSafariBottomView);
  ModifyFishingSafariView modifyFishingSafariView = new ModifyFishingSafariView();
  FishingSafariController fishingSafariController = new FishingSafariController(fishingSafariTopView
    ,fishingSafariBottomView,fishingSafariView,modifyFishingSafariView,destinationStorage,fishingSafariStorage);

  /**
  * Init Booking components
  */
  AddBookingView addBookingView = new AddBookingView();
  AddBookingController addBookingController = new AddBookingController(addBookingView,bookingStorage,customerStorage
    ,fishingSafariStorage,destinationStorage);

  /**
  * Init MainWindow
  */
  MainWindow mainWindow = new MainWindow();

  JPanel mainHolderPanel = new JPanel();
  JFrame mainFrame = new JFrame("SF Booking");
  CardLayout mainLayout = new CardLayout();


  /**
  * Init utils
  */
  MainSplitView safariDestinationSplit = new MainSplitView(modifyDestinationView,destinationView);
  MainSplitView fishingSafariSplit = new MainSplitView(modifyFishingSafariView,fishingSafariView);



  public MainController(){
    initFrame();
    addListeners();
    addObservers();
  }
  private void addObservers(){
    destinationStorage.addObserver(destinationController);
    destinationStorage.addObserver(fishingSafariController);
    destinationStorage.addObserver(addBookingController);
    fishingSafariStorage.addObserver(fishingSafariController);
    fishingSafariStorage.addObserver(addBookingController);
    customerStorage.addObserver(addBookingController);
    bookingStorage.addObserver(addBookingController);
  }

  

  private void initFrame(){
      mainFrame.setVisible(true);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(new Dimension(1400,1000)); // Default minmized size
      mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Fits to screen
      mainFrame.setLayout(new CardLayout());
      
      mainHolderPanel.setLayout(new CardLayout());
      mainHolderPanel.add(mainWindow,"mainMenu");
      mainHolderPanel.add(safariDestinationSplit,"destinationWindow");
      mainHolderPanel.add(fishingSafariSplit,"fishingSafariWindow");
      mainHolderPanel.add(addBookingView,"addBookingWindow");
      mainFrame.add(mainHolderPanel);
      mainFrame.addWindowListener(windowListener);

  }

  private CardLayout getCardLayout(){
    CardLayout layout = (CardLayout) mainHolderPanel.getLayout();

    return layout;
  }
      private void clearWindows(){
      destinationView.clearSelection();
      fishingSafariBottomView.clearSelection();
      addBookingView.clearSelection();
    }


  private void addListeners(){
      
    JButton backButton1 = (JButton) destinationView.getCompMap().get("backButton");
    backButton1.addActionListener(backListener);
    JButton backButton2 = (JButton) fishingSafariBottomView.getCompMap().get("backButton");
    backButton2.addActionListener(backListener);
    JButton backButton3 = (JButton) addBookingView.getCompMap().get("backButton");
    backButton3.addActionListener(backListener);

    JButton newBookingButton = (JButton) mainWindow.getCompMap().get("newBookingButton");
    newBookingButton.addActionListener(navigationListener);
    JButton handleBookingButton = (JButton) mainWindow.getCompMap().get("handleBookingButton");
    handleBookingButton.addActionListener(navigationListener);
    JButton handleFishingSafariButton = (JButton) mainWindow.getCompMap().get("handleFishingSafariButton");
    handleFishingSafariButton.addActionListener(navigationListener);
    JButton handleDestinationButton = (JButton) mainWindow.getCompMap().get("handleDestinationButton");
    handleDestinationButton.addActionListener(navigationListener);
    }

    WindowAdapter windowListener = new WindowAdapter(){
      public void windowClosing(WindowEvent we){
	  try{
        DBHelper.getInstance().closeConnection();
	  } catch (StorageException SE){

	  }
      }
    };

    
  

 

  ActionListener backListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
        getCardLayout().show(mainHolderPanel,"mainMenu"); // repaint window with MainWindow component
        clearWindows();
    }
  };

  ActionListener navigationListener = new ActionListener(){
    public void actionPerformed(ActionEvent e){
      JComponent comp = (JComponent) e.getSource();
      if(comp.getName().equals("newBookingButton")){
        getCardLayout().show(mainHolderPanel,"addBookingWindow");
        // repaint window with addbookingcomponent
      }
      else if(comp.getName().equals("handleBookingButton")){
        
        // repaint window with handlebookingcomponent
      }
      else if(comp.getName().equals("handleFishingSafariButton")){
        getCardLayout().show(mainHolderPanel,"fishingSafariWindow");
        // repaint window with fishingsafaricomponent
      }
      else if(comp.getName().equals("handleDestinationButton")){
        getCardLayout().show(mainHolderPanel,"destinationWindow");
        // repaint window with destintion component
      }
    }
  };

}
