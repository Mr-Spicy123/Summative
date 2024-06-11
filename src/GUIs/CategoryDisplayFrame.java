package src.GUIs;

import src.misc.ImageIconScaler;
import src.misc.SwingSetup;
import src.superClasses.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryDisplayFrame {

  JFrame categoryDisplayFrame = new JFrame();
  ActionListener listener;
  JTextField searchField = new JTextField();
  JScrollPane categoryScrollPane = new JScrollPane();

  public CategoryDisplayFrame(Category[] categories) {

    JButton[] buttons = new JButton[categories.length];

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
          }
        }

      }


    };

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

    JPanel objectPanel = new JPanel();
    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 2000, null, false);

    backgroundPanel.add(objectPanel);

    categoryScrollPane = new JScrollPane(backgroundPanel);
    //categoryScrollPane.setBounds(0, 0, 1536, 2000);
    categoryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    categoryScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    categoryScrollPane.setVisible(true);

    categoryDisplayFrame.setContentPane(categoryScrollPane);
    categoryDisplayFrame.setBounds(0, 0, 1536, 864);
    categoryDisplayFrame.setVisible(true);

    /*JPanel panel = new JPanel();
    panel.setBackground(Color.blue);
    categoryDisplayFrame.setContentPane(panel);*/

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
      itemNameLabel.setForeground(Color.green);
      itemNameLabel.setBounds(xPos, yPos + imageButtonHeight, nameLabelWidth, nameLabelHeight);
      itemNameLabel.setVisible(true);
      categoryDisplayFrame.setLayout(null);
      //place images
      image = categories[i].getImageRoot();
      imageButton = new JButton(image);
      imageButton.setText("category");
      buttons[i] = imageButton;
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
    //show the frame with all the categories osn it

  }
}
