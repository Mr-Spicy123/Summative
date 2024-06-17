package src.gamingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;
public class XBoxSX extends Product {
  private final int XboxSX_ID;
  private static final int shipSize = 30;
  private static final String prodName = "Xbox Series X";
  private final String name = prodName;
  private static int numXboxSX = 0;
  private static int XboxSXStock = 0;
  private static final double XboxSXPrice = 649.99;
  private static final int expandedWidth = 525;
  private static final int   expandedHeight = 525;
  private static final ImageIcon XboxSXImage = new ImageIcon("images/XboxSX.jpg");
  private static final ImageIcon XboxSXScaledImage = ImageIconScaler.scaleImageIcon(XboxSXImage, expandedWidth, expandedHeight);
  private static final String[] detailXboxSX = {
          "Introducing the Xbox Series X, the most powerful-",
          "console ever created! With breathtaking 4K resolu-",
          "tion, lightning-fast load times, and a library of-",
          "thousands of games, the Xbox Series X delivers an-",
          "unrivaled gaming experience. Get ready to elevate-",
          "your play with the next generation of gaming!"
  };
  public XBoxSX(){
    super(prodName, XboxSXPrice, XboxSXImage, XboxSXScaledImage, detailXboxSX);
    XboxSXStock++;
    numXboxSX++;
    XboxSX_ID = numXboxSX;
  }

  @Override
  public String getName() {
    return name;
  }

  public static int getShipSize() {
    return shipSize;
  }

  public static void setStock(int s) {
    XboxSXStock = s;
  }
  public static int getXboxSXStock() {
    return XboxSXStock;
  }

  public void sell() {
    XboxSXStock--;
  }

  public static String[] getDetailXboxSX() {
    return detailXboxSX;
  }
  public static String getProdName() {
    return prodName;
  }

  public static double getXboxSXPrice() {
    return XboxSXPrice;
  }
  public static ImageIcon getXboxSXImage() {
    return XboxSXImage;
  }

  public static ImageIcon getXboxSXScaledImage() {
    return XboxSXScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName + "\u001B[95m\nXboxSX stock ID: \u001B[94m" + XboxSX_ID + "\u001B[0m";
  }
}
