package src.shoeProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class NB550 extends Product {
  private static final String prodName = "NB550";
  private static final double NB550Price = 67.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon NB550Image = new ImageIcon("images/NB550.jpg");
  private static final ImageIcon NB550ScaledImage = ImageIconScaler.scaleImageIcon(NB550Image, expandedWidth, expandedHeight);
  private static final String[] detailNB550 = {
          "Discover the perfect balance of style and comfort-",
          "with the New Balance 550s! Featuring a retro-inspi-",
          "red design and premium suede and leather construc-",
          "tion, these sneakers offer a timeless aesthetic an-",
          "d superior cushioning. Elevate your everyday look-",
          "with sneakers that deliver on both performance and-",
          "fashion."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public NB550() {
    super(prodName, NB550Price, NB550Image, NB550ScaledImage, detailNB550);
  }

  public static String[] getDetailNB550() {
    return detailNB550;
  }

  public static ImageIcon getNB550Image() {
    return NB550Image;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getNB550Price() {
    return NB550Price;
  }

  public static ImageIcon getNB550ScaledImage() {
    return NB550ScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
