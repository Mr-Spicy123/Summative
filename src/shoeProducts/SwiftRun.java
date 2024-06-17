package src.shoeProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class SwiftRun extends Product {
  private static final String prodName = "SwiftRun";
  private static final double swiftRunPrice = 69.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon swiftRunImage = new ImageIcon("images/swiftRun.jpg");
  private static final ImageIcon swiftRunScaledImage = ImageIconScaler.scaleImageIcon(swiftRunImage, expandedWidth, expandedHeight);
  private static final String[] detailSwiftRun = {
          "Stride in style and comfort with the Adidas Swift-",
          "Runners! These sleek sneakers combine a modern si-",
          "lhouette with lightweight materials for effortless-",
          "all-day wear. Whether you're hitting the streets-",
          "or the gym, the Swift Runners deliver versatility-",
          "and performance in every step."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public SwiftRun() {
    super(prodName, swiftRunPrice, swiftRunImage, swiftRunScaledImage, detailSwiftRun);
  }

  public static String[] getDetailSwiftRun() {
    return detailSwiftRun;
  }

  public static ImageIcon getSwiftRunImage() {
    return swiftRunImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getSwiftRunPrice() {
    return swiftRunPrice;
  }

  public static ImageIcon getSwiftRunScaledImage() {
    return swiftRunScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
