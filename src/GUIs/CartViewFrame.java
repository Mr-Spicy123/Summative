package src.GUIs;

import src.misc.Cart;
import src.misc.ImageIconScaler;
import src.misc.SwingSetup;
import src.superClasses.DisplayProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartViewFrame {

  JFrame cartViewFrame = new JFrame();
  ActionListener listener;

  public CartViewFrame() {

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {

          }
        }
      }
    };

    ImageIcon cartViewFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/cartViewFrame.png"), 1536, 864);
    JLabel cartViewFrameImgLabel = new JLabel(cartViewFrameImg);

    JPanel backgroundPanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom painting code to draw background image
        //g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(cartViewFrameImg.getImage(), 0, 0, null);
      }
    };
    backgroundPanel.setLayout(null);
    backgroundPanel.setBounds(0, 0, 1536, 864);



    int x = 100;
    int y = 200;

    int cartItemWidth = 200;
    int cartItemHeight = 30;

    int removeButtonWidth = 50;
    int removeButtonHeight = 50;
    //shallow copy is all that is needed here because array is not changing
    DisplayProduct[] d = Cart.getCartArray();
    JButton[] b = Cart.getButtonsArray();
    for (int i = 0; i < Cart.getCartArray().length; i++) {
      if (b[i] != null) {
        JLabel cartItem = new JLabel(d[i].getProdName() + " - " + d[i].getPROD_PRICE());
        backgroundPanel.add(cartItem);
        cartItem.setBounds(x, y, cartItemWidth, cartItemHeight);
        JButton removeButton = b[i];
        SwingSetup.setupButton(removeButton, backgroundPanel, listener, x + cartItemWidth, y, removeButtonWidth, removeButtonHeight, true, false);
        removeButton.setText(Integer.toString(i));
        backgroundPanel.add(removeButton);
      }
    }

    SwingSetup.setupFrame(cartViewFrame, 0, 0, 1536, 864, false, null);
    cartViewFrame.add(backgroundPanel);
    cartViewFrame.setVisible(true);

  }
}
