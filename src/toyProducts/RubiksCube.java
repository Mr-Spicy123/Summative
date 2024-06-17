package src.toyProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class RubiksCube extends Product {
  private static final String prodName = "Rubik's Cube";
  private static final double rubiksCubePrice = 7.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon rubiksCubeImage = new ImageIcon("images/rubikscube.jpg");
  private static final ImageIcon rubiksCubeScaledImage = ImageIconScaler.scaleImageIcon(rubiksCubeImage, expandedWidth, expandedHeight);
  private static final String[] detailRubiksCube = {
          "Challenge your mind with the timeless Rubik's Cube!-",
          "With its colorful design and complex algorithms,-",
          "this puzzle offers hours of entertainment and brai-",
          "n-teasing fun. Perfect for all ages, the Rubik's Cu-",
          "be is a classic that tests your problem-solving ski-",
          "lls and patience in a captivating way."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public RubiksCube() {
    super(prodName, rubiksCubePrice, rubiksCubeImage, rubiksCubeScaledImage, detailRubiksCube);
  }

  public static String[] getDetailRubiksCube() {
    return detailRubiksCube;
  }

  public static ImageIcon getRubiksCubeImage() {
    return rubiksCubeImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getRubiksCubePrice() {
    return rubiksCubePrice;
  }

  public static ImageIcon getRubiksCubeScaledImage() {
    return rubiksCubeScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
