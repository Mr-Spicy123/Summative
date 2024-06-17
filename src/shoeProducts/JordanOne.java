package src.shoeProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class JordanOne extends Product {
  private static final String prodName = "JordanOne";
  private static final double jordanOnePrice = 114.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon jordanOneImage = new ImageIcon("images/jordonOne.jpg");
  private static final ImageIcon jordanOneScaledImage = ImageIconScaler.scaleImageIcon(jordanOneImage, expandedWidth, expandedHeight);
  private static final String[] detailJordanOne = {
          "Step into history with the Nike Jordan 1s, an ico-",
          "nic sneaker that revolutionized the game! With it-",
          "s legendary silhouette and premium leather constr-",
          "uction, the Jordan 1s offer unrivaled style and h-",
          "eritage. Elevate your sneaker collection with a ti-",
          "meless classic that celebrates both athleticism an-",
          "d fashion."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public JordanOne() {
    super(prodName, jordanOnePrice, jordanOneImage, jordanOneScaledImage, detailJordanOne);
  }

  public static String[] getDetailJordanOne() {
    return detailJordanOne;
  }

  public static ImageIcon getJordanOneImage() {
    return jordanOneImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getJordanOnePrice() {
    return jordanOnePrice;
  }

  public static ImageIcon getJordanOneScaledImage() {
    return jordanOneScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
