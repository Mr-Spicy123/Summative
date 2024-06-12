package src.GUIs;

import src.FileIO.Reader;
import src.misc.ImageIconScaler;
import src.misc.ObjectCreation;
import src.misc.SwingSetup;
import src.superClasses.Website;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame {

  Font font = new Font("Ariel", Font.BOLD, 35);
  ActionListener listener;
  JFrame loginFrame = new JFrame();
  JTextField emailUsername = new JTextField();
  JTextField password = new JPasswordField();

  public LoginFrame() {

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            case "back":
              new StartFrame();
              loginFrame.setVisible(false);
              break;
            case "signup":
              new SignupFrame();
              loginFrame.setVisible(false);
              break;
            case "enter":
              String userEmail = emailUsername.getText();
              String pass = password.getText();
              //if not an email
              if (!userEmail.contains("@") && !userEmail.contains(".")) {
                  if (Reader.fileFinder(userEmail, pass, Reader.usernameFile)) {
                    new CategoryDisplayFrame(ObjectCreation.getCategories());
                    loginFrame.setVisible(false);
                  }
                  else {
                    JOptionPane.showMessageDialog(null, "username or password is incorrect");
                  }
              }
              //if an email
              else {
                  if (Reader.fileFinder(userEmail, pass, Reader.emailFile)) {
                    new CategoryDisplayFrame(ObjectCreation.getCategories());
                    loginFrame.setVisible(false);
                  }
                  else {
                    JOptionPane.showMessageDialog(null, "email or password is incorrect");
                  }
              }
              emailUsername.setText("");
              password.setText("");
              break;
            case "forgot password":
              new verificationFrame();
              loginFrame.setVisible(false);
              break;
          }
        }
      }
    };


    ImageIcon loginFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/loginFrame.png"), 1536, 864);
    JLabel loginFrameImgLabel = new JLabel(loginFrameImg);

    JPanel backgroundPanel = new JPanel();
    SwingSetup.setupPanel(backgroundPanel, loginFrameImgLabel, 0, 0, 1536, 864);

    JPanel objectPanel = new JPanel();
    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 864, null, false);

    //button creations
    JButton backButton = new JButton("back");
    SwingSetup.setupButton(backButton, objectPanel, listener, 20, 10, 200, 100, false, false);

    JButton signupButton = new JButton("signup");
    SwingSetup.setupButton(signupButton, objectPanel, listener, 1100, 145, 275, 100, false, false);

    JButton enterButton = new JButton("enter");
    SwingSetup.setupButton(enterButton, objectPanel, listener, 1100, 490, 375, 175, false, false);

    JButton forgotPasswordButton = new JButton("forgot password");
    SwingSetup.setupButton(forgotPasswordButton, objectPanel,  listener,1135, 720, 325, 125, false, false);

    SwingSetup.setupTextField(emailUsername, objectPanel, 560, 438, 400, 75, true);
    emailUsername.setFont(font);


    SwingSetup.setupTextField(password, objectPanel, 560, 632, 400, 75, true);
    password.setFont(font);

    SwingSetup.setupFrame(loginFrame, 0, 0, 1536, 864, false, null);

    loginFrame.add(backgroundPanel);
    loginFrame.add(objectPanel);
    loginFrame.setVisible(true);


  }


}
