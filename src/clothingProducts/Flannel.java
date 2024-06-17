package src.clothingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Flannel extends Product {
  private static final String prodName = "Flannel";
  private static final double flannelPrice = 34.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon flannelImage = new ImageIcon("images/flannel.jpg");
  private static final ImageIcon flannelScaledImage = ImageIconScaler.scaleImageIcon(flannelImage, expandedWidth, expandedHeight);
  private static final String[] detailFlannel = {
          "Meet your new favorite flannel shirt – where comfo-",
          "rt meets classic style! Made from soft, premium co-",
          "tton, this shirt offers a perfect blend of warmth-",
          "and durability for any occasion. Dress it up or do-",
          "wn and enjoy timeless fashion that feels as good as-",
          "it looks!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Flannel() {
    super(prodName, flannelPrice, flannelImage, flannelScaledImage, detailFlannel);
  }

  public static String[] getDetailFlannel() {
    return detailFlannel;
  }

  public static ImageIcon getFlannelImage() {
    return flannelImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getFlannelPrice() {
    return flannelPrice;
  }

  public static ImageIcon getFlannelScaledImage() {
    return flannelScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
