package src.misc;

import src.gamingProducts.*;
import src.superClasses.Category;
import src.superClasses.DisplayProduct;

import javax.swing.*;

public class ObjectCreation {

  static ImageIcon test_image = new ImageIcon("images/noDataImage.jpg");

  //images for categories
  static ImageIcon gamingImage = new ImageIcon("images/gaming - Copy.png");

  //Display product objects represent the features of each product
  //One object is made for every product
  static DisplayProduct PS5Display = new DisplayProduct(PS5.getProdName(), PS5.getPS5Price(), PS5.getPS5Image(), PS5.getPS5ScaledImage(), PS5.getDetailPS5());
  static DisplayProduct XBoxSXDisplay = new DisplayProduct(XBoxSX.getProdName(), XBoxSX.getXboxSXPrice(), XBoxSX.getXboxSXImage(), XBoxSX.getXboxSXScaledImage(), XBoxSX.getDetailXboxSX());
  static DisplayProduct XBoxSSDisplay = new DisplayProduct(XBoxSS.getProdName(), XBoxSS.getXBoxSSPrice(), XBoxSS.getXBoxSSImage(), XBoxSS.getXBoxSSScaledImage(), XBoxSS.getDetailXBoxSS());
  static DisplayProduct gamingPCDisplay = new DisplayProduct(GamingPC.getProdName(), GamingPC.getGamingPCPrice(), GamingPC.getGamingPCImage(), GamingPC.getGamingPCScaledImage(), GamingPC.getDetailGamingPC());
  static DisplayProduct nintendoSwitchDisplay = new DisplayProduct(NintendoSwitch.getProdName(), NintendoSwitch.getNintendoSwitchPrice(), NintendoSwitch.getNintendoSwitchImage(), NintendoSwitch.getNintendoSwitchScaledImage(), NintendoSwitch.getDetailNintendoSwitch());
  static DisplayProduct oculusQuest3Display = new DisplayProduct(OculusQuest3.getProdName(), OculusQuest3.getOculusQuest3Price(), OculusQuest3.getOculusQuest3Image(), OculusQuest3.getOculusQuest3ScaledImage(), OculusQuest3.getDetailOculusQuest3());

  //Arrays of products with 'like categories'
  static DisplayProduct[] arrGamingItems = {PS5Display, XBoxSXDisplay, XBoxSSDisplay, gamingPCDisplay, nintendoSwitchDisplay, oculusQuest3Display};
  static DisplayProduct[] itemsExtraCat = {};


  //category objects
  static Category gaming = new Category(arrGamingItems, "gaming", gamingImage);
  static Category extra = new Category(itemsExtraCat, "extra", test_image);

  //array of all categories
  static Category[] arrCategories = {gaming, extra};

  public static Category[] getCategories() {
    return arrCategories;
  }
}
