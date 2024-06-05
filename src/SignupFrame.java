package src;

public class SignupFrame {


  public static boolean isValidUser(String username) {
    String[] invalidChars = {")","(","*","&","^","%","$","#","!","?","{","}",";",":","<",">",",","/","'"};
    if (username.length() > 8 && username.length() < 16) {
      for (String invalidChar : invalidChars) {
        if (username.contains(invalidChar)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public static boolean isValidEmail(String email) {
    return true;
  }

  public static boolean isValidPassword(String password) {
    return true;
  }
}
