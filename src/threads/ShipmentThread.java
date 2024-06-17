package src.threads;

import src.FileIO.Reader;
import src.GUIs.RewriteFile;
import src.gamingProducts.*;
import src.superClasses.DisplayProduct;
import src.superClasses.Product;

import javax.swing.*;

public class ShipmentThread extends Thread {

  //static boolean run = true;
  static String prodName;

  public ShipmentThread(String pN) {
    prodName = pN;
  }

  public static void delay(int mills) {
    try {
      Thread.sleep(mills);
    } catch (InterruptedException e) {
    }
  }

  public static void ship() {
    delay(10000);
    JOptionPane.showMessageDialog(null, "Shipment has arrived");
    RewriteFile.rewriteStock(prodName, Integer.toString(Reader.getStock(prodName) + 15));
  }

  public void run() {
    ship();
  }

}




