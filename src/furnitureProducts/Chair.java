package src.furnitureProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Chair extends Product {
  private static final String prodName = "Chair";
  private static final double chairPrice = 84.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon chairImage = new ImageIcon("images/chair.jpg");
  private static final ImageIcon chairScaledImage = ImageIconScaler.scaleImageIcon(chairImage, expandedWidth, expandedHeight);
  private static final String[] detailChair = {
          "Elevate your dining experience with our stylish-",
          "dining room chair, blending comfort and elegance-",
          "seamlessly! Crafted with premium materials and-",
          "ergonomic design, this chair offers exceptional-",
          "support and sophistication for every meal. Upgrade-",
          "your dining space with a chair that combines form-",
          "and function beautifully!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Chair() {
    super(prodName, chairPrice, chairImage, chairScaledImage, detailChair);
  }

  public static String[] getDetailChair() {
    return detailChair;
  }

  public static ImageIcon getChairImage() {
    return chairImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getChairPrice() {
    return chairPrice;
  }

  public static ImageIcon getChairScaledImage() {
    return chairScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
