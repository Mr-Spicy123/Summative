package src.begin;

import src.GUIs.CategoryDisplayFrame;
import src.GUIs.ProductDisplayFrame;
import src.GUIs.SingleProductFrame;
import src.GUIs.StartFrame;
import src.gamingProducts.*;
import src.misc.Cart;
import src.misc.ObjectCreation;

import java.util.Arrays;

public class Begin {
  public static void main(String[] args) {
    new ObjectCreation();
    new StartFrame();
    //new CategoryDisplayFrame(ObjectCreation.getCategories());
  }
}
