package src.misc;

import src.GUIs.ProductDisplayFrame;
import src.superClasses.DisplayProduct;
import src.superClasses.Product;

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
    for (int i = 0; i <maxCartAmount; i++) {
      prodsInCart[i] = temp[i];
    }
  }

  public static void removeLastItem() {
    cartArrayIndex--;
    prodsInCart[cartArrayIndex] = null;
  }

  public static void removeAllItems() {
    Arrays.fill(prodsInCart, null);
  }

  public static void checkout() {

  }

  public static DisplayProduct[] getCartArray() {
    return prodsInCart;
  }
}
