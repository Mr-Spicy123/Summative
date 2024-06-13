package src.superClasses;

import javax.swing.*;

public class DisplayProduct {
  private int shipSize;
  private final String PROD_NAME;
  private final double PROD_PRICE;
  private int stock;
  private ImageIcon imageRoot;
  private ImageIcon expandedImageRoot;
  private String[] details;
  private Category thisCategory;
  private Product[] object;

  public DisplayProduct(String pN, double pP, ImageIcon iR, ImageIcon eIR, String[] d, int st, Product[] p) {
    PROD_NAME = pN;
    PROD_PRICE = pP;
    imageRoot = iR;
    expandedImageRoot = eIR;
    details = d;
    stock = st;
    object = p;
  }

  public Product[] getObject() {
    return object;
  }
  public int getStock() {
    return stock;
  }

  public void setStock(int s) {
    stock = s;
  }
  public String getProdName() {
    return PROD_NAME;
  }

  public ImageIcon getImageRoot() {
    return imageRoot;
  }

  public ImageIcon getExpandedImageRoot() {
    return expandedImageRoot;
  }

  public String[] getDetails() {
    return details;
  }

  public Category getThisCategory() {
    return thisCategory;
  }

  public void setThisCategory(Category c) {
    thisCategory = c;
  }


  public double getPROD_PRICE() {
    return PROD_PRICE;
  }
  public String toString() {
    return getProdName();
  }


}
