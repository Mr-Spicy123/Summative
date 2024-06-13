package src.gamingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;
public class OculusQuest3 extends Product {
  private final int OculusQuest3_ID;
  private static final int shipSize = 30;
  private static final String prodName = "Oculus Quest 3";
  private final String name = prodName;
  private static int numOculusQuest3 = 0;
  private static int OculusQuest3Stock = 0;
  private static final double OculusQuest3Price = 1499.99;
  private static final int expandedWidth = 525;
  private static final int   expandedHeight = 525;
  private static final ImageIcon OculusQuest3Image = new ImageIcon("images/OculusQuest3.jpg");
  private static final ImageIcon OculusQuest3ScaledImage = ImageIconScaler.scaleImageIcon(OculusQuest3Image, expandedWidth, expandedHeight);
  private static final String[] detailOculusQuest3 = {"The newest VR headset of the Oculus ", "Quest line has remarkable capabilities ", "and for less than half of the price ", "of its competitors."};
  public OculusQuest3(){
    super(prodName, OculusQuest3Price, OculusQuest3Image, OculusQuest3ScaledImage, detailOculusQuest3);
    OculusQuest3Stock++;
    numOculusQuest3++;
    OculusQuest3_ID = numOculusQuest3;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setStock(int s) {
    OculusQuest3Stock = s;
  }

  public static int getShipSize() {
    return shipSize;
  }

  public static int getOculusQuest3Stock() {
    return OculusQuest3Stock;
  }

  public void sell() {
    OculusQuest3Stock--;
  }

  public static String[] getDetailOculusQuest3() {
    return detailOculusQuest3;
  }
  public static String getProdName() {
    return prodName;
  }

  public static double getOculusQuest3Price() {
    return OculusQuest3Price;
  }
  public static ImageIcon getOculusQuest3Image() {
    return OculusQuest3Image;
  }

  public static ImageIcon getOculusQuest3ScaledImage() {
    return OculusQuest3ScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName + "\u001B[95m\nOculusQuest3 stock ID: \u001B[94m" + OculusQuest3_ID + "\u001B[0m";
  }
}
