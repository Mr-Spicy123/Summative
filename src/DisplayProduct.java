package src;

import javax.swing.*;

public class DisplayProduct {
  private final String PROD_NAME;
  private final double PROD_PRICE;
  private ImageIcon imageRoot;
  private ImageIcon expandedImageRoot;
  private String[] details;

  public DisplayProduct(String pN, double pP, ImageIcon iR, ImageIcon eIR, String[] d) {
    PROD_NAME = pN;
    PROD_PRICE = pP;
    imageRoot = iR;
    expandedImageRoot = eIR;
    details = d;
  }

  public String getProdName() {
    return PROD_NAME;
  }

  public ImageIcon getImageRoot() {
    return imageRoot;
  }

  public ImageIcon getExpandedImageRoot() {
    return expandedImageRoot;
  }

  public String[] getDetails() {
    return details;
  }

}
