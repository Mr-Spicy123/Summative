package src.gamingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;
public class GamingPC extends Product {
  private final int GamingPC_ID;
  private static final int shipSize = 30;
  private static final String prodName = "Gaming PC";
  private final String name = prodName;
  private static int numGamingPC = 0;
  private static int GamingPCStock = 0;
  private static final double GamingPCPrice = 1499.99;
  private static final int expandedWidth = 525;
  private static final int   expandedHeight = 525;
  private static final ImageIcon GamingPCImage = new ImageIcon("images/GamingPC.jpg");
  private static final ImageIcon GamingPCScaledImage = ImageIconScaler.scaleImageIcon(GamingPCImage, expandedWidth, expandedHeight);
  private static final String[] detailGamingPC = {"This is THE top-notch gaming desktop ", "With the latest graphics card, the ", "Nvidia GeForce 4060 RTX, the ", "capabilities of this machine are truly ", "unbeatable!"};
  public GamingPC(){
    super(prodName, GamingPCPrice, GamingPCImage, GamingPCScaledImage, detailGamingPC);
    GamingPCStock++;
    numGamingPC++;
    GamingPC_ID = numGamingPC;
  }

  @Override
  public String getName() {
    return name;
  }

  public static void setStock(int s) {
    GamingPCStock = s;
  }

  public static int getShipSize() {
    return shipSize;
  }

  public static int getGamingPCStock() {
    return GamingPCStock;
  }
  public void sell() {
    GamingPCStock--;
  }

  public static String[] getDetailGamingPC() {
    return detailGamingPC;
  }
  public static String getProdName() {
    return prodName;
  }

  public static double getGamingPCPrice() {
    return GamingPCPrice;
  }
  public static ImageIcon getGamingPCImage() {
    return GamingPCImage;
  }

  public static ImageIcon getGamingPCScaledImage() {
    return GamingPCScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName + "\u001B[95m\nGamingPC stock ID: \u001B[94m" + GamingPC_ID + "\u001B[0m";
  }
}
