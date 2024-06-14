package src.FileIO;

import java.io.*;

public class Writer {

  public static String emailFile = "Emails.txt";
  public static String passwordsFile = "Passwords.txt";
  public static String usernamesFile = "Usernames.txt";
  public static String balanceFile = "UserBalance.txt";

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

  public static void emptyFile(String file) {
    //this truncates the file, and when closed, leaves it empty
    try {
      FileWriter fw = new FileWriter(file);
      fw.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
  }

  public static void fillFile(String[] newData, String file) {
    try {
      FileWriter fw = new FileWriter(file, true);
      PrintWriter pw = new PrintWriter(fw);
      for (int i = 0; i < newData.length; i++) {
        pw.println(newData[i]);
      }
      pw.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
  }
}
