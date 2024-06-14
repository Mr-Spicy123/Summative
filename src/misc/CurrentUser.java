package src.misc;

import src.FileIO.Reader;
import src.GUIs.RewriteFile;

public class CurrentUser {
  private static String email;
  private static String username;
  private static String password;
  //private static double balance = getCurrentBalance();

  public static void subtractBalance(double num) {
    double b = getCurrentBalance();
    b-=num;
    String userEmail;
    if (email != null) {
      RewriteFile.switchBalance(email, Double.toString(b));
    }
    else {
      RewriteFile.switchBalance(username, Double.toString(b));
    }
  }


  public static void setEmail(String e) {
    email = e;
  }

  public static void setUsername(String u) {
    username = u;
  }

  public static void setPassword(String p) {
    password = p;
  }

  public static String getEmail() {
    return email;
  }

  public static String getUsername() {
    return username;
  }

  public static String getPassword() {
    return password;
  }


  public static double getCurrentBalance() {
    int index;
    if (email != null) {
      index = Reader.findIndex(email, Reader.emailFile);
    }
    else {
      index = Reader.findIndex(username, Reader.usernameFile);
    }
    System.out.println(index);
    index--;
    System.out.println(index);
    String[] balanceArr = Reader.getArray(Reader.balanceFile);
    String balanceStr = balanceArr[index];
    return Double.parseDouble(balanceStr);
  }
}
