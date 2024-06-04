package src;

import java.io.*;

public class Writer {
  public Writer() throws IOException {
  }

  //method to write to the UserBalance.txt file
  public static void writeUserBalance(String subject) {
    try {
      FileWriter fw1 = new FileWriter("UserBalance.txt", true);
      PrintWriter printUB = new PrintWriter(fw1);
      printUB.println(subject);
      printUB.close();
    }catch (IOException e) {
      System.err.println("IO");
    }
  }

  //method to write to the UserInfo.txt file
  public static void writeUserInfo(String subject) {
    try {
      FileWriter fw2 = new FileWriter("UserInfo.txt", true);
      PrintWriter printUI = new PrintWriter(fw2);
      printUI.println(subject);
      printUI.close();
    } catch (IOException e) {
      System.err.println("IO");
    }
  }
}
