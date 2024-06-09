package src;

public class AccountRequirements {

  public static boolean checkPassword(String pass) {
    if (pass.length() > 7 && pass.length() < 17) {
      return true;
    }
    return false;
  }

  public static boolean checkUsername(String user) {
    String[] invalidChars = {")","(","*","&","^","%","$","#","!","?","{","}",";",":","<",">",",","/","'"};
    if (user.length() > 8 && user.length() < 16) {
      for (String invalidChar : invalidChars) {
        if (user.contains(invalidChar)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
