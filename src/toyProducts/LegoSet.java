package src.toyProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class LegoSet extends Product {
  private static final String prodName = "Lego Set";
  private static final double legoSetPrice = 149.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon legoSetImage = new ImageIcon("images/legoSet.jpg");
  private static final ImageIcon legoSetScaledImage = ImageIconScaler.scaleImageIcon(legoSetImage, expandedWidth, expandedHeight);
  private static final String[] detailLegoSet = {
          "Embark on an epic galactic adventure with the LEGO-",
          "Star Wars set! Build iconic spaceships, recreate-",
          "thrilling battles, and immerse yourself in the Star-",
          "Wars universe like never before. With detailed mini-",
          "figures and authentic designs, this set is perfect-",
          "for fans of all ages to unleash their creativity-",
          "and relive their favorite moments from the saga."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public LegoSet() {
    super(prodName, legoSetPrice, legoSetImage, legoSetScaledImage, detailLegoSet);
  }

  public static String[] getDetailLegoSet() {
    return detailLegoSet;
  }

  public static ImageIcon getLegoSetImage() {
    return legoSetImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getLegoSetPrice() {
    return legoSetPrice;
  }

  public static ImageIcon getLegoSetScaledImage() {
    return legoSetScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
