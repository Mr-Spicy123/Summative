package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame {

  static ActionListener listener;

  public static void main(String[] args) {

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            case "login":
              System.out.println("log into account");
              break;
            case "signup":
              System.out.println("make account");
          }
        }
      }
    };
    ImageIcon startFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/startFrame.png"), 1536, 864);
    //buttons have to be in front to be able to function
    //so, we have a front panel with the buttons that is not opaque, and a back panel that essentially acts as the background and has the image

    JPanel buttonPanel = new JPanel();
    JPanel backgroundPanel = new JPanel();

    JLabel background = new JLabel(startFrameImg);

    SwingSetup.setupPanel(backgroundPanel, background, 0, 0, 1536, 864);
    SwingSetup.setupPanel(buttonPanel, 0, 0, 1536, 864, null, false);

    JButton login = new JButton("login");
    SwingSetup.setupButton(login, buttonPanel, 90, 585, 400, 125, false, false);
    login.addActionListener(listener);

    JButton signup = new JButton("signup");
    SwingSetup.setupButton(signup, buttonPanel, 1045, 585, 400 ,125, false, false);
    signup.addActionListener(listener);

    JFrame startFrame = new JFrame();
    SwingSetup.setupFrame(startFrame, 0, 0, 1536, 864, true, null);
    startFrame.add(backgroundPanel);
    startFrame.add(buttonPanel);

  }


}
