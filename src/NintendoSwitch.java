package src;

import javax.swing.*;
public class NintendoSwitch extends Product {
  private final int NintendoSwitch_ID;
  private static final String prodName = "Nintendo Switch";
  private static int numNintendoSwitch = 0;
  private static int NintendoSwitchStock = 0;
  private static final double NintendoSwitchPrice = 349.99;
  private static final int expandedWidth = 525;
  private static final int   expandedHeight = 525;
  private static final ImageIcon NintendoSwitchImage = new ImageIcon("C:\\Users\\jacks\\OneDrive\\CS_Summative_Images\\switch.jpg");
  private static final ImageIcon NintendoSwitchScaledImage = ImageIconScaler.scaleImageIcon(NintendoSwitchImage, expandedWidth, expandedHeight);
  private static final String[] detailNintendoSwitch = {"This console has a feature that ", "no other console has, you can bring ", "this machine anywhere!"};
  public NintendoSwitch(){
    super(prodName, NintendoSwitchPrice, NintendoSwitchImage, NintendoSwitchScaledImage, detailNintendoSwitch);
    NintendoSwitchStock++;
    numNintendoSwitch++;
    NintendoSwitch_ID = numNintendoSwitch;
  }

  public void sell() {
    NintendoSwitchStock--;
  }

  public static String[] getDetailNintendoSwitch() {
    return detailNintendoSwitch;
  }
  public static String getProdName() {
    return prodName;
  }

  public static double getNintendoSwitchPrice() {
    return NintendoSwitchPrice;
  }
  public static ImageIcon getNintendoSwitchImage() {
    return NintendoSwitchImage;
  }

  public static ImageIcon getNintendoSwitchScaledImage() {
    return NintendoSwitchScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName + "\u001B[95m\nNintendoSwitch stock ID: \u001B[94m" + NintendoSwitch_ID + "\u001B[0m";
  }
}
