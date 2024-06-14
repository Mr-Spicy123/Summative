package src.misc;

import src.GUIs.ProductDisplayFrame;
import src.gamingProducts.*;
import src.superClasses.DisplayProduct;
import src.superClasses.Product;

import javax.swing.*;
import java.util.Arrays;

public class Cart {
  static final int maxCartAmount = 50;
  static int cartArrayIndex = 0;
  static DisplayProduct[] prodsInCart = new DisplayProduct[maxCartAmount];
  static JButton[] buttonsForItems = new JButton[maxCartAmount];

  public static void addToCart(DisplayProduct p) {
    prodsInCart[cartArrayIndex] = p;
    buttonsForItems[cartArrayIndex] = new JButton(Integer.toString(cartArrayIndex));
    cartArrayIndex++;
    subtractStock(p);
  }

  public static void removeFromCart(int index) {
    prodsInCart[index] = null;
    buttonsForItems[index] = null;
    DisplayProduct[] temp = new DisplayProduct[maxCartAmount];
    JButton[] tempButtons = new JButton[maxCartAmount];
    //loop for products
    for (int i = 0; i < prodsInCart.length; i++) {
      if (prodsInCart[i] != null) {
        temp[i] = prodsInCart[i];
      }
      else {
        if (i < prodsInCart.length-1) {
          if (prodsInCart[i + 1] != null) {
            temp[i] = prodsInCart[i + 1];
            prodsInCart[i+1] = null;
          }
        }
      }
    }
    //loop for buttons
    for (int i = 0; i < buttonsForItems.length; i++) {
      if (buttonsForItems[i] != null) {
        tempButtons[i] = buttonsForItems[i];
      }
      else {
        if (i < buttonsForItems.length-1) {
          if (buttonsForItems[i + 1] != null) {
            tempButtons[i] = buttonsForItems[i + 1];
            buttonsForItems[i+1] = null;
          }
        }
      }
    }
    //overwriting the data for the products
    for (int i = 0; i <maxCartAmount; i++) {
      prodsInCart[i] = temp[i];
    }
    //overwriting the data for the buttons
    for (int i = 0; i < buttonsForItems.length; i++) {
      buttonsForItems[i] = tempButtons[i];
    }
    //loop to reset the text of the buttons to be in order
    for (int i = 0; i < buttonsForItems.length; i++) {
      if (buttonsForItems[i] != null) {
        buttonsForItems[i].setText(Integer.toString(i));
      }
    }
  }

  public static void removeLastItem() {
    cartArrayIndex--;
    prodsInCart[cartArrayIndex] = null;
    buttonsForItems[cartArrayIndex] = null;
  }

  public static void removeAllItems() {
    Arrays.fill(prodsInCart, null);
    Arrays.fill(buttonsForItems, null);
  }

  public static void checkout() {
    User.subtractBalance(getTotalCost());
    removeAllItems();
  }

  public static double getTotalCost() {
    double cost = 0;
    for (int i = 0; i < prodsInCart.length; i++) {
      cost += prodsInCart[i].getPROD_PRICE();
    }
    return cost;
  }

  public static void subtractStock(DisplayProduct d) {

  }

  public static DisplayProduct[] getCartArray() {
    return prodsInCart;
  }

  public static JButton[] getButtonsArray() {
    return buttonsForItems;
  }
}
