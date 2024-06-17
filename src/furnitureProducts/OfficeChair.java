package src.furnitureProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class OfficeChair extends Product {
  private static final String prodName = "Office Chair";
  private static final double officeChairPrice = 179.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon officeChairImage = new ImageIcon("images/officeChair.jpg");
  private static final ImageIcon officeChairScaledImage = ImageIconScaler.scaleImageIcon(officeChairImage, expandedWidth, expandedHeight);
  private static final String[] detailOfficeChair = {
          "Experience comfort and support like never before-",
          "with our cozy office chair, designed for long ho-",
          "urs of productivity! Featuring ergonomic design-",
          "and plush cushioning, this chair ensures optimal-",
          "posture and relaxation. Transform your workspace-",
          "into a haven of comfort with an office chair that-",
          "blends comfort and style effortlessly."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public OfficeChair() {
    super(prodName, officeChairPrice, officeChairImage, officeChairScaledImage, detailOfficeChair);
  }

  public static String[] getDetailOfficeChair() {
    return detailOfficeChair;
  }

  public static ImageIcon getOfficeChairImage() {
    return officeChairImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getOfficeChairPrice() {
    return officeChairPrice;
  }

  public static ImageIcon getOfficeChairScaledImage() {
    return officeChairScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
