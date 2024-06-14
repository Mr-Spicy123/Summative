package src.gamingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;
public class XBoxSS extends Product {
  private final int XBoxSS_ID;
  private static final int shipSize = 30;
  private static final String prodName = "Xbox Series S";
  private final String name = prodName;
  private static int numXBoxSS = 0;
  private static int XBoxSSStock = 0;
  private static final double XBoxSSPrice = 379.99;
  private static final int expandedWidth = 525;
  private static final int   expandedHeight = 525;
  private static final ImageIcon XBoxSSImage = new ImageIcon("images/XBoxSS.jpg");
  private static final ImageIcon XBoxSSScaledImage = ImageIconScaler.scaleImageIcon(XBoxSSImage, expandedWidth, expandedHeight);
  private static final String[] detailXBoxSS = {"The Xbox Series S has an unbeatable ", "price to performance ratio. Despite ", "the low price, this console is a ", "top-competitor."};
  public XBoxSS(){
    super(prodName, XBoxSSPrice, XBoxSSImage, XBoxSSScaledImage, detailXBoxSS);
    XBoxSSStock++;
    numXBoxSS++;
    XBoxSS_ID = numXBoxSS;
  }

  @Override
  public String getName() {
    return name;
  }

  public static int getShipSize() {
    return shipSize;
  }

  public static void setStock(int s) {
    XBoxSSStock = s;
  }

  public static int getXboxSSStock() {
    return XBoxSSStock;
  }

  public void sell() {
    XBoxSSStock--;
  }

  public static String[] getDetailXBoxSS() {
    return detailXBoxSS;
  }
  public static String getProdName() {
    return prodName;
  }

  public static double getXBoxSSPrice() {
    return XBoxSSPrice;
  }
  public static ImageIcon getXBoxSSImage() {
    return XBoxSSImage;
  }

  public static ImageIcon getXBoxSSScaledImage() {
    return XBoxSSScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName + "\u001B[95m\nXBoxSS stock ID: \u001B[94m" + XBoxSS_ID + "\u001B[0m";
  }
}
