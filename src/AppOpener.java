package src;
import java.io.*;
public class AppOpener {
  public static void openGmail() {
    try {
      String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
      String profileDirectory = "Default";
      String url = "https://mail.google.com";
      // Path to the Chrome executable
      String command = chromePath + " --profile-directory=\"" + profileDirectory + "\" " + url;
      // Start the process
      Process process = Runtime.getRuntime().exec(command);
      // Optional: wait for the process to complete
      process.waitFor();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
