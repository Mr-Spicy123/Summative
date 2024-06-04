package src;

import java.io.*;
public class Reader {

  public static int getNumLinesUserBalance() {
    String line = "";
    int counter = 0;
    try {
      FileReader fr = new FileReader("UserBalance.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while (line != null) {
        counter++;
        line = br.readLine();
      }
      br.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
    return counter;
  }

  public static int getNumLinesUserInfo() {
    String line = "";
    int counter = 0;
    try {
      FileReader fr = new FileReader("UserInfo.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while (line != null) {
        counter++;
        line = br.readLine();
      }
      br.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
    return counter;
  }

  public static String readLastUserBalance() {
    String line = "";
    int fileLength = getNumLinesUserBalance();
    try {
      FileReader fr = new FileReader("UserBalance.txt");
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < fileLength; i++) {
        line = br.readLine();
      }
      br.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
    return line;
  }

  public static String readLastUserInfo() {
    String line = "";
    int fileLength = getNumLinesUserInfo();
    try {
      FileReader fr = new FileReader("UserInfo.txt");
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < fileLength; i++) {
        line = br.readLine();
      }
      br.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
    return line;
  }

  public static String readThisLineUserInfo(int lineNum) {
    String line = "";
    try {
      FileReader fr = new FileReader("UserInfo.txt");
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < lineNum; i++) {
        line = br.readLine();
      }
      br.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
    return line;
  }

  public static String readThisLineUserBalance(int lineNum) {
    String line = "";
    try {
      FileReader fr = new FileReader("UserBalance.txt");
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < lineNum; i++) {
        line = br.readLine();
      }
      br.close();
    }catch(IOException e) {
      System.err.println("IO");
    }
    return line;
  }



  //reads first line of file (not useful)
  /*public static String readUserBalance() {
    String line = "";
    try {
      FileReader fr = new FileReader("UserBalance.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
    }catch(IOException e) {
      System.err.println("IO");
    }
    return line;
  }
  public static String readUserInfo() {
    String line = "";
    try {
      FileReader fr = new FileReader("UserInfo.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
    }catch(IOException e) {
      System.err.println("IO");
    }
    return line;
  }*/

}
