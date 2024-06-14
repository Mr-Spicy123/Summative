package src.begin;

import src.GUIs.*;
import src.gamingProducts.*;
import src.misc.Cart;
import src.misc.ObjectCreation;
import src.superClasses.Category;
import src.superClasses.DisplayProduct;

import java.util.Arrays;

public class Begin {
  public static void main(String[] args) {
    new ObjectCreation();
    new StartFrame();
    //new CategoryDisplayFrame(ObjectCreation.getCategories());
    //new CartViewFrame();
  }
}
