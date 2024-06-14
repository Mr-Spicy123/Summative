package src.GUIs;

import src.FileIO.Reader;
import src.FileIO.Writer;

public class RewriteFile {
  public static void switchPassword(String email, String newPass) {
    //use email to locate index as each account info is on the same line
    int lineNum = Reader.findIndex(email, Reader.emailFile);
    int ind = lineNum-1;
    String[] allPasses = Reader.getArray(Reader.passwordsFile);
    allPasses[ind] = newPass;
    Writer.emptyFile(Writer.passwordsFile);
    Writer.fillFile(allPasses, Writer.passwordsFile);
  }

  public static void switchBalance(String userEmail, String balance) {
    int lineNum = Reader.findIndex(userEmail, Reader.emailFile);
    int ind = lineNum-1;
    String[] allBalances = Reader.getArray(Reader.balanceFile);
    allBalances[ind] = balance;
    Writer.emptyFile(Writer.balanceFile);
    Writer.fillFile(allBalances, Writer.balanceFile);
  }
}
