package src;

import java.util.Random;

public class VerificationCode {
  Random rand = new Random();

  int codeDigit;
  String code;
  static int numCodes;

  public VerificationCode() {
    numCodes++;
    code = "";
    //array of letters in the alphabet without the letters that look like numbers (like o)
    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    for (int i = 1; i <= 6; i++) {
      int typeOfChar = rand.nextInt(0, 2);
      if (typeOfChar == 0) {
        codeDigit = rand.nextInt(0, 10);
        code += codeDigit;
      }
      if (typeOfChar == 1) {
        codeDigit = rand.nextInt(0, 25);
        code += alphabet[codeDigit];
      }
    }
    //System.out.println(code.toUpperCase());
  }

  public String getCode() {
    return code;
  }

}
