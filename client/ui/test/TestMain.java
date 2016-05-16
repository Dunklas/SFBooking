package client.ui.test;

import client.ui.*;
import server.planning.model.*;
import client.control.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import client.ui.MainSplitView;

public class TestMain{
  
  public static void main(String[] args){

  SafariDestinationView safariView = new SafariDestinationView();
  ModifySafariDestinationView modifyView = new ModifySafariDestinationView();

  SafariDestinationController safariController = new SafariDestinationController(safariView,modifyView);
  
  FishingSafariBottomView bottomView = new FishingSafariBottomView();
  FishingSafariTopView topView = new FishingSafariTopView();
  FishingSafariView mainView = new FishingSafariView(topView,bottomView);
  ModifyFishingSafariView modifyFishingView = new ModifyFishingSafariView();

  FishingSafariController fishingController = new FishingSafariController(topView,bottomView,mainView,modifyFishingView);

  //MainSplitView split = new MainSplitView(modifyFishingView,mainView);
  //TestMain.addSplitToFrame(split);

  AddBookingView addBookingView = new AddBookingView();
  AddBookingController addBookingController = new AddBookingController(addBookingView);

  TestMain.addPanelToFrame(addBookingView);
  
  }

  static void addSplitToFrame(MainSplitView split){
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1200,1000);
    frame.add(split);

  }
  static void addPanelToFrame(JPanel panel){
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1200,1000);
    frame.add(panel);
  }

}