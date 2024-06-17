package src.shoeProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Dunks extends Product {
  private static final String prodName = "Dunks";
  private static final double dunksPrice = 139.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon dunksImage = new ImageIcon("images/dunks.jpg");
  private static final ImageIcon dunksScaledImage = ImageIconScaler.scaleImageIcon(dunksImage, expandedWidth, expandedHeight);
  private static final String[] detailDunks = {
          "Experience the timeless appeal of Nike Dunks, a-",
          "classic sneaker reimagined for today's streets!-",
          "With a retro silhouette and durable construction,-",
          "Nike Dunks offer both style and functionality.-",
          "Elevate your sneaker game with a pair that blends-",
          "heritage design with modern comfort and versatility."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Dunks() {
    super(prodName, dunksPrice, dunksImage, dunksScaledImage, detailDunks);
  }

  public static String[] getDetailDunks() {
    return detailDunks;
  }

  public static ImageIcon getDunksImage() {
    return dunksImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getDunksPrice() {
    return dunksPrice;
  }

  public static ImageIcon getDunksScaledImage() {
    return dunksScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
