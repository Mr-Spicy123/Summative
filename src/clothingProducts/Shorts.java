package src.clothingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Shorts extends Product {
  private static final String prodName = "Shorts";
  private static final double shortsPrice = 24.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon shortsImage = new ImageIcon("images/shorts.jpg");
  private static final ImageIcon shortsScaledImage = ImageIconScaler.scaleImageIcon(shortsImage, expandedWidth, expandedHeight);
  private static final String[] detailShorts = {
          "Get ready for summer with our brand new shorts,-",
          "the perfect blend of style and comfort! Made from-",
          "lightweight, breathable fabric, these shorts offer-",
          "a modern fit and versatile design for any occasion.-",
          "Stay cool and look great with shorts that move with-",
          "you all day long!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Shorts() {
    super(prodName, shortsPrice, shortsImage, shortsScaledImage, detailShorts);
  }

  public static String[] getDetailShorts() {
    return detailShorts;
  }

  public static ImageIcon getShortsImage() {
    return shortsImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getShortsPrice() {
    return shortsPrice;
  }

  public static ImageIcon getShortsScaledImage() {
    return shortsScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
