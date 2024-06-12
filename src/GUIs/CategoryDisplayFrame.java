package src.GUIs;

import src.misc.ImageIconScaler;
import src.misc.SwingSetup;
import src.superClasses.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CategoryDisplayFrame implements KeyListener {

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
  static JFrame categoryDisplayFrame = new JFrame();
  static ActionListener listener;
  JTextField searchField = new JTextField();
  JScrollPane categoryScrollPane = new JScrollPane();
  static JPanel objectPanel = new JPanel();
  static Category[] categories;
  static JButton[] buttons;
  static JLabel[] itemNames;

  public CategoryDisplayFrame(Category[] c) {
    int length = c.length;
    itemNames = new JLabel[length];
    categories = new Category[length];
    //deep copy to static array
    for (int i = 0; i < length; i++) {
      categories[i] = c[i];
    }
    buttons = new JButton[length];

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            case "category":
              for (int i = 0; i < categories.length; i++) {
                //if the button that was pressed is equal to the id of the buttons at i
                if (e.getSource() == buttons[i]) {
                  new ProductDisplayFrame(categories[i].getItems());
                  categoryScrollPane.setVisible(false);
                }
              }
              break;
            case "back":
              new StartFrame();
              categoryDisplayFrame.setVisible(false);
              break;
            case "view cart":
              new cartViewFrame();
              categoryDisplayFrame.setVisible(false);
          }
        }

      }


    };


    ImageIcon categoryDisplayImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/categoryFloorFrame.png"), 1536, 2000);
    JLabel categoryDisplayLabel = new JLabel(categoryDisplayImg);

    JPanel backgroundPanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Load the image (assuming imagePath is a valid path to your image)
        Image img = categoryDisplayImg.getImage();
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

    categoryScrollPane = new JScrollPane(backgroundPanel);
    categoryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    categoryScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    categoryScrollPane.setVisible(true);

    setCategoriesDisplay();

    SwingSetup.setupFrame(categoryDisplayFrame, 0, 0, 1536, 864, false, null);
    categoryDisplayFrame.setContentPane(categoryScrollPane);
    categoryDisplayFrame.setVisible(true);

    //show the frame with all the categories osn it


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
          searchCategories(search);
        } else {
          resetCategoriesDisplay();
        }
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //not used
  }

  public static void searchCategories(String search) {
    //initial x and y coordinates for image placement
    xPos = 75;
    yPos = 150;

//dimensions for labels and buttons
    nameLabelWidth = 225;
    nameLabelHeight = 25;

    imageButtonWidth = 225;
    imageButtonHeight = 225;

//rowCounter to make a row cap
    rowCounter = 0;
    maxRowCount = 5;


    //declare JLabels, ImageIcons and Fonts
    ImageIcon image;
    JLabel itemNameLabel;
    JButton imageButton;
    //array of buttons to store each button in
    Font font = new Font("Arial", Font.BOLD, 24);

    for (int i = 0; i < categories.length; i++) {
      objectPanel.remove(itemNames[i]);
      objectPanel.remove(buttons[i]);
    }
    //for loop to place images and names
    for (int i = 0; i < categories.length; i++) {
      if (categories[i].getCategoryName().contains(search)) {
        //place item names
        itemNameLabel = new JLabel(categories[i].getCategoryName());
        objectPanel.add(itemNameLabel);
        itemNameLabel.setFont(font);
        itemNameLabel.setForeground(Color.black);
        itemNameLabel.setBounds(xPos, yPos + imageButtonHeight, nameLabelWidth, nameLabelHeight);
        itemNameLabel.setVisible(true);
        categoryDisplayFrame.setLayout(null);
        //place images
        image = categories[i].getImageRoot();
        imageButton = new JButton(image);
        imageButton.setText("category");
        imageButton.addActionListener(listener);
        buttons[i] = imageButton;
        itemNames[i] = itemNameLabel;
        objectPanel.add(imageButton);
        imageButton.setBounds(xPos, yPos, imageButtonWidth, imageButtonHeight);
        //position adjustments for the next placement
        xPos += 275;
        rowCounter++;
        //if the row has ended
        if (rowCounter == maxRowCount) {
          yPos += 300;
          xPos = 75;
        }
      }
    }
    categoryDisplayFrame.revalidate();
    categoryDisplayFrame.repaint();
  }

  public static void resetCategoriesDisplay() {
    //initial x and y coordinates for image placement
    xPos = 75;
    yPos = 150;

//dimensions for labels and buttons
    nameLabelWidth = 225;
    nameLabelHeight = 25;

    imageButtonWidth = 225;
    imageButtonHeight = 225;

//rowCounter to make a row cap
    rowCounter = 0;
    maxRowCount = 5;


    //declare JLabels, ImageIcons and Fonts
    ImageIcon image;
    JLabel itemNameLabel;
    JButton imageButton;
    //array of buttons to store each button in
    Font font = new Font("Arial", Font.BOLD, 24);

    for (int i = 0; i < categories.length; i++) {
      objectPanel.remove(itemNames[i]);
      objectPanel.remove(buttons[i]);
    }
    //for loop to place images and names
    for (int i = 0; i < categories.length; i++) {
      //place item names
      itemNameLabel = new JLabel(categories[i].getCategoryName());
      objectPanel.add(itemNameLabel);
      itemNameLabel.setFont(font);
      itemNameLabel.setForeground(Color.black);
      itemNameLabel.setBounds(xPos, yPos + imageButtonHeight, nameLabelWidth, nameLabelHeight);
      itemNameLabel.setVisible(true);
      categoryDisplayFrame.setLayout(null);
      //place images
      image = categories[i].getImageRoot();
      imageButton = new JButton(image);
      imageButton.setText("category");
      imageButton.addActionListener(listener);
      buttons[i] = imageButton;
      itemNames[i] = itemNameLabel;
      objectPanel.add(imageButton);
      imageButton.setBounds(xPos, yPos, imageButtonWidth, imageButtonHeight);
      //position adjustments for the next placement
      xPos += 275;
      rowCounter++;
      //if the row has ended
      if (rowCounter == maxRowCount) {
        yPos += 300;
        xPos = 75;
      }
    }
    categoryDisplayFrame.revalidate();
    categoryDisplayFrame.repaint();
  }

  public static void setCategoriesDisplay() {
    //initial x and y coordinates for image placement
    xPos = 75;
    yPos = 150;

//dimensions for labels and buttons
    nameLabelWidth = 225;
    nameLabelHeight = 25;

    imageButtonWidth = 225;
    imageButtonHeight = 225;

//rowCounter to make a row cap
    rowCounter = 0;
    maxRowCount = 5;


    //declare JLabels, ImageIcons and Fonts
    ImageIcon image;
    JLabel itemNameLabel;
    JButton imageButton;
    //array of buttons to store each button in
    Font font = new Font("Arial", Font.BOLD, 24);


    //for loop to place images and names
    for (int i = 0; i < categories.length; i++) {
      //place item names
      itemNameLabel = new JLabel(categories[i].getCategoryName());
      objectPanel.add(itemNameLabel);
      itemNameLabel.setFont(font);
      itemNameLabel.setForeground(Color.black);
      itemNameLabel.setBounds(xPos, yPos + imageButtonHeight, nameLabelWidth, nameLabelHeight);
      itemNameLabel.setVisible(true);
      categoryDisplayFrame.setLayout(null);
      //place images
      image = categories[i].getImageRoot();
      imageButton = new JButton(image);
      imageButton.setText("category");
      imageButton.addActionListener(listener);
      buttons[i] = imageButton;
      itemNames[i] = itemNameLabel;
      objectPanel.add(imageButton);
      imageButton.setBounds(xPos, yPos, imageButtonWidth, imageButtonHeight);
      //position adjustments for the next placement
      xPos += 275;
      rowCounter++;
      //if the row has ended
      if (rowCounter == maxRowCount) {
        yPos += 300;
        xPos = 75;
      }
    }
    categoryDisplayFrame.revalidate();
    categoryDisplayFrame.repaint();
  }
}

//what to do with buttons:

