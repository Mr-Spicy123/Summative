package src.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.FileIO.Reader;
import src.FileIO.Writer;
import src.clothingProducts.*;
import src.furnitureProducts.*;
import src.gamingProducts.*;
import src.shoeProducts.*;
import src.superClasses.Category;
import src.superClasses.DisplayProduct;
import src.superClasses.Product;
import src.toyProducts.*;

import javax.swing.*;

public class ObjectCreation {

  static ImageIcon test_image = new ImageIcon("images/noDataImage.jpg");

  //images for categories
  static ImageIcon gamingImage = new ImageIcon("images/gaming - Copy.png");

  static Category[] arrCategories;




  public static Category[] getCategories() {
    return arrCategories;
  }

  public ObjectCreation() {
    //Display product objects represent the features of each product
    //One object is made for every product

    Category gaming;
    Category clothing;
    Category shoes;
    Category furniture;
    Category toys;

    //gaming display products
    DisplayProduct PS5Display = new DisplayProduct(PS5.getProdName(), PS5.getPS5Price(), PS5.getPS5Image(), PS5.getPS5ScaledImage(), PS5.getDetailPS5());
    DisplayProduct XBoxSXDisplay = new DisplayProduct(XBoxSX.getProdName(), XBoxSX.getXboxSXPrice(), XBoxSX.getXboxSXImage(), XBoxSX.getXboxSXScaledImage(), XBoxSX.getDetailXboxSX());
    DisplayProduct XBoxSSDisplay = new DisplayProduct(XBoxSS.getProdName(), XBoxSS.getXBoxSSPrice(), XBoxSS.getXBoxSSImage(), XBoxSS.getXBoxSSScaledImage(), XBoxSS.getDetailXBoxSS());
    DisplayProduct gamingPCDisplay = new DisplayProduct(GamingPC.getProdName(), GamingPC.getGamingPCPrice(), GamingPC.getGamingPCImage(), GamingPC.getGamingPCScaledImage(), GamingPC.getDetailGamingPC());
    DisplayProduct nintendoSwitchDisplay = new DisplayProduct(NintendoSwitch.getProdName(), NintendoSwitch.getNintendoSwitchPrice(), NintendoSwitch.getNintendoSwitchImage(), NintendoSwitch.getNintendoSwitchScaledImage(), NintendoSwitch.getDetailNintendoSwitch());
    DisplayProduct oculusQuest3Display = new DisplayProduct(OculusQuest3.getProdName(), OculusQuest3.getOculusQuest3Price(), OculusQuest3.getOculusQuest3Image(), OculusQuest3.getOculusQuest3ScaledImage(), OculusQuest3.getDetailOculusQuest3());

    //clothing display products
    DisplayProduct FlannelDisplay = new DisplayProduct(Flannel.getProdName(), Flannel.getFlannelPrice(), Flannel.getFlannelImage(), Flannel.getFlannelScaledImage(), Flannel.getDetailFlannel());
    DisplayProduct JeansDisplay = new DisplayProduct(Jeans.getProdName(), Jeans.getJeansPrice(), Jeans.getJeansImage(), Jeans.getJeansScaledImage(), Jeans.getDetailJeans());
    DisplayProduct NikeJacketDisplay = new DisplayProduct(NikeJacket.getProdName(), NikeJacket.getJacketPrice(), NikeJacket.getJacketImage(), NikeJacket.getJacketScaledImage(), NikeJacket.getDetailJacket());
    DisplayProduct PajamasDisplay = new DisplayProduct(Pajamas.getProdName(), Pajamas.getPajamasPrice(), Pajamas.getPajamasImage(), Pajamas.getPajamasScaledImage(), Pajamas.getDetailPajamas());
    DisplayProduct ShortsDisplay = new DisplayProduct(Shorts.getProdName(), Shorts.getShortsPrice(), Shorts.getShortsImage(), Shorts.getShortsScaledImage(), Shorts.getDetailShorts());
    DisplayProduct SweaterDisplay = new DisplayProduct(Sweater.getProdName(), Sweater.getSweaterPrice(), Sweater.getSweaterImage(), Sweater.getSweaterScaledImage(), Sweater.getDetailSweater());

    //shoes display products
    DisplayProduct airMaxDisplay = new DisplayProduct(AirMax.getProdName(), AirMax.getAirMaxPrice(), AirMax.getAirMaxImage(), AirMax.getAirMaxScaledImage(), AirMax.getDetailAirMax());
    DisplayProduct dunksDisplay = new DisplayProduct(Dunks.getProdName(), Dunks.getDunksPrice(), Dunks.getDunksImage(), Dunks.getDunksScaledImage(), Dunks.getDetailDunks());
    DisplayProduct jordanOneDisplay = new DisplayProduct(JordanOne.getProdName(), JordanOne.getJordanOnePrice(), JordanOne.getJordanOneImage(), JordanOne.getJordanOneScaledImage(), JordanOne.getDetailJordanOne());
    DisplayProduct NB550Display = new DisplayProduct(NB550.getProdName(), NB550.getNB550Price(), NB550.getNB550Image(), NB550.getNB550ScaledImage(), NB550.getDetailNB550());
    DisplayProduct swiftRunDisplay = new DisplayProduct(SwiftRun.getProdName(), SwiftRun.getSwiftRunPrice(), SwiftRun.getSwiftRunImage(), SwiftRun.getSwiftRunScaledImage(), SwiftRun.getDetailSwiftRun());

    //furniture display products
    DisplayProduct couchDisplay = new DisplayProduct(Couch.getProdName(), Couch.getCouchPrice(), Couch.getCouchImage(), Couch.getCouchScaledImage(), Couch.getDetailCouch());
    DisplayProduct bedDisplay = new DisplayProduct(Bed.getProdName(), Bed.getBedPrice(), Bed.getBedImage(), Bed.getBedScaledImage(), Bed.getDetailBed());
    DisplayProduct chairDisplay = new DisplayProduct(Chair.getProdName(), Chair.getChairPrice(), Chair.getChairImage(), Chair.getChairScaledImage(), Chair.getDetailChair());
    DisplayProduct deskDisplay = new DisplayProduct(Desk.getProdName(), Desk.getDeskPrice(), Desk.getDeskImage(), Desk.getDeskScaledImage(), Desk.getDetailDesk());
    DisplayProduct diningTableDisplay = new DisplayProduct(DiningTable.getProdName(), DiningTable.getDiningTablePrice(), DiningTable.getDiningTableImage(), DiningTable.getDiningTableScaledImage(), DiningTable.getDetailDiningTable());
    DisplayProduct dresserDisplay = new DisplayProduct(Dresser.getProdName(), Dresser.getDresserPrice(), Dresser.getDresserImage(), Dresser.getDresserScaledImage(), Dresser.getDetailDresser());
    DisplayProduct officeChairDisplay = new DisplayProduct(OfficeChair.getProdName(), OfficeChair.getOfficeChairPrice(), OfficeChair.getOfficeChairImage(), OfficeChair.getOfficeChairScaledImage(), OfficeChair.getDetailOfficeChair());

    //toys display products
    DisplayProduct legoSetDisplay = new DisplayProduct(LegoSet.getProdName(), LegoSet.getLegoSetPrice(), LegoSet.getLegoSetImage(), LegoSet.getLegoSetScaledImage(), LegoSet.getDetailLegoSet());
    DisplayProduct transformerDisplay = new DisplayProduct(Transformer.getProdName(), Transformer.getTransformerPrice(), Transformer.getTransformerImage(), Transformer.getTransformerScaledImage(), Transformer.getDetailTransformer());
    DisplayProduct rubiksCubeDisplay = new DisplayProduct(RubiksCube.getProdName(), RubiksCube.getRubiksCubePrice(), RubiksCube.getRubiksCubeImage(), RubiksCube.getRubiksCubeScaledImage(), RubiksCube.getDetailRubiksCube());
    DisplayProduct monopolyDisplay = new DisplayProduct(Monopoly.getProdName(), Monopoly.getMonopolyPrice(), Monopoly.getMonopolyImage(), Monopoly.getMonopolyScaledImage(), Monopoly.getDetailMonopoly());
    DisplayProduct robotDisplay = new DisplayProduct(Robot.getProdName(), Robot.getRobotPrice(), Robot.getRobotImage(), Robot.getRobotScaledImage(), Robot.getDetailRobot());

    //Arrays of products with 'like categories'
    DisplayProduct[] gamingItems = {PS5Display, XBoxSXDisplay, XBoxSSDisplay, gamingPCDisplay, nintendoSwitchDisplay, oculusQuest3Display};
    insertionSort(gamingItems);
    gaming = new Category (gamingItems, "gaming", gamingImage);
    //set these DisplayProduct's category to gaming
    for (int i = 0; i < gamingItems.length; i++) {
      gamingItems[i].setThisCategory(gaming);
    }

    DisplayProduct[] clothingItems = {FlannelDisplay, JeansDisplay, NikeJacketDisplay, PajamasDisplay, ShortsDisplay, SweaterDisplay};
    insertionSort(clothingItems);
    clothing = new Category(clothingItems, "clothing", new ImageIcon("images/clothing.png"));
    //set these DisplayProduct's category to clothing
    for (int i = 0; i < clothingItems.length; i++) {
      clothingItems[i].setThisCategory(clothing);
    }

    DisplayProduct[] shoesItems = {airMaxDisplay, dunksDisplay, jordanOneDisplay, NB550Display, swiftRunDisplay};
    insertionSort(shoesItems);
    shoes = new Category(shoesItems, "shoes", new ImageIcon("images/shoes.png"));
    //set these DisplayProduct's category to shoes
    for (int i = 0; i < shoesItems.length; i++) {
      shoesItems[i].setThisCategory(shoes);
    }

    DisplayProduct[] furnitureItems = {bedDisplay, chairDisplay, couchDisplay, deskDisplay, diningTableDisplay, dresserDisplay, officeChairDisplay};
    insertionSort(furnitureItems);
    furniture = new Category(furnitureItems, "furniture", new ImageIcon("images/furniture.png"));
    //set these DisplayProduct's category to furniture
    for (int i = 0; i < furnitureItems.length; i++) {
      furnitureItems[i].setThisCategory(furniture);
    }

    DisplayProduct[] toysItems = {legoSetDisplay, transformerDisplay, rubiksCubeDisplay, monopolyDisplay, robotDisplay};
    insertionSort(toysItems);
    toys = new Category(toysItems, "toys", new ImageIcon("images/toys.jpg"));
    //set these DisplayProduct's category to toys
    for (int i = 0; i < toysItems.length; i++) {
      toysItems[i].setThisCategory(toys);
    }

    //list of all the display product arrays combined
    List<DisplayProduct> mergeOfArrays = new ArrayList<>(Arrays.asList(gamingItems));
    mergeOfArrays.addAll(Arrays.asList(clothingItems));
    mergeOfArrays.addAll(Arrays.asList(shoesItems));
    mergeOfArrays.addAll(Arrays.asList(furnitureItems));
    mergeOfArrays.addAll(Arrays.asList(toysItems));
    //array of all the display products
    DisplayProduct[] allDisplayProducts = mergeOfArrays.toArray(new DisplayProduct[0]);
    System.out.println(Arrays.toString(allDisplayProducts));

    for (int i = 0; i <allDisplayProducts.length; i++) {
      //if the item is new, write their stock in the stock file
      if (!Reader.inStockFile(allDisplayProducts[i].getProdName())) {
        //new items start at 15 stock
        Writer.writeFile(allDisplayProducts[i].getProdName() + ":15", Writer.stockFile);
      }
    }

    //array of all categories
    Category[] categories = {gaming, clothing, shoes, furniture, toys};
    insertionSort(categories);
    arrCategories = new Category[categories.length];
    for (int i = 0; i < arrCategories.length; i++) {
      arrCategories[i] = categories[i];
    }

  }

  public static void insertionSort(DisplayProduct[] d) {
      //'i' represents going through the array itself
      for (int i = 1; i < d.length; i++) {
        //'j' represents the current number, and 'j-1' is what it's comparing to (number to the left)
        for (int j = i; j >= 1; j--) {
          //if element is less than the element to the left, then swap
          if (d[j].compareTo(d[j - 1]) > 0) {
            //this will swap s at index j with s at index j-1 (element to the left)
            DisplayProduct temp = d[j];
            d[j] = d[j-1];
            d[j-1] = temp;

          }
          else {
            break;
          }
        }//end of j loop
      }//end of i loop
  }
  public static void insertionSort(Category[] c) {
    //'i' represents going through the array itself
    for (int i = 1; i < c.length; i++) {
      //'j' represents the current number, and 'j-1' is what it's comparing to (number to the left)
      for (int j = i; j >= 1; j--) {
        //if element is less than the element to the left, then swap
        if (c[j].compareTo(c[j - 1]) > 0) {
          //this will swap s at index j with s at index j-1 (element to the left)
          Category temp = c[j];
          c[j] = c[j-1];
          c[j-1] = temp;
        }
        else {
          break;
        }
      }//end of j loop
    }//end of i loop
  }

}
