package client.ui.test;

import client.ui.*;
import server.planning.model.*;
import server.planning.control.*;

public class TestMain{
  
  public static void main(String[] args){

  SafariDestinationView safariView = new SafariDestinationView();
  ModifySafariDestinationView modifyView = new ModifySafariDestinationView();

  SafariDestinationController safariController = new SafariDestinationController(safariView,modifyView);

  TestMain.addToFrame(safariView);
  
  }

  static void addToFrame(JPanel panel){
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.add(panel);

  }

}