package src;

import java.io.*;

public class Writer {

  static String emailFile = "Emails.txt";
  static String passwordsName = "Passwords.txt";
  static String usernames = "Usernames.txt";
  static String balance = "UserBalance.txt";

  public static void writeFile(String text, String file) {
    try {
      FileWriter fw = new FileWriter(file, true);
      PrintWriter pw = new PrintWriter(fw);
      pw.println(text);
      pw.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
  }
}
