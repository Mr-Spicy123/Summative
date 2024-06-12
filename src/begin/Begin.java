package src.begin;

import src.GUIs.CategoryDisplayFrame;
import src.GUIs.StartFrame;
import src.misc.ObjectCreation;

public class Begin {
  public static void main(String[] args) {
    //new StartFrame();
    new CategoryDisplayFrame(ObjectCreation.getCategories());
  }
}
