package src.threads;

import src.misc.CurrentUser;

import javax.swing.*;
import java.util.Currency;

public class PaycheckThread extends Thread{

  boolean sendMoney = true;

//this will give the user $2000 every 30 seconds
  public void run() {
    while (sendMoney) {
      System.out.println("in paycheck thread");
      try {
        //this will execute every 30 seconds
        System.out.println("waiting 30 seconds...");
        Thread.sleep(30000);
        System.out.println("done waiting");
      } catch (InterruptedException e) {
      }
      //subtracting a negative number will increase the balance
      CurrentUser.subtractBalance(-2000);
      System.out.println("added money");
    }
  }
}
