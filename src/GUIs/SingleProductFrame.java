package src.GUIs;

import src.misc.Cart;
import src.misc.ImageIconScaler;
import src.misc.SwingSetup;
import src.threads.ShipmentThread;
import src.superClasses.DisplayProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SingleProductFrame {


  Font smallFont = new Font("Arial", Font.BOLD, 25);
  Font largeFont = new Font("Arial", Font.BOLD, 40);
  Font mediumFont = new Font("Arial", Font.BOLD, 30);
  ActionListener listener;
  JFrame singleProductFrame = new JFrame();

  public SingleProductFrame(DisplayProduct d) {

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            case "back":
              new ProductDisplayFrame(d.getThisCategory().getItems());
              singleProductFrame.setVisible(false);
              break;
            case "view cart":
              new CartViewFrame();
              singleProductFrame.setVisible(false);
              break;
            case "add to cart":
              ShipmentThread s = new ShipmentThread();
              s.start();
              if (d.getStock() == 0) {
                ShipmentThread.requestShip(d, d.getObject(), d.getProdName());
                JOptionPane.showMessageDialog(null, "out of stock, but new shipment is on the way!");
              }
              if (d.getStock() > 0) {
                Cart.addToCart(d);
                JOptionPane.showMessageDialog(null, "Added to cart!");
                System.out.println(Arrays.toString(Cart.getCartArray()));
              }
              break;
          }
        }
      }
    };

    ImageIcon singleProductFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/productDisplayFrame.png"), 1536, 864);
    JLabel singleProductFrameImgLabel = new JLabel(singleProductFrameImg);

    JPanel backgroundPanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom painting code to draw background image
        //g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(singleProductFrameImg.getImage(), 0, 0, null);
      }
    };
    backgroundPanel.setLayout(null);
    backgroundPanel.setBounds(0, 0, 1536, 864);
    //backgroundPanel.setOpaque(true);
/*

    JPanel objectPanel = new JPanel();
    objectPanel.setLayout(null);
    objectPanel.setBackground(new Color(0, 0, 0, 0));
    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 864, null, false);
*/




    JButton imageDisplay = new JButton(d.getExpandedImageRoot());
    SwingSetup.setupButton(imageDisplay, backgroundPanel, null, 159, 95, 479, 479, true, true);
    imageDisplay.setBorder(null);

    JButton backButton = new JButton("back");
    SwingSetup.setupInvisibleButton(backButton, backgroundPanel, listener, 10, 10, 100, 75, false, false);

    JButton viewCartButton = new JButton("view cart");
    SwingSetup.setupInvisibleButton(viewCartButton, backgroundPanel, listener, 1300, 0, 225, 125, false, false);

    JButton addCartButton = new JButton("add to cart");

    SwingSetup.setupInvisibleButton(addCartButton, backgroundPanel, listener, 490, 705, 150, 100, false, false);

    int x = 800;
    int y = 300;
    //backgroundPanel.setLayout(null);
    for (int i = 0; i < d.getDetails().length; i++) {
      JLabel text = new JLabel(d.getDetails()[i]);
      text.setBounds(x, y, 650, 50);
      text.setBackground(new Color(0, 0, 0, 0));
      text.setFont(smallFont);
      backgroundPanel.add(text);
      y += 45;
    }

    JLabel itemName = new JLabel(d.getProdName());
    itemName.setBounds(310, 610, 200, 50);
    itemName.setBackground(new Color(0, 0, 0, 0));
    itemName.setFont(smallFont);
    backgroundPanel.add(itemName);

    JLabel itemPrice = new JLabel(Double.toString(d.getPROD_PRICE()));
    itemPrice.setBounds(260, 685, 200, 50);
    itemPrice.setBackground(new Color(0, 0, 0, 0));
    itemPrice.setForeground(Color.GREEN);
    itemPrice.setFont(largeFont);
    backgroundPanel.add(itemPrice);

    JLabel stockNum = new JLabel("Amount in stock: " + d.getStock());
    stockNum.setBounds(170, 750, 400, 50);
    stockNum.setBackground(new Color(0, 0, 0, 0));
    stockNum.setForeground(Color.GRAY);
    stockNum.setFont(mediumFont);
    backgroundPanel.add(stockNum);



    SwingSetup.setupFrame(singleProductFrame, 0, 0, 1536, 864, false, null);

    singleProductFrame.add(backgroundPanel);
    singleProductFrame.setVisible(true);







  }
}
