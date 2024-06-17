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
  private static Product[] products = new Product[150];
  private static int productsIndex = 0;

  //constructor chain

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
    products[productsIndex] = this;
    productsIndex++;
  }

  public String toString(){
    return "\nProdName: " + prodName + "\nID: " + prod_ID;
  }

  public String getName() {
    return prodName;
  }

  public static Product[] getProductsArr() {
    return products;
  }

  public static int getStock() {
    return stock;
  }
}