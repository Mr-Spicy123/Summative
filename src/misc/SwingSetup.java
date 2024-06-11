package src.misc;

import javax.swing.*;
import java.awt.*;

public class SwingSetup {
  public static void setupFrame(JFrame frame, int x, int y, int width, int height, boolean vis, Object layout) {
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setBounds(x, y, width, height);
    frame.setVisible(vis);
    if (layout == null) {
      frame.setLayout(null);
    }
    else if(layout instanceof LayoutManager) {
      LayoutManager l = (LayoutManager) layout;
      frame.setLayout(l);
    }
    else {
      System.err.println("not a layout");
    }
  }

  public static void setupPanel(JPanel panel, JLabel label, int x, int y,int width, int height) {
    panel.setBounds(x, y, width, height);
    panel.add(label);
  }

  public static void setupPanel(JPanel panel, int x, int y, int width, int height, Object layout, boolean opaque) {
    panel.setBounds(x, y, width, height);
    panel.setOpaque(opaque);
    if (layout == null) {
      panel.setLayout(null);
    }
    else if (layout instanceof LayoutManager) {
      LayoutManager l = (LayoutManager) layout;
      panel.setLayout(l);
    }
    else {
      System.err.println("not a layout");
    }
  }

  public static void setupButton(JButton button, JPanel panel, int x, int y, int width, int height, boolean opaque, boolean focusable) {
    panel.add(button);
    button.setBounds(x, y, width, height);
    button.setOpaque(opaque);
    button.setFocusable(focusable);
  }

  public static void setupTextField(JTextField field, JPanel panel, int x, int y, int width, int height, boolean opaque) {
    panel.add(field);
    field.setBounds(x, y, width, height);
    field.setOpaque(opaque);
  }
}
