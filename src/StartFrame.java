package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame {

  ActionListener listener;
  JFrame startFrame = new JFrame();

  public StartFrame() {
    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            case "login":
              new LoginFrame();
              startFrame.setVisible(false);
              break;
            case "signup":
              new SignupFrame();
              startFrame.setVisible(false);
          }
        }
      }
    };

    //ImageIcon creation
    ImageIcon startFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/startFrame.png"), 1536, 864);

    //buttons have to be in front to be able to function
    //so, we have a front panel with the buttons that is not opaque, and a back panel that essentially acts as the background and has the image



    //label creation
    JLabel background = new JLabel(startFrameImg);

    //panel creation
    JPanel backgroundPanel = new JPanel();
    SwingSetup.setupPanel(backgroundPanel, background, 0, 0, 1536, 864);

    JPanel buttonPanel = new JPanel();
    SwingSetup.setupPanel(buttonPanel, 0, 0, 1536, 864, null, false);

    //button creation
    JButton login = new JButton("login");
    SwingSetup.setupButton(login, buttonPanel, 90, 585, 400, 125, false, false);
    login.addActionListener(listener);

    JButton signup = new JButton("signup");
    SwingSetup.setupButton(signup, buttonPanel, 1045, 585, 400, 125, false, false);
    signup.addActionListener(listener);

    //frame creation
    SwingSetup.setupFrame(startFrame, 0, 0, 1536, 864, false, null);
    startFrame.add(backgroundPanel);
    startFrame.add(buttonPanel);
    startFrame.setVisible(true);

  }


}
