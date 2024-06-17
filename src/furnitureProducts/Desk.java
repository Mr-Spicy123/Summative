package src.furnitureProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Desk extends Product {
  private static final String prodName = "Desk";
  private static final double deskPrice = 249.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon deskImage = new ImageIcon("images/desk.jpg");
  private static final ImageIcon deskScaledImage = ImageIconScaler.scaleImageIcon(deskImage, expandedWidth, expandedHeight);
  private static final String[] detailDesk = {
          "Meet your new productivity hub: our sleek and func-",
          "tional desk, designed to enhance your workflow! With",
          "ample surface area and smart storage solutions, this",
          "desk offers a perfect blend of efficiency and style.",
          "Elevate your workspace and stay organized with a des-",
          "k that's ready to help you tackle any task!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Desk() {
    super(prodName, deskPrice, deskImage, deskScaledImage, detailDesk);
  }

  public static String[] getDetailDesk() {
    return detailDesk;
  }

  public static ImageIcon getDeskImage() {
    return deskImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getDeskPrice() {
    return deskPrice;
  }

  public static ImageIcon getDeskScaledImage() {
    return deskScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
