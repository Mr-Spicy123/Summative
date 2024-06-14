package src.threads;

import src.misc.CurrentUser;

import javax.swing.*;
import java.util.Currency;

public class PaycheckThread extends Thread{



  public void run() {
    if (CurrentUser.getCurrentBalance() < 500) {
      sendMoney();
    }
  }

  public static void sendMoney() {
    JOptionPane.showMessageDialog(null, "Looks like you're getting low on money! Paycheck is sending!");
    try {
      Thread.sleep(10000);
    }catch(InterruptedException e) {
    }
    JOptionPane.showMessageDialog(null, "Paycheck is sent!");
    //subtracting a negative number will increase the balance
    CurrentUser.subtractBalance(-1000);
  }
}
