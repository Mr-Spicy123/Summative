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
    String[] invalidChars = {")","(","*","&","^","%","$","#","!","?","{","}",";",":","<",">",",","/","'", "@", " ", "."};
    if (user.length() > 7 && user.length() < 17) {
      for (String invalidChar : invalidChars) {
        if (user.contains(invalidChar)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public static boolean checkEmail(String email) {
    if (email.contains("@") && email.contains(".") && !email.contains(" ")) {
      return true;
    }
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
                JOptionPane.showMessageDialog(null, "Email already in use");
              }
            } else {
              JOptionPane.showMessageDialog(null, "Invalid email");
            }
          } else {
            JOptionPane.showMessageDialog(null, "Invalid password");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Passwords do not match");
        }
      }
      else {
        JOptionPane.showMessageDialog(null, "Username already in use");
      }
    }
    else {
      JOptionPane.showMessageDialog(null, "Invalid username");
    }
    return false;
  }
}
