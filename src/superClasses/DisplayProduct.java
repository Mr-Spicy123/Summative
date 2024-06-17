package src.superClasses;

import src.gamingProducts.*;

import javax.swing.*;

public class DisplayProduct {
  private int shipSize;
  private final String PROD_NAME;
  private final double PROD_PRICE;
  private int stock;
  private ImageIcon imageRoot;
  private ImageIcon expandedImageRoot;
  private String[] details;
  private Category thisCategory;
  private Product[] object;

  public DisplayProduct(String pN, double pP, ImageIcon iR, ImageIcon eIR, String[] d, int st, Product[] p) {
    PROD_NAME = pN;
    PROD_PRICE = pP;
    imageRoot = iR;
    expandedImageRoot = eIR;
    details = d;
    stock = st;
    object = p;
  }

  public Product[] getObject() {
    return object;
  }
  public int getStock() {
    if (getProdName().equals(PS5.getProdName())) {
      return PS5.getPS5Stock();
    }
    else if (getProdName().equals(XBoxSX.getProdName())) {
      return XBoxSX.getXboxSXStock();
    }
    else if (getProdName().equals(XBoxSS.getProdName())) {
      return XBoxSS.getXboxSSStock();
    }
    else if (getProdName().equals(GamingPC.getProdName())) {
      return GamingPC.getGamingPCStock();
    }
    else if (getProdName().equals(NintendoSwitch.getProdName())) {
      return NintendoSwitch.getNintendoSwitchStock();
    }
    else if (getProdName().equals(OculusQuest3.getProdName())) {
      return OculusQuest3.getOculusQuest3Stock();
    }
    return 0;
  }

  public void setStock(int s) {
    Product[] p = Product.getProductsArr();
    if (getProdName().equals(PS5.getProdName())) {
      PS5.setStock(s);
    }
    else if (getProdName().equals(XBoxSX.getProdName())) {
      XBoxSX.setStock(s);
    }
    else if (getProdName().equals(XBoxSS.getProdName())) {
      XBoxSS.setStock(s);
    }
    else if (getProdName().equals(GamingPC.getProdName())) {
      GamingPC.setStock(s);
    }
    else if (getProdName().equals(NintendoSwitch.getProdName())) {
      NintendoSwitch.setStock(s);
    }
    else if (getProdName().equals(OculusQuest3.getProdName())) {
      OculusQuest3.setStock(s);
    }
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

  public Category getThisCategory() {
    return thisCategory;
  }

  public void setThisCategory(Category c) {
    thisCategory = c;
  }


  public double getPROD_PRICE() {
    return PROD_PRICE;
  }
  public String toString() {
    return getProdName();
  }


}
