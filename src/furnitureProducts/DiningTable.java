package src.furnitureProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class DiningTable extends Product {
  private static final String prodName = "Dining Table";
  private static final double diningTablePrice = 239.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon diningTableImage = new ImageIcon("images/table.jpg");
  private static final ImageIcon diningTableScaledImage = ImageIconScaler.scaleImageIcon(diningTableImage, expandedWidth, expandedHeight);
  private static final String[] detailDiningTable = {
          "Gather around our versatile dining table, where st-",
          "yle meets functionality! Crafted with durable mat-",
          "erials and a timeless design, this table provides-",
          "ample space for meals and gatherings. Create cheri-",
          "shed memories and enjoy meals in style with a dini-",
          "ng table that complements any decor."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public DiningTable() {
    super(prodName, diningTablePrice, diningTableImage, diningTableScaledImage, detailDiningTable);
  }

  public static String[] getDetailDiningTable() {
    return detailDiningTable;
  }

  public static ImageIcon getDiningTableImage() {
    return diningTableImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getDiningTablePrice() {
    return diningTablePrice;
  }

  public static ImageIcon getDiningTableScaledImage() {
    return diningTableScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
