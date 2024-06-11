package src.FileIO;

import java.io.*;
import java.nio.Buffer;

public class Reader {

  public static String emailFile = "Emails.txt";
  static String passwordsFile = "Passwords.txt";
  public static String usernameFile = "Usernames.txt";
  static String balanceFile = "UserBalance.txt";

  public static int getNumLines(String file) {
    String line;
    int counter = 0;
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while (line != null) {
        counter++;
        line = br.readLine();
      }
      br.close();
    } catch (IOException e) {
      System.err.println("lines IO");
    }
    return counter;
  }

  public static String readLast(String file) {
    String line = "";
    int fileLength = getNumLines(file);
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < fileLength; i++) {
        line = br.readLine();
      }
      br.close();
    } catch (IOException e) {
      System.err.println("IO");
    }
    return line;
  }

  public static String readThisLine(int l, String file) {
    String line = "";
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < l; i++) {
        line = br.readLine();
      }
    } catch (IOException e) {
      System.err.println("this line IO");
    }
    return line;
  }

  public static boolean fileFinder(String userEmail, String password, String file) {
    //file can either be username.txt or emails.txt
    String line = "";
    int counter = 0;
    int fileLength = getNumLines(file);
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < fileLength; i++) {
        counter++;
        if (br.readLine().equals(userEmail)) {
          String pass = readThisLine(counter, passwordsFile);
          if (password.equals(pass)) {
            return true;
          }
          return false;
        }
      }
      br.close();
    } catch (IOException e) {
      System.err.println("file finder IO: " + e.getMessage());
    }
    return false;
  }

  public static boolean isInSystem(String email) {
    String line = "";
    int fileLength = getNumLines(emailFile);
    try {
      FileReader fr = new FileReader(emailFile);
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < fileLength; i++) {
        line = br.readLine();
        if (line.equals(email)) {
          return true;
        }
      }
      br.close();
    } catch (IOException e) {
      System.err.println("IO");
    }
    return false;
  }

  public static String[] getArrayPassword() {
    String[] passes = new String[getNumLines(passwordsFile)];
    try {
      FileReader fr = new FileReader(passwordsFile);
      BufferedReader br = new BufferedReader(fr);
      for (int i = 0; i < getNumLines(passwordsFile); i++) {
        passes[i] = br.readLine();
      }
    } catch (IOException e) {
      System.err.println("IO");
    }
    return passes;
  }

  public static int findIndex(String subject, String file) {
    try {
      FileReader fw = new FileReader(file);
      BufferedReader br = new BufferedReader(fw);
      int counter = 0;
      for (int i = 0; i < getNumLines(file); i++) {
        String line = br.readLine();
        counter++;
        if (line.equals(subject)) {
          return counter;
        }
      }
    } catch (IOException e) {
    }
    return -1;
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