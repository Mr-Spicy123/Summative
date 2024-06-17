package src.clothingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Sweater extends Product {
  private static final String prodName = "Sweater";
  private static final double sweaterPrice = 64.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon sweaterImage = new ImageIcon("images/sweater.jpg");
  private static final ImageIcon sweaterScaledImage = ImageIconScaler.scaleImageIcon(sweaterImage, expandedWidth, expandedHeight);
  private static final String[] detailSweater = {
          "Embrace warmth and style with our luxurious fuzzy-",
          "sweater, perfect for chilly days! Crafted from so-",
          "ft, plush fabric, this sweater offers cozy comfort-",
          "and a chic, relaxed fit. Elevate your winter ward-",
          "robe with a sweater that feels as good as it looks!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Sweater() {
    super(prodName, sweaterPrice, sweaterImage, sweaterScaledImage, detailSweater);
  }

  public static String[] getDetailSweater() {
    return detailSweater;
  }

  public static ImageIcon getSweaterImage() {
    return sweaterImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getSweaterPrice() {
    return sweaterPrice;
  }

  public static ImageIcon getSweaterScaledImage() {
    return sweaterScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
