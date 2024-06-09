package src;

public class RewritePasswordFile {

  public static void switchPassword(String email, String newPass) {
    //use email to locate index as each account info is on the same line
    int lineNum = Reader.findIndex(email, Reader.emailFile);
    int ind = lineNum-1;
    String[] allPasses = Reader.getArrayPassword();
    allPasses[ind] = newPass;
    Writer.emptyFile(Writer.passwordsFile);
    Writer.fillFile(allPasses, Writer.passwordsFile);

  }
}
