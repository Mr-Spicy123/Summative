package src.furnitureProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Bed extends Product {
  private static final String prodName = "Bed";
  private static final double bedPrice = 214.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon bedImage = new ImageIcon("images/bed.jpg");
  private static final ImageIcon bedScaledImage = ImageIconScaler.scaleImageIcon(bedImage, expandedWidth, expandedHeight);
  private static final String[] detailBed = {
          "Indulge in the ultimate comfort with our luxurious-",
          "bed, designed for restful nights and rejuvenating-",
          "sleep! Crafted with plush materials and ergonomic-",
          "support, our bed offers a cozy sanctuary for relax-",
          "ation and deep slumber. Experience the epitome of-",
          "comfort and wake up refreshed every morning!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Bed() {
    super(prodName, bedPrice, bedImage, bedScaledImage, detailBed);
  }

  public static String[] getDetailBed() {
    return detailBed;
  }

  public static ImageIcon getBedImage() {
    return bedImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getBedPrice() {
    return bedPrice;
  }

  public static ImageIcon getBedScaledImage() {
    return bedScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
