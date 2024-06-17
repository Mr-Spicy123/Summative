package src.shoeProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class AirMax extends Product {
  private static final String prodName = "AirMax";
  private static final double airMaxPrice = 239.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon airMaxImage = new ImageIcon("images/airMax.jpg");
  private static final ImageIcon airMaxScaledImage = ImageIconScaler.scaleImageIcon(airMaxImage, expandedWidth, expandedHeight);
  private static final String[] detailAirMax = {
          "Step into iconic style and unmatched comfort with-",
          "the Nike Air Max 270s! Featuring a sleek design-",
          "and Nike's signature Air cushioning, these sneak-",
          "ers offer all-day support and a bold look. Eleva-",
          "te your footwear collection with the perfect ble-",
          "nd of fashion and performance in every step."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public AirMax() {
    super(prodName, airMaxPrice, airMaxImage, airMaxScaledImage, detailAirMax);
  }

  public static String[] getDetailAirMax() {
    return detailAirMax;
  }

  public static ImageIcon getAirMaxImage() {
    return airMaxImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getAirMaxPrice() {
    return airMaxPrice;
  }

  public static ImageIcon getAirMaxScaledImage() {
    return airMaxScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
