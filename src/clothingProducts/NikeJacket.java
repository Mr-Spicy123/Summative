package src.clothingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class NikeJacket extends Product {
  private static final String prodName = "Nike Jacket";
  private static final double JacketPrice = 99.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon JacketImage = new ImageIcon("images/nikeJacket (1) (1).jpg");
  private static final ImageIcon JacketScaledImage = ImageIconScaler.scaleImageIcon(JacketImage, expandedWidth, expandedHeight);
  private static final String[] detailJacket = {
          "Step into spring with the perfect blend of style a-",
          "nd performance in Nike's latest spring jacket! Lig-",
          "htweight and breathable, this jacket offers unpara-",
          "lleled comfort and protection against the elements.-",
          "Elevate your activewear with a jacket that keeps yo-",
          "u looking sharp and feeling great on every adventure!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public NikeJacket() {
    super(prodName, JacketPrice, JacketImage, JacketScaledImage, detailJacket);
  }

  public static String[] getDetailJacket() {
    return detailJacket;
  }

  public static ImageIcon getJacketImage() {
    return JacketImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getJacketPrice() {
    return JacketPrice;
  }

  public static ImageIcon getJacketScaledImage() {
    return JacketScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
