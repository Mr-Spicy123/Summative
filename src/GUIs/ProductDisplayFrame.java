package src.GUIs;

import src.misc.ImageIconScaler;
import src.misc.ObjectCreation;
import src.misc.SwingSetup;
import src.superClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ProductDisplayFrame implements KeyListener {
  static int xPos;
  static int yPos;

  //dimensions for labels and buttons
  static int nameLabelWidth;
  static int nameLabelHeight;

  static int imageButtonWidth;
  static int imageButtonHeight;

  //rowCounter to make a row cap
  static int rowCounter;
  static int maxRowCount;

  Font searchFieldFont = new Font("Arial", Font.BOLD, 40);
  JTextField searchField = new JTextField();
  JScrollPane productScrollPane = new JScrollPane();
  static JPanel objectPanel = new JPanel();
  static JFrame productDisplayFrame = new JFrame();
  static ActionListener listener;
  static DisplayProduct[] products;
  static JButton[] buttons;
  static JLabel[] itemNames;


  public ProductDisplayFrame(DisplayProduct[] p) {
    int length = p.length;
    buttons = new JButton[length];
    itemNames = new JLabel[length];
    products = new DisplayProduct[length];
    //deep copy of products
    for (int i = 0; i < length; i++) {
      products[i] = p[i];
    }
    objectPanel.removeAll();
    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          for (int i = 0; i < buttons.length; i++) {
            if (button.getText().equals(Integer.toString(i))) {
              new SingleProductFrame(products[i]);
              productDisplayFrame.setVisible(false);
            }
          }
          switch (button.getText()) {
            case "back":
              new CategoryDisplayFrame(ObjectCreation.getCategories());
              productDisplayFrame.setVisible(false);
              break;
            case "view cart":
              new CartViewFrame();
              productDisplayFrame.setVisible(false);
          }
        }
      }
    };

    ImageIcon productDisplayImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/productFloorFrame.png"), 1536, 2000);
    JLabel productDisplayLabel = new JLabel(productDisplayImg);

    JPanel backgroundPanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Load the image (assuming imagePath is a valid path to your image)
        Image img = productDisplayImg.getImage();
        g.drawImage(img, 0, 0, this); // Draw the image at the top-left corner
      }
    };

    backgroundPanel.setPreferredSize(new Dimension(1536, 2000));
    backgroundPanel.setLayout(null);

    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 2000, null, false);

    backgroundPanel.add(objectPanel);

    searchField = new JTextField();
    SwingSetup.setupTextField(searchField, objectPanel, 625, 48, 590, 60, true);
    searchField.setFont(searchFieldFont);
    searchField.addKeyListener(this);
    searchField.setFocusTraversalKeysEnabled(true);

    JButton backButton = new JButton("back");
    SwingSetup.setupInvisibleButton(backButton, objectPanel, listener, 0, 0, 100, 100, false, false);

    JButton viewCartButton = new JButton("view cart");
    SwingSetup.setupInvisibleButton(viewCartButton, objectPanel, listener, 1250, 25, 250, 150, false, false);

    productScrollPane = new JScrollPane(backgroundPanel);
    productScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    productScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    productScrollPane.setVisible(true);


    SwingSetup.setupFrame(productDisplayFrame, 0, 0, 1536, 864, false, null);
    productDisplayFrame.setContentPane(productScrollPane);
    productDisplayFrame.setVisible(true);

    setProductDisplay();
    resetProductDisplay();

  }

  public static void resetProductDisplay() {
    for (int i = 0; i < products.length; i++) {
      objectPanel.remove(buttons[i]);
      objectPanel.remove(itemNames[i]);
    }
    setProductDisplay();
  }

  public static void searchProducts(String search) {
    setVariables();
    //declare JLabels and ImageIcons
    ImageIcon image;
    JButton imageButton;
    JLabel itemNameLabel;
    Font font = new Font("Arial", Font.BOLD, 24);
    for (int i = 0; i < products.length; i++) {
      objectPanel.remove(buttons[i]);
      objectPanel.remove(itemNames[i]);
    }
    //for loop to place images and names
    for (int i = 0; i < products.length; i++) {
      if (products[i].getProdName().toLowerCase().contains(search.toLowerCase())) {
        //place item names
        itemNameLabel = new JLabel(products[i].getProdName());
        itemNames[i] = itemNameLabel;
        objectPanel.add(itemNameLabel);
        itemNameLabel.setFont(font);
        itemNameLabel.setForeground(Color.black);
        itemNameLabel.setBounds(xPos, yPos + imageButtonHeight, nameLabelWidth, nameLabelHeight);
        itemNameLabel.setVisible(true);
        //place images
        image = products[i].getImageRoot();
        imageButton = new JButton(image);
        imageButton.setText(Integer.toString(i));
        imageButton.addActionListener(listener);
        productDisplayFrame.setLayout(null);
        imageButton.setBounds(xPos, yPos, imageButtonWidth, imageButtonHeight);
        buttons[i] = imageButton;
        objectPanel.add(imageButton);
        xPos += 275;
        rowCounter++;
        //if the row has ended
        if (rowCounter == maxRowCount) {
          yPos += 300;
          xPos = 75;
        }
      }
    }
    productDisplayFrame.revalidate();
    productDisplayFrame.repaint();
  }

  public static void setProductDisplay() {
    setVariables();
    //declare JLabels and ImageIcons
    ImageIcon image;
    JButton imageButton;
    JLabel itemNameLabel;
    Font font = new Font("Arial", Font.BOLD, 24);
    //for loop to place images and names
    for (int i = 0; i < products.length; i++) {
      //place item names
      itemNameLabel = new JLabel(products[i].getProdName());
      objectPanel.add(itemNameLabel);
      itemNameLabel.setFont(font);
      itemNameLabel.setForeground(Color.black);
      itemNameLabel.setBounds(xPos, yPos + imageButtonHeight, nameLabelWidth, nameLabelHeight);
      itemNames[i] = itemNameLabel;
      itemNameLabel.setVisible(true);
      //place images
      image = products[i].getImageRoot();
      imageButton = new JButton(image);
      imageButton.setText(Integer.toString(i));
      productDisplayFrame.setLayout(null);
      imageButton.setBounds(xPos, yPos, imageButtonWidth, imageButtonHeight);
      imageButton.addActionListener(listener);
      buttons[i] = imageButton;
      objectPanel.add(imageButton);
      xPos += 275;
      rowCounter++;
      //if the row has ended
      if (rowCounter == maxRowCount) {
        yPos += 300;
        xPos = 75;
      }
    }
    productDisplayFrame.revalidate();
    productDisplayFrame.repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    //not used
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    String search = searchField.getText();
    System.out.println(search);
    // Perform different actions based on which key was pressed
    switch (keyCode) {
      case KeyEvent.VK_ENTER:
        System.out.println("enter key was pressed");
        if (!search.isEmpty()) {
          searchProducts(search);
        } else {
          resetProductDisplay();
        }
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //not used
  }

  public static void setVariables() {
    //initial x and y coordinates
    xPos = 75;
    yPos = 175;

    //variables used in the following for loop
    //dimensions of each label
    nameLabelWidth = 225;
    nameLabelHeight = 25;

    //dimensions of each image
    imageButtonWidth = 225;
    imageButtonHeight = 225;

    //rowCounter to make a row cap
    rowCounter = 0;
    maxRowCount = 5;
  }
}