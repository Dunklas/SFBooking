package client.ui.test;

import client.ui.*;
import server.planning.model.*;
import server.planning.control.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import client.ui.MainSplitView;

public class TestMain{
  
  public static void main(String[] args){

  SafariDestinationView safariView = new SafariDestinationView();
  ModifySafariDestinationView modifyView = new ModifySafariDestinationView();

  SafariDestinationController safariController = new SafariDestinationController(safariView,modifyView);
  
  MainSplitView split = new MainSplitView(modifyView,safariView);
  TestMain.addToFrame(split);
  
  }

  static void addToFrame(MainSplitView split){
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800,800);
    frame.add(split);

  }

}