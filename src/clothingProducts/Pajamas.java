package src.clothingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Pajamas extends Product {
  private static final String prodName = "Pajamas";
  private static final double pajamasPrice = 24.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon pajamasImage = new ImageIcon("images/pajamas.jpg");
  private static final ImageIcon pajamasScaledImage = ImageIconScaler.scaleImageIcon(pajamasImage, expandedWidth, expandedHeight);
  private static final String[] detailPajamas = {
          "Experience the ultimate relaxation with our cozy-",
          "pajamas, designed for unmatched comfort! Crafted-",
          "from soft, breathable fabric, these pajamas ensur-",
          "e a snug and warm fit for a perfect night's sleep.-",
          "Slip into luxury and unwind in style with our deli-",
          "ghtful pajama collection!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Pajamas() {
    super(prodName, pajamasPrice, pajamasImage, pajamasScaledImage, detailPajamas);
  }

  public static String[] getDetailPajamas() {
    return detailPajamas;
  }

  public static ImageIcon getPajamasImage() {
    return pajamasImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getPajamasPrice() {
    return pajamasPrice;
  }

  public static ImageIcon getPajamasScaledImage() {
    return pajamasScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
