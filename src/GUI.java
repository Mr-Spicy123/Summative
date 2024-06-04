package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
  public static void main(String[] args) {

    //ImageIcons
    //no data image
    ImageIcon test_image = new ImageIcon("C:\\Users\\jacks\\OneDrive\\CS_Summative_Images\\noDataImage.jpg");

    //images for categories
    ImageIcon gamingImage = new ImageIcon("C:\\Users\\jacks\\OneDrive\\CS_Summative_Images\\gaming - Copy.png");

    //Display product objects represent the features of each product
    //One object is made for every product
    DisplayProduct PS5Display = new DisplayProduct(PS5.getProdName(), PS5.getPS5Price(), PS5.getPS5Image(), PS5.getPS5ScaledImage(), PS5.getDetailPS5());
    DisplayProduct XBoxSXDisplay = new DisplayProduct(XBoxSX.getProdName(), XBoxSX.getXboxSXPrice(), XBoxSX.getXboxSXImage(), XBoxSX.getXboxSXScaledImage(), XBoxSX.getDetailXboxSX());
    DisplayProduct XBoxSSDisplay = new DisplayProduct(XBoxSS.getProdName(), XBoxSS.getXBoxSSPrice(), XBoxSS.getXBoxSSImage(), XBoxSS.getXBoxSSScaledImage(), XBoxSS.getDetailXBoxSS());
    DisplayProduct gamingPCDisplay = new DisplayProduct(GamingPC.getProdName(), GamingPC.getGamingPCPrice(), GamingPC.getGamingPCImage(), GamingPC.getGamingPCScaledImage(), GamingPC.getDetailGamingPC());
    DisplayProduct nintendoSwitchDisplay = new DisplayProduct(NintendoSwitch.getProdName(), NintendoSwitch.getNintendoSwitchPrice(), NintendoSwitch.getNintendoSwitchImage(), NintendoSwitch.getNintendoSwitchScaledImage(), NintendoSwitch.getDetailNintendoSwitch());
    DisplayProduct oculusQuest3Display = new DisplayProduct(OculusQuest3.getProdName(), OculusQuest3.getOculusQuest3Price(), OculusQuest3.getOculusQuest3Image(), OculusQuest3.getOculusQuest3ScaledImage(), OculusQuest3.getDetailOculusQuest3());

    //Arrays of products with 'like categories'
    DisplayProduct[] arrGamingItems = {PS5Display, XBoxSXDisplay, XBoxSSDisplay, gamingPCDisplay, nintendoSwitchDisplay, oculusQuest3Display};
    DisplayProduct[] itemsExtraCat = {};


    //category objects
    Category gaming = new Category(arrGamingItems, "gaming", gamingImage);
    Category extra = new Category(itemsExtraCat, "extra", test_image);

    //array of all categories
    Category[] arrCategories = {gaming, extra};

    //create and prep frame
    JFrame frame = new JFrame("Website");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setBounds(0, 0, 1536, 864);

    //create new ShipmentThread
    ShipmentThread thread = new ShipmentThread();
    //start running the thread
    thread.start();
    //request a shipment of 10 Xbox series s
    thread.requestShip(new XBoxSS[10], XBoxSS.getProdName());
    //run the framePrep method that displays each category
    Website.framePrep(arrCategories, frame);
  }

  public static void framePrep(Category[] categories, JFrame frame) {
    //initial x and y coordinates for image placement
    int xPos = 75;
    int yPos = 150;

    //dimensions for labels and buttons
    int nameLabelWidth = 225;
    int nameLabelHeight = 25;

    int imageButtonWidth = 225;
    int imageButtonHeight = 225;

    //rowCounter to make a row cap
    int rowCounter = 0;
    int maxRowCount = 5;

    JPanel panel = new JPanel();
    panel.setBackground(Color.blue);
    frame.setContentPane(panel);

    //declare JLabels, ImageIcons and Fonts
    ImageIcon image;
    JLabel itemNameLabel;
    JButton imageButton;
    //array of buttons to store each button in
    JButton[] buttons = new JButton[categories.length];
    Font font = new Font("Arial", Font.BOLD, 24);


    //for loop to place images and names
    for (int i = 0; i < categories.length; i++) {
      //place item names
      itemNameLabel = new JLabel(categories[i].getCategoryName());
      panel.add(itemNameLabel);
      itemNameLabel.setFont(font);
      itemNameLabel.setForeground(Color.green);
      itemNameLabel.setBounds(xPos, yPos + imageButtonHeight, nameLabelWidth, nameLabelHeight);
      itemNameLabel.setVisible(true);
      frame.setLayout(null);
      //place images
      image = categories[i].getImageRoot();
      imageButton = new JButton(image);
      buttons[i] = imageButton;
      panel.add(imageButton);
      imageButton.setBounds(xPos, yPos, imageButtonWidth, imageButtonHeight);
      //position adjustments for the next placement
      xPos += 275;
      rowCounter++;
      //if the row has ended
      if (rowCounter == maxRowCount) {
        yPos += 300;
        xPos = 75;
      }
      imageButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          for (int i = 0; i < categories.length; i++) {
            //if the button that was pressed is equal to the id of the buttons at i
            if (e.getSource() == buttons[i]) {
              //hide this panel
              panel.setVisible(false);
              //run the framePrep method that places the products of the category in question
              framePrep(categories[i].getItems(), frame);
            }
          }
        }
      });
    }
    //show the frame with all the categories osn it
    frame.setVisible(true);
  }

  //framePrep method specifically for laying out the products of a category
  public static void framePrep(DisplayProduct[] products, JFrame frame) {
    //initial x and y coordinates
    int xPos = 75;
    int yPos = 150;

    //variables used in the following for loop
    //dimensions of each label
    int nameLabelWidth = 225;
    int nameLabelHeight = 25;

    //dimensions of each image
    int imageLabelWidth = 225;
    int imageLabelHeight = 225;

    //rowCounter to make a row cap
    int rowCounter = 0;

    //declare JLabels and ImageIcons
    ImageIcon image;
    JButton imageButton;
    JButton[] allButtons = new JButton[products.length];
    JLabel itemNameLabel;
    Font font = new Font("Arial", Font.BOLD, 24);

    JPanel panel = new JPanel();
    panel.setBackground(Color.blue);
    frame.setContentPane(panel);


    //for loop to place images and names
    for (int i = 0; i < products.length; i++) {
      //place item names
      itemNameLabel = new JLabel(products[i].getProdName());
      panel.add(itemNameLabel);
      itemNameLabel.setFont(font);
      itemNameLabel.setForeground(Color.green);
      itemNameLabel.setBounds(xPos, yPos+imageLabelHeight, nameLabelWidth, nameLabelHeight);
      itemNameLabel.setVisible(true);
      //place images
      image = products[i].getImageRoot();
      imageButton = new JButton(image);
      frame.setLayout(null);
      panel.add(imageButton);
      imageButton.setBounds(xPos, yPos, imageLabelWidth, imageLabelHeight);
      allButtons[i] = imageButton;
      xPos+=275;
      rowCounter++;
      //if the row has ended
      if (rowCounter == 5) {
        yPos+=300;
        xPos=75;
      }
      imageButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          for (int i = 0; i < products.length; i++) {
            //if the button that was pressed is equal to the id of the buttons at i
            if (e.getSource() == allButtons[i]) {
              //hide this panel
              panel.setVisible(false);
              //run the framePrep method that places the products of the category in question
              framePrep(products[i], frame);
            }
          }
        }
      });
    }
    frame.setVisible(true);
  }

  //framePrep method specifically for laying out a single product with more information
  public static void framePrep(DisplayProduct prod, JFrame frame) {
    //x and y coordinates for the image
    int xPos = 75;
    int yPos = 100;

    //variables used in the following for loop
    //dimensions of each label
    int nameLabelWidth = 525;
    int nameLabelHeight = 30;

    //dimensions of image
    int imageLabelWidth = 525;
    int imageLabelHeight = 525;

    //declare JLabels and ImageIcon
    ImageIcon image;
    JLabel imageLabel;
    JLabel itemNameLabel;

    //making font object for the text
    Font font = new Font("Arial", Font.BOLD, 29);

    //prep the panel
    JPanel panel = new JPanel();
    panel.setBackground(Color.blue);
    frame.setContentPane(panel);

    //place item name
    int detailY = yPos;
    for (int i = 0; i < prod.getDetails().length; i++) {
      itemNameLabel = new JLabel(prod.getDetails()[i]);
      panel.add(itemNameLabel);
      itemNameLabel.setFont(font);
      itemNameLabel.setForeground(Color.BLACK);
      itemNameLabel.setBounds(xPos+imageLabelWidth+225, detailY, nameLabelWidth, nameLabelHeight);
      detailY+=35;
    }

    //place image
    image = prod.getExpandedImageRoot();
    imageLabel = new JLabel(image);
    frame.setLayout(null);
    panel.add(imageLabel);
    imageLabel.setBounds(xPos, yPos, imageLabelWidth, imageLabelHeight);
    frame.setVisible(true);
  }
}
