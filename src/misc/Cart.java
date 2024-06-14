package src.misc;

import src.gamingProducts.*;
import src.superClasses.DisplayProduct;

import javax.swing.*;
import java.util.Arrays;

public class Cart {
  static final int maxCartAmount = 50;
  static int cartArrayIndex = 0;
  static DisplayProduct[] prodsInCart = new DisplayProduct[maxCartAmount];

  public static void addToCart(DisplayProduct p) {
    prodsInCart[cartArrayIndex] = p;
    cartArrayIndex++;
  }

  public static void removeFromCart(int index) {
    prodsInCart[index] = null;
    DisplayProduct[] temp = new DisplayProduct[maxCartAmount];
    //loop for products
    for (int i = 0; i < prodsInCart.length; i++) {
      if (prodsInCart[i] != null) {
        temp[i] = prodsInCart[i];
      }
      else if (i < prodsInCart.length-1){
          if (prodsInCart[i + 1] != null) {
            temp[i] = prodsInCart[i + 1];
            prodsInCart[i+1] = null;
        }
      }
    }
    //overwriting the data for the products
    for (int i = 0; i <maxCartAmount; i++) {
      prodsInCart[i] = temp[i];
    }
    //since item was removed, the index goes down by one
    cartArrayIndex--;
    System.out.println(Arrays.toString(prodsInCart));
  }

  public static void removeLastItem() {
    cartArrayIndex--;
    prodsInCart[cartArrayIndex] = null;
  }

  public static void removeAllItems() {
    Arrays.fill(prodsInCart, null);
  }

  public static void checkout() {
    if (CurrentUser.getCurrentBalance() >= getTotalCost()) {
      CurrentUser.subtractBalance(getTotalCost());
      JOptionPane.showMessageDialog(null, "Purchase successful! New balance: " + CurrentUser.getCurrentBalance());
      for (int i = 0; i < prodsInCart.length; i++) {
        if (prodsInCart[i] != null) {
          changeStock(prodsInCart[i]);
        }
      }
    }
    else {
      JOptionPane.showMessageDialog(null, "Purchase unsuccessful. Not enough money :/");
    }
    removeAllItems();
  }

  public static double getTotalCost() {
    double cost = 0;
    for (int i = 0; i < prodsInCart.length; i++) {
      if (prodsInCart[i] != null) {
        cost += prodsInCart[i].getPROD_PRICE();
      }
    }
    return cost;
  }

  public static DisplayProduct[] getCartArray() {
    return prodsInCart;
  }

  public static boolean checkEmpty() {
    for (int i = 0; i < prodsInCart.length; i++) {
      if (prodsInCart[i] != null) {
        return false;
      }
    }
    return true;
  }

  public static void changeStock(DisplayProduct d) {
    System.out.println("changing stock");
    if (d.getProdName().equals(PS5.getProdName())) {
      PS5.setStock(PS5.getStock()-1);
    }
    else if (d.getProdName().equals(XBoxSX.getProdName())) {
      XBoxSX.setStock(XBoxSX.getStock()-1);
    }
    else if (d.getProdName().equals(XBoxSS.getProdName())) {
      XBoxSS.setStock(XBoxSS.getStock()-1);
    }
    else if (d.getProdName().equals(GamingPC.getProdName())) {
      GamingPC.setStock(GamingPC.getStock()-1);
    }
    else if (d.getProdName().equals(NintendoSwitch.getProdName())) {
      NintendoSwitch.setStock(NintendoSwitch.getStock()-1);
    }
    else if (d.getProdName().equals(OculusQuest3.getProdName())) {
      OculusQuest3.setStock(OculusQuest3.getStock()-1);
    }


  }

}
