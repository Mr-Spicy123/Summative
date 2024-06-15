package src.misc;

import src.FileIO.Reader;

import javax.swing.*;

public class AccountRequirements {

  public static boolean checkPassword(String pass) {
    if (pass.length() > 7 && pass.length() < 17) {
      return true;
    }
    return false;
  }

  public static boolean checkUsername(String user) {
    String[] invalidChars = {")", "(", "*", "&", "^", "%", "$", "#", "!", "?", "{", "}", ";", ":", "<", ">", ",", "/", "'", "@", " ", "."};
    if (user.length() > 7 && user.length() < 17) {
      for (String invalidChar : invalidChars) {
        if (user.contains(invalidChar)) {
          JOptionPane.showMessageDialog(null, "username contains invalid character");
          return false;
        }
      }
      return true;
    }
    if (user.length() < 7) {
      JOptionPane.showMessageDialog(null, "username is too short; must be within 8-16 characters");
    }
    if (user.length() > 17) {
      JOptionPane.showMessageDialog(null, "username is too long; must be within 8-16 characters");
    }
    return false;
  }

  public static boolean checkEmail(String email) {
    if (email.contains("@") && email.contains(".")) {
      if (!email.contains(" ")) {
        return true;
      } else {
        JOptionPane.showMessageDialog(null, "email cannot contain a space");
        return false;
      }
    }
    JOptionPane.showMessageDialog(null, "this is not an email");
    return false;
  }

  public static boolean checkAccount(String username, String password, String confirmPassword, String email) {
    if (checkUsername(username)) {
      if (!Reader.isInSystem(username)) {
        if (password.equals(confirmPassword)) {
          if (checkPassword(password)) {
            if (checkEmail(email)) {
              if (!Reader.isInSystem(email)) {
                //if all variables are correct
                return true;
              }
              else {
                JOptionPane.showMessageDialog(null, "email is already in system");
              }
            }
          }
        }
      } else {
        JOptionPane.showMessageDialog(null, "username is already in system");
      }
    }
    return false;
  }
}
