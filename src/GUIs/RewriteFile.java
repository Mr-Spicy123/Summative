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
    int lineNum = 0;
    if (userEmail.contains("@") && userEmail.contains(".")) {
      lineNum = Reader.findIndex(userEmail, Reader.emailFile);
    }
    else {
      lineNum = Reader.findIndex(userEmail, Reader.usernameFile);
    }
    int ind = lineNum-1;
    String[] allBalances = Reader.getArray(Reader.balanceFile);
    allBalances[ind] = balance;
    Writer.emptyFile(Writer.balanceFile);
    Writer.fillFile(allBalances, Writer.balanceFile);
  }


  public static void rewriteStock(String prodName, String newStock) {
    int numLines = Reader.getNumLines(Reader.stockFile);
    String[] allStocks = Reader.getArray(Reader.stockFile);
    int index;
    for (int i = 0; i < numLines; i++) {
      String[] line = allStocks[i].split(":");
      if (line[0].equals(prodName)) {
        index = i;
        allStocks[index] = prodName + ":" + newStock;
        Writer.emptyFile(Writer.stockFile);
        Writer.fillFile(allStocks, Writer.stockFile);
      }
    }
  }
}
