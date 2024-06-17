package src.toyProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Robot extends Product {
  private static final String prodName = "Robot";
  private static final double robotPrice = 139.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon robotImage = new ImageIcon("images/robot.jpg");
  private static final ImageIcon robotScaledImage = ImageIconScaler.scaleImageIcon(robotImage, expandedWidth, expandedHeight);
  private static final String[] detailRobot = {
          "Meet Sphero, your ultimate robotic companion! Pac-",
          "ked with interactive features and programmable ca-",
          "pabilities, Sphero robots inspire creativity and-",
          "learning through play. Whether you're coding mane-",
          "uvers or exploring its advanced tech, Sphero is-",
          "your gateway to endless innovation and fun!"
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Robot() {
    super(prodName, robotPrice, robotImage, robotScaledImage, detailRobot);
  }

  public static String[] getDetailRobot() {
    return detailRobot;
  }

  public static ImageIcon getRobotImage() {
    return robotImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getRobotPrice() {
    return robotPrice;
  }

  public static ImageIcon getRobotScaledImage() {
    return robotScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
