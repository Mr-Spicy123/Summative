package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verificationFrame {

  Font font = new Font("Ariel", Font.BOLD, 35);
  ActionListener listener;
  JFrame verificationFrame = new JFrame();
  JTextField email = new JTextField();

  public verificationFrame() {

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            case "back":
              new LoginFrame();
              verificationFrame.setVisible(false);
              break;
            case "enter":
              if (Reader.isInSystem(email.getText())) {
                SendEmail.send(email.getText(), "Verification", "here is your verification code:" + "12345");
                AppOpener.openGmail();
              }
              else {
                JOptionPane.showMessageDialog(null, "This email is not linked to an account");
              }
              break;
          }
        }
      }
    };

    ImageIcon verificationFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/verificationFrame.png"), 1536, 864);
    JLabel verificationFrameImgLabel = new JLabel(verificationFrameImg);

    JPanel backgroundPanel = new JPanel();
    SwingSetup.setupPanel(backgroundPanel, verificationFrameImgLabel, 0, 0, 1536, 864);

    JPanel objectPanel = new JPanel();
    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 864, null, false);

    JButton backButton = new JButton("back");
    SwingSetup.setupButton(backButton, objectPanel, 20, 10, 200, 100, false, false);
    backButton.addActionListener(listener);

    JButton enterButton = new JButton("enter");
    SwingSetup.setupButton(enterButton, objectPanel, 1080, 415, 325, 125, false, false);
    enterButton.addActionListener(listener);

    email = new JTextField();
    SwingSetup.setupTextField(email, objectPanel, 567, 440, 385, 75, true);
    email.setFont(font);

    SwingSetup.setupFrame(verificationFrame, 0, 0, 1536, 864, false, null);

    verificationFrame.add(backgroundPanel);
    verificationFrame.add(objectPanel);
    verificationFrame.setVisible(true);
  }



}


