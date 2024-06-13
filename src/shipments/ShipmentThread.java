package src.shipments;

import src.gamingProducts.*;
import src.superClasses.DisplayProduct;
import src.superClasses.Product;

import javax.swing.*;

public class ShipmentThread extends Thread {

  //static boolean run = true;
  static boolean request = false;
  static Product[] prod;
  static String prodClass;
  static DisplayProduct displayProduct;

  public static void delay(int mills) {
    try {
      Thread.sleep(mills);
    } catch (InterruptedException e) {
    }
  }

  public static void setElement(Object[] o, int index, String p) {
    if (p.equals(PS5.getProdName())) {
      o[index] = new PS5();
      displayProduct.setStock(PS5.getStock());
    }
    else if (p.equals(XBoxSS.getProdName())) {
      o[index] = new XBoxSS();
      displayProduct.setStock(XBoxSS.getStock());
    }
    else if (p.equals(XBoxSX.getProdName())) {
      o[index] = new XBoxSX();
      displayProduct.setStock(XBoxSX.getStock());
    }
    else if (p.equals(GamingPC.getProdName())) {
      o[index] = new GamingPC();
      displayProduct.setStock(GamingPC.getStock());
    }
    else if (p.equals(NintendoSwitch.getProdName())) {
      o[index] = new NintendoSwitch();
      displayProduct.setStock(NintendoSwitch.getStock());
    }
    else if (p.equals(OculusQuest3.getProdName())) {
      o[index] = new OculusQuest3();
      displayProduct.setStock(OculusQuest3.getStock());
    }

  }

  public static void requestShip(DisplayProduct d, Product[] p, String pC) {
    prod = new Product[p.length];
    prodClass = pC;
    displayProduct = d;
    request = true;
  }

  public void shipping() {
    JOptionPane.showMessageDialog(null, "New shipment is on its way!");
    delay(10000);
    JOptionPane.showMessageDialog(null, "Shipment has arrived");
    prod = new Product[prod.length];

    for (int i = 0; i < prod.length; i++) {
      setElement(prod, i, prodClass);
      System.out.println(prod[i]);
      System.out.println("\u001B[95mTotal stock of store: \u001B[94m" + Product.getStock() + "\u001B[0m");
      System.out.println("\n------------------------------");
    }
    request = false;
  }

  public void run() {
    if (request) {
      System.out.println("shipment is on its way!");
      shipping();
    }
  }

}




