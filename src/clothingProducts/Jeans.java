package src.clothingProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Jeans extends Product {
  private static final String prodName = "Jeans";
  private static final double jeansPrice = 24.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon jeansImage = new ImageIcon("images/jeans.jpg");
  private static final ImageIcon jeansScaledImage = ImageIconScaler.scaleImageIcon(jeansImage, expandedWidth, expandedHeight);
  private static final String[] detailJeans = {
          "Discover the perfect fit with our premium jeans,-",
          "designed for both comfort and style! Made from hi-",
          "gh-quality denim, these jeans offer a flattering-",
          "silhouette and durable wear for every adventure.-",
          "Step out confidently in jeans that combine classi-",
          "c appeal with modern versatility!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Jeans() {
    super(prodName, jeansPrice, jeansImage, jeansScaledImage, detailJeans);
  }

  public static String[] getDetailJeans() {
    return detailJeans;
  }

  public static ImageIcon getJeansImage() {
    return jeansImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getJeansPrice() {
    return jeansPrice;
  }

  public static ImageIcon getJeansScaledImage() {
    return jeansScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
