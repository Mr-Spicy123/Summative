package src.gamingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class PS5 extends Product {
  private static final int shipSize = 30;
  private final int PS5_ID;
  private static final String prodName = "Play Station 5";
  private static int numPS5 = 0;
  private static int PS5Stock = 0;
  private static final double PS5Price = 679.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon PS5Image = new ImageIcon("images/PS5.jpg");
  private static final ImageIcon PS5ScaledImage = ImageIconScaler.scaleImageIcon(PS5Image, expandedWidth, expandedHeight);
  //The PlayStation 5's main hardware features in-,,,clude a solid-state drive customized for hi-,,,gh-speed data streaming to enable significant,,, improvements in storage performance, an AMD ,,,GPU capable of 4K resolution display at up to,,, 120 frames per second, hardware-accelerated ,,,ray tracing for realistic lighting and reflec-,,,tions
  //private static final String[] detailPS5 = {"The PlayStation 5's main hardware features in-", "clude a solid-state drive customized for hi-", "gh-speed data streaming to enable significant", "improvements in storage performance, an AMD", "GPU capable of 4K resolution display at up to", "120 frames per second, hardware-accelerated", "ray tracing for realistic lighting and reflec-", "tions"};
  private static final String[] detailPS5 = {
          "The PlayStation 5's main hardware features in-",
          "clude a solid-state drive customized for hi-",
          "gh-speed data streaming to enable significant",
          "improvements in storage performance, an AMD",
          "GPU capable of 4K resolution display at up to",
          "120 frames per second, hardware-accelerated",
          "ray tracing for realistic lighting and reflec-",
          "tions"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public PS5() {
    super(prodName, PS5Price, PS5Image, PS5ScaledImage, detailPS5);
    PS5Stock++;
    numPS5++;
    PS5_ID = numPS5;
  }

  public static int getShipSize() {
    return shipSize;
  }
  public void sell() {
    PS5Stock--;
  }

  public static String[] getDetailPS5() {
    return detailPS5;
  }

  public static ImageIcon getPS5Image() {
    return PS5Image;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getPS5Price() {
    return PS5Price;
  }

  public static ImageIcon getPS5ScaledImage() {
    return PS5ScaledImage;
  }

  public static int getPS5Stock() {
    return PS5Stock;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName + "\u001B[95m\nPS5 Stock ID: \u001B[94m" + PS5_ID + "\u001B[0m";
  }


}
