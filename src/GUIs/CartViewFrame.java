package src.GUIs;

import src.misc.*;
import src.superClasses.DisplayProduct;
import src.threads.PaycheckThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartViewFrame {

  JFrame cartViewFrame = new JFrame();
  static ImageIcon cartViewFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/cartViewFrame.png"), 1536, 864);
  JLabel cartViewFrameImgLabel = new JLabel(cartViewFrameImg);
  static JLabel[] cartItems;
  static JButton[] removeButtons;
  static JPanel backgroundPanel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      // Custom painting code to draw background image
      //g.fillRect(0, 0, getWidth(), getHeight());
      g.drawImage(cartViewFrameImg.getImage(), 0, 0, null);
    }
  };
  static ActionListener listener;

  public CartViewFrame() {
    int length = Cart.getCartArray().length;
    cartItems = new JLabel[length];
    removeButtons = new JButton[length];

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          for (int i = 0; i <removeButtons.length; i++) {
            if (button.getText().equals(Integer.toString(i))) {
              Cart.removeFromCart(i);
              resetProductsInCart();
            }
          }
          switch (button.getText()) {
            case "back":
              new CategoryDisplayFrame(ObjectCreation.getCategories());
              cartViewFrame.setVisible(false);
              break;
            case "remove all":
              Cart.removeAllItems();
              resetProductsInCart();
              break;
            case "remove last":
              Cart.removeLastItem();
              resetProductsInCart();
              break;
            case "buy":
              if (!Cart.checkEmpty()) {
                //ensure each item has enough stock
                if (Cart.underItemStock()) {
                  Cart.checkout();
                  String userEmail;
                  if (CurrentUser.getEmail() != null) {
                    userEmail = CurrentUser.getEmail();
                  } else {
                    userEmail = CurrentUser.getUsername();
                  }
                  RewriteFile.switchBalance(userEmail, Double.toString(CurrentUser.getCurrentBalance()));
                  PaycheckThread p = new PaycheckThread();
                  p.start();
                }
              }
              else {
                JOptionPane.showMessageDialog(null, "Cart is empty");
              }
              resetProductsInCart();
              break;
          }
        }
      }
    };


    backgroundPanel.setLayout(null);
    backgroundPanel.setBounds(0, 0, 1536, 864);

    JButton backButton = new JButton("back");
    SwingSetup.setupInvisibleButton(backButton, backgroundPanel, listener, 0, 0, 100, 75, false, false);

    JButton removeAll = new JButton("remove all");
    SwingSetup.setupInvisibleButton(removeAll, backgroundPanel, listener, 905, 200, 160, 120, false, false);

    JButton removeLast = new JButton("remove last");
    SwingSetup.setupInvisibleButton(removeLast, backgroundPanel, listener, 1135, 200, 170, 120, false, false);

    JButton buyButton = new JButton("buy");
    SwingSetup.setupInvisibleButton(buyButton, backgroundPanel, listener, 890, 465, 450, 250, false, false);

    setupProductsInCart();

    SwingSetup.setupFrame(cartViewFrame, 0, 0, 1536, 864, false, null);
    cartViewFrame.add(backgroundPanel);
    cartViewFrame.setVisible(true);

  }

  public static void resetProductsInCart() {
    for (int i = 0; i < cartItems.length; i++) {
      if (cartItems[i] != null) {
        backgroundPanel.remove(cartItems[i]);
        backgroundPanel.remove(removeButtons[i]);
      }
    }
    int x = 100;
    int y = 200;

    int cartItemWidth = 200;
    int cartItemHeight = 30;

    int removeButtonWidth = 40;
    int removeButtonHeight = 40;
    //shallow copy is all that is needed here because array is not changing
    DisplayProduct[] d = Cart.getCartArray();

    ImageIcon removeButtonImage = ImageIconScaler.scaleImageIcon(new ImageIcon("icons/removeItemIcon.png"), 40, 40);
    JLabel removeButtonLabel = new JLabel(removeButtonImage);

    for (int i = 0; i < Cart.getCartArray().length; i++) {
      if (d[i] != null) {
        JLabel cartItem = new JLabel(d[i].getProdName() + " - " + d[i].getPROD_PRICE());
        cartItem.setBounds(x, y, cartItemWidth, cartItemHeight);
        backgroundPanel.add(cartItem);
        cartItems[i] = cartItem;

        JButton removeButton = new JButton(removeButtonImage);
        SwingSetup.setupInvisibleButton(removeButton, backgroundPanel, listener, x + cartItemWidth, y, removeButtonWidth, removeButtonHeight, true, false);
        removeButton.setText(Integer.toString(i));
        removeButton.setBackground(new Color(0, 0, 0, 0));
        removeButton.add(removeButtonLabel);
        backgroundPanel.add(removeButton);
        removeButtons[i] = removeButton;
        y += 50;
      }
    }
    backgroundPanel.revalidate();
    backgroundPanel.repaint();
  }

  public static void setupProductsInCart() {
    int x = 100;
    int y = 200;

    int cartItemWidth = 200;
    int cartItemHeight = 30;

    int removeButtonWidth = 40;
    int removeButtonHeight = 40;
    //shallow copy is all that is needed here because array is not changing
    DisplayProduct[] d = Cart.getCartArray();

    ImageIcon removeButtonImage = ImageIconScaler.scaleImageIcon(new ImageIcon("icons/removeItemIcon.png"), 40, 40);
    JLabel removeButtonLabel = new JLabel(removeButtonImage);

    for (int i = 0; i < Cart.getCartArray().length; i++) {
      if (d[i] != null) {
        JLabel cartItem = new JLabel(d[i].getProdName() + " - " + d[i].getPROD_PRICE());
        cartItem.setBounds(x, y, cartItemWidth, cartItemHeight);
        backgroundPanel.add(cartItem);
        cartItems[i] = cartItem;

        JButton removeButton = new JButton(removeButtonImage);
        SwingSetup.setupInvisibleButton(removeButton, backgroundPanel, listener, x + cartItemWidth, y, removeButtonWidth, removeButtonHeight, true, false);
        removeButton.setText(Integer.toString(i));
        removeButton.setBackground(new Color(0, 0, 0, 0));
        removeButton.add(removeButtonLabel);
        backgroundPanel.add(removeButton);
        removeButtons[i] = removeButton;
        y += 50;
      }
    }
    backgroundPanel.revalidate();
    backgroundPanel.repaint();
  }
}
