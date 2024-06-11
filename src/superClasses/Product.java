package src.superClasses;

import src.misc.ImageIconScaler;

import javax.swing.*;
public class Product {
  //instance variables
  private double prodPrice;
  private String prodName;
  private static int numProd = 0;
  private final int prod_ID;
  private final ImageIcon imageRoot;
  private final ImageIcon expandedImageRoot;
  private final String[] details;
  private static int stock = 0;
  private static final ImageIcon defaultImage = new ImageIcon("C:\\Users\\jacks\\OneDrive\\CS_Summative_Images\\noDataImage.jpg");
  private static final int expandedWidth = 525;
  private static final int   expandedHeight = 525;

  //constructor chain
  //default constructor
  public Product() {
    this("no data", 0.0, defaultImage, ImageIconScaler.scaleImageIcon(defaultImage, expandedWidth, expandedHeight), null);
    //remember to prevent default items (which cost $0) to be purchased
  }


  //overloaded constructor
  public Product(String pN, double pP, ImageIcon iR, ImageIcon eIR, String[] d) {
    prodName = pN;
    prodPrice = pP;
    imageRoot = iR;
    expandedImageRoot = eIR;
    details = d;
    stock++;
    numProd++;
    prod_ID = numProd;
  }

  public Product(double pP, ImageIcon iR, ImageIcon eIR, String[] d) {
    this("Product", pP, iR, eIR, d);
  }


  public String toString(){
    return "\nProdName: " + prodName + "\nID: " + prod_ID;
  }
  //getters and setters
  /*public String getProdName() {
    return prodName;
  }*/

  public double getProdPrice() {
    return prodPrice;
  }

  public int getProd_ID() {
    return prod_ID;
  }

  public ImageIcon getImageRoot() {
    return imageRoot;
  }

  public ImageIcon getExpandedImageRoot() {
    return expandedImageRoot;
  }

  public int getExpandedWidth() {
    return expandedWidth;
  }

  public int getExpandedHeight() {
    return expandedHeight;
  }

  public static int getStock() {
    return stock;
  }
  public String[] getDetails() {
    return details;
  }

  public void setProdName(String n) {
    prodName = n;
  }

  public void setProdPrice(double p) {
    prodPrice = p;
  }
  //buy method
}


