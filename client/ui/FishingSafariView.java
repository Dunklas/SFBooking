package client.ui;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class FishingSafariView extends JPanel{
  
FishingSafariTopView topView;
FishingSafariBottomView bottomView;

public FishingSafariView(FishingSafariTopView top, FishingSafariBottomView bottom){
  topView = top;
  bottomView = bottom;
  this.setLayout(new GridLayout(2,1));
  this.add(topView);
  this.add(bottomView);
}

}
