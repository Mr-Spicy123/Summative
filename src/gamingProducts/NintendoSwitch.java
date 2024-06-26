package src.gamingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;
public class NintendoSwitch extends Product {
  private final int NintendoSwitch_ID;
  private static final int shipSize = 30;
  private static final String prodName = "Nintendo Switch";
  private final String name = prodName;
  private static int numNintendoSwitch = 0;
  private static int NintendoSwitchStock = 0;
  private static final double NintendoSwitchPrice = 349.99;
  private static final int expandedWidth = 525;
  private static final int   expandedHeight = 525;
  private static final ImageIcon NintendoSwitchImage = new ImageIcon("images/switch.jpg");
  private static final ImageIcon NintendoSwitchScaledImage = ImageIconScaler.scaleImageIcon(NintendoSwitchImage, expandedWidth, expandedHeight);
  private static final String[] detailNintendoSwitch = {
          "The Nintendo Switch is a video game console,",
          "consisting of a console unit, a dock, and",
          "two Joy-Con controllers.[88] Although it is a hy-",
          "brid console, Nintendo classifies it as \"a home ",
          "console that you can take with you on the go\"."
  };
  public NintendoSwitch(){
    super(prodName, NintendoSwitchPrice, NintendoSwitchImage, NintendoSwitchScaledImage, detailNintendoSwitch);
    NintendoSwitchStock++;
    numNintendoSwitch++;
    NintendoSwitch_ID = numNintendoSwitch;
  }

  @Override
  public String getName() {
    return name;
  }

  public static int getShipSize() {
    return shipSize;
  }


  public static void setStock(int s) {
    NintendoSwitchStock = s;
  }
  public static int getNintendoSwitchStock() {
    return NintendoSwitchStock;
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
