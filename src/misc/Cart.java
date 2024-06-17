package src.misc;

import src.FileIO.Reader;
import src.GUIs.RewriteFile;
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
      } else if (i < prodsInCart.length - 1) {
        if (prodsInCart[i + 1] != null) {
          temp[i] = prodsInCart[i + 1];
          prodsInCart[i + 1] = null;
        }
      }
    }
    //overwriting the data for the products
    for (int i = 0; i < maxCartAmount; i++) {
      prodsInCart[i] = temp[i];
    }
    //since item was removed, the index goes down by one
    cartArrayIndex--;
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
      JOptionPane.showMessageDialog(null, "Purchase successful!");
      removeAllItems();
      for (int i = 0; i < prodsInCart.length; i++) {
        if (prodsInCart[i] != null) {
          changeStock(prodsInCart[i]);
        }
      }
    } else {
      JOptionPane.showMessageDialog(null, "Purchase unsuccessful. Not enough money :/");
    }
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
    RewriteFile.rewriteStock(d.getProdName(), Integer.toString(Reader.getStock(d.getProdName()) - 1));
  }

  public static boolean underItemStock() {
    //get array of all product names
    String[] cartArrNames = Reader.getArray(Reader.stockFile);
    for (int i = 0; i < cartArrNames.length; i++) {
      String[] element = cartArrNames[i].split(":");
      cartArrNames[i] = element[0];
    }
    DisplayProduct[] items = Cart.getCartArray();

    int itemCount = 0;
    for (int i = 0; i < cartArrNames.length; i++) {
        int stock = Reader.getStock(cartArrNames[i]);
        for (int j = 0; j < items.length; j++) {
          if (items[j] != null) {
            if (cartArrNames[i].equals(items[j].getProdName())) {
              itemCount++;
            }
          }
        }

        if (stock < itemCount) {
          JOptionPane.showMessageDialog(null, "Not enough stock in " + cartArrNames[i] );
          return false;
        }
        itemCount=0;
    }
    return true;
  }
}
