package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verificationFrame {

  Font font = new Font("Ariel", Font.BOLD, 35);
  ActionListener listener;
  JFrame verificationFrame = new JFrame();
  JTextField emailUsername = new JTextField();

  public verificationFrame() {

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

    ImageIcon verificationFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/verificationFrame.png"), 1536, 864);
    JLabel verificationFrameImgLabel = new JLabel(verificationFrameImg);

    JPanel backgroundPanel = new JPanel();
    SwingSetup.setupPanel(backgroundPanel, verificationFrameImgLabel, 0, 0, 1536, 864);

    JPanel objectPanel = new JPanel();
    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 864, null, false);

    JButton backButton = new JButton("back");
    SwingSetup.setupButton(backButton, objectPanel, 20, 10, 200, 100, false, false);

    SwingSetup.setupFrame(verificationFrame, 0, 0, 1536, 864, false, null);

    verificationFrame.add(backgroundPanel);
    verificationFrame.add(objectPanel);
    verificationFrame.setVisible(true);
  }



}


