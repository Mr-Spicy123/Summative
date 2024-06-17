package src.superClasses;

import src.misc.ImageIconScaler;

import javax.swing.*;
public class Product {
  //instance variables
  private double prodPrice;
  private String prodName;
  private final ImageIcon imageRoot;
  private final ImageIcon expandedImageRoot;
  private final String[] details;

  //constructor chain

  //overloaded constructor
  public Product(String pN, double pP, ImageIcon iR, ImageIcon eIR, String[] d) {
    prodName = pN;
    prodPrice = pP;
    imageRoot = iR;
    expandedImageRoot = eIR;
    details = d;
  }

  public String toString(){
    return "\nProdName: " + prodName;
  }

  public String getName() {
    return prodName;
  }

}