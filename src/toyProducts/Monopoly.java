package src.toyProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Monopoly extends Product {
  private static final String prodName = "Monopoly";
  private static final double monopolyPrice = 24.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon monopolyImage = new ImageIcon("images/monopoly.jpg");
  private static final ImageIcon monopolyScaledImage = ImageIconScaler.scaleImageIcon(monopolyImage, expandedWidth, expandedHeight);
  private static final String[] detailMonopoly = {
          "Gather your friends and family for hours of fun-",
          "with the classic Monopoly game! Buy, sell, and-",
          "trade your way to victory as you build monopoli-",
          "es and negotiate deals. With iconic tokens and-",
          "strategic gameplay, Monopoly promises endless-",
          "entertainment and friendly competition for pla-",
          "yers of all ages."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Monopoly() {
    super(prodName, monopolyPrice, monopolyImage, monopolyScaledImage, detailMonopoly);
  }

  public static String[] getDetailMonopoly() {
    return detailMonopoly;
  }

  public static ImageIcon getMonopolyImage() {
    return monopolyImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getMonopolyPrice() {
    return monopolyPrice;
  }

  public static ImageIcon getMonopolyScaledImage() {
    return monopolyScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
