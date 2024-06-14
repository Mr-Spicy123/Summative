package src.misc;

public class User {

  private static double balance = 500;

  public static void subtractBalance(double num) {
    balance-=num;
  }

  public static double getBalance() {
    return balance;
  }
}
