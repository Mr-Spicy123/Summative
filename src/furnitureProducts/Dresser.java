package src.furnitureProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Dresser extends Product {
  private static final String prodName = "Dresser";
  private static final double dresserPrice = 149.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon dresserImage = new ImageIcon("images/dresser.jpg");
  private static final ImageIcon dresserScaledImage = ImageIconScaler.scaleImageIcon(dresserImage, expandedWidth, expandedHeight);
  private static final String[] detailDresser = {
          "Introducing our stylish and practical dresser,-",
          "perfect for organizing and enhancing your bedroo-",
          "m! Crafted with spacious drawers and a sleek des-",
          "ign, this dresser offers ample storage for cloth-",
          "es and personal items. Elevate your bedroom deco-",
          "r and keep everything neatly organized with a dr-",
          "esser that combines functionality and elegance."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Dresser() {
    super(prodName, dresserPrice, dresserImage, dresserScaledImage, detailDresser);
  }

  public static String[] getDetailDresser() {
    return detailDresser;
  }

  public static ImageIcon getDresserImage() {
    return dresserImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getDresserPrice() {
    return dresserPrice;
  }

  public static ImageIcon getDresserScaledImage() {
    return dresserScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
