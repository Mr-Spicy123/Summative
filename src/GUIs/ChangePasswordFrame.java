package src.GUIs;

import src.misc.AccountRequirements;
import src.misc.ImageIconScaler;
import src.misc.SwingSetup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordFrame {

  Font font = new Font("Ariel", Font.BOLD, 35);
  JFrame changePassFrame = new JFrame();
  ActionListener listener;
  JTextField password1 = new JTextField();
  JTextField password2 = new JPasswordField();


  public ChangePasswordFrame(String to) {

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            case "back":
              new verificationFrame();
              changePassFrame.setVisible(false);
            case "enter":
              String pass1 = password1.getText();
              String pass2 = password2.getText();
              if (pass1.equals(pass2)) {
                if (AccountRequirements.checkPassword(pass1)){
                  RewriteFile.switchPassword(to, pass1);
                  new LoginFrame();
                  changePassFrame.setVisible(false);
                }
                else {
                  JOptionPane.showMessageDialog(null, "New password does not meet requirements");
                  password1.setText("");
                  password2.setText("");
                }
              }
              else {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
                password1.setText("");
                password2.setText("");
              }
          }
        }
      }
    };


    ImageIcon changePassFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/changePasswordFrame.png"), 1536, 864);
    JLabel changePassFrameLabel = new JLabel(changePassFrameImg);

    JPanel backgroundPanel = new JPanel();
    SwingSetup.setupPanel(backgroundPanel, changePassFrameLabel, 0, 0, 1536, 864);

    JPanel objectPanel = new JPanel();
    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 864, null, false);

    JButton backButton = new JButton("back");
    SwingSetup.setupButton(backButton, objectPanel, listener, 20, 10, 200, 100, false, false);

    JButton enterButton = new JButton("enter");
    SwingSetup.setupButton(enterButton, objectPanel, listener, 1160, 450, 325, 150, false, false);

    password1 = new JTextField();
    SwingSetup.setupTextField(password1, objectPanel, 635, 400, 410, 75, true);
    password1.setFont(font);

    password2 = new JTextField();
    SwingSetup.setupTextField(password2, objectPanel, 635, 595, 410, 75, true);
    password2.setFont(font);


    SwingSetup.setupFrame(changePassFrame, 0, 0, 1536, 864, false, null);

    changePassFrame.add(backgroundPanel);
    changePassFrame.add(objectPanel);
    changePassFrame.setVisible(true);
  }

}
