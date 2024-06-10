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
  JTextField username = new JTextField();
  JTextField email = new JTextField();
  JTextField password = new JPasswordField();
  JTextField confirmPassword = new JPasswordField();

  public SignupFrame() {

  }




  public static boolean isValidEmail(String email) {
    return true;
  }

  public static boolean isValidPassword(String password) {
    return true;
  }
}
