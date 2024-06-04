package src;

public class ShipmentThread extends Thread {

  //static boolean run = true;
  static boolean request = false;
  static Product[] prod;
  static String prodClass;

  public static void delay(int mills) {
    try {
      Thread.sleep(mills);
    } catch (InterruptedException e) {
    }
  }

  public static void setElement(Object[] o, int index, String p) {
    if (p.equals(PS5.getProdName())) {
      o[index] = new PS5();
    }
    else if (p.equals(XBoxSS.getProdName())) {
      o[index] = new XBoxSS();
    }
    else if (p.equals(XBoxSX.getProdName())) {
      o[index] = new XBoxSX();
    }
    else if (p.equals(GamingPC.getProdName())) {
      o[index] = new GamingPC();
    }
    else if (p.equals(NintendoSwitch.getProdName())) {
      o[index] = new NintendoSwitch();
    }
    else if (p.equals(OculusQuest3.getProdName())) {
      o[index] = new OculusQuest3();
    }

  }

  public void requestShip(Product[] p, String pC) {
    prod = new Product[p.length];
    prodClass = pC;
    request = true;
  }

  public void shipping() {
    System.out.println("Expect shipment in 10 seconds!");
    delay(10000);
    System.out.println("new shipment has arrived");
    prod = new Product[prod.length];

    for (int i = 0; i < prod.length; i++) {
      setElement(prod, i, prodClass);
      System.out.println(prod[i]);
      System.out.println("\u001B[95mTotal stock of store: \u001B[94m" + Product.getStock() + "\u001B[0m");
      System.out.println("\n------------------------------");
    }
    request = false;
  }

  public void run() {
    if (request) {
      System.out.println("shipment is on its way!");
      shipping();
    }
  }

}




