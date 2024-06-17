package src.furnitureProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Couch extends Product {
  private static final String prodName = "Couch";
  private static final double couchPrice = 399.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon couchImage = new ImageIcon("images/couch.jpg");
  private static final ImageIcon couchScaledImage = ImageIconScaler.scaleImageIcon(couchImage, expandedWidth, expandedHeight);
  private static final String[] detailCouch = {
          "Introducing our incredibly comfortable and affor-",
          "dably priced couch, perfect for lounging and rela-",
          "xing! Crafted with plush cushions and durable up-",
          "holstery, this couch offers the ideal balance of-",
          "comfort and value. Transform your living room into-",
          "a cozy haven with a couch that invites you to unwin-",
          "d in style!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Couch() {
    super(prodName, couchPrice, couchImage, couchScaledImage, detailCouch);
  }

  public static String[] getDetailCouch() {
    return detailCouch;
  }

  public static ImageIcon getCouchImage() {
    return couchImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getCouchPrice() {
    return couchPrice;
  }

  public static ImageIcon getCouchScaledImage() {
    return couchScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
