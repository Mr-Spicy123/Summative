package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Website {
  //instance variables
  private String webName;
  private String logoImagePath;
  private Category[] categories;


  //constructor chain
  //default constructor
  public Website() {
    this ("no data", "C:\\Users\\jacks\\OneDrive\\CS_Summative_Images\\noDataImage.jpg", null);
  }


  //overloaded constructor
  public Website(String webName, String logoImagePath, Category[] categories) {
    this.webName = webName;
    this.logoImagePath = logoImagePath;
    this.categories = categories;
  }


  //instance methods
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


  //toString


  //getters and setters
}


