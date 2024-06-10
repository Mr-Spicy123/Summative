package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignupFrame {

  Font font = new Font("Ariel", Font.BOLD, 35);
  ActionListener listener;
  JFrame signupFrame = new JFrame();
  JTextField usernameField = new JTextField();
  JTextField emailField = new JTextField();
  JTextField passwordField = new JTextField();
  JTextField confirmPasswordField = new JPasswordField();

  public SignupFrame() {

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
              signupFrame.setVisible(false);
            case "sign-in":
              new LoginFrame();
              signupFrame.setVisible(false);
            case "enter":
              String username = usernameField.getText();
              String email = emailField.getText();
              String password = passwordField.getText();
              String confirmPassword = confirmPasswordField.getText();
              if (AccountRequirements.checkAccount(username, password, confirmPassword, email)) {
                Writer.writeFile(username, Writer.usernamesFile);
                Writer.writeFile(password, Writer.passwordsFile);
                Writer.writeFile(email, Writer.emailFile);
                new LoginFrame();
                signupFrame.setVisible(false);
              }
          }
        }
      }
    };

    ImageIcon signupFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/signupFrame.png"), 1536, 864);

    //label creation
    JLabel signupFrameImgLabel = new JLabel(signupFrameImg);

    //panel creation
    JPanel backgroundPanel = new JPanel();
    SwingSetup.setupPanel(backgroundPanel, signupFrameImgLabel, 0, 0, 1536, 864);

    JPanel objectPanel = new JPanel();
    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 864, null, false);

    usernameField = new JTextField();
    SwingSetup.setupTextField(usernameField, objectPanel, 400, 448, 410, 75, true);
    usernameField.setFont(font);

    emailField = new JTextField();
    SwingSetup.setupTextField(emailField, objectPanel, 400, 325, 410, 75, true);
    emailField.setFont(font);

    passwordField = new JTextField();
    SwingSetup.setupTextField(passwordField, objectPanel, 400, 580, 410, 75, true);
    passwordField.setFont(font);

    confirmPasswordField = new JPasswordField();
    SwingSetup.setupTextField(confirmPasswordField, objectPanel, 400, 710, 410, 75, true);
    confirmPasswordField.setFont(font);

    JButton backButton = new JButton("back");
    SwingSetup.setupButton(backButton, objectPanel, 20, 10, 200, 100, false, false);
    backButton.addActionListener(listener);

    JButton signinButton = new JButton("sign-in");
    SwingSetup.setupButton(signinButton, objectPanel, 1050, 140, 300, 110, false, false);
    signinButton.addActionListener(listener);

    JButton enterButton = new JButton("enter");
    SwingSetup.setupButton(enterButton, objectPanel, 895, 570, 575, 220, false, false);
    enterButton.addActionListener(listener);

    //frame creation
    SwingSetup.setupFrame(signupFrame, 0, 0, 1536, 864, false, null);
    signupFrame.add(backgroundPanel);
    signupFrame.add(objectPanel);
    signupFrame.setVisible(true);
  }
}
