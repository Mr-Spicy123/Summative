package src;

import javax.swing.*;

public class PS5 extends Product{
  private final int PS5_ID;
  private static final String prodName = "Play Station 5";
  private static int numPS5 = 0;
  private static int PS5Stock = 0;
  private static final double PS5Price = 679.99;
  private static final int expandedWidth = 525;
  private static final int   expandedHeight = 525;
  private static final ImageIcon PS5Image = new ImageIcon("images/PS5.jpg");
  private static final ImageIcon PS5ScaledImage = ImageIconScaler.scaleImageIcon(PS5Image, expandedWidth, expandedHeight);

  private static final String[] detailPS5 = {"The PlayStation 5 is the latest console ", "from Sony with incredible capabilities ", "from graphics, to performance."};
  public PS5(){
    super(prodName, PS5Price, PS5Image, PS5ScaledImage, detailPS5);
    PS5Stock++;
    numPS5++;
    PS5_ID = numPS5;
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

  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName + "\u001B[95m\nPS5 Stock ID: \u001B[94m" + PS5_ID + "\u001B[0m";
  }


}
