package src;


public class Tester {
  public static void main(String[] args) {
    //Writer.writeUserInfo("hello world!");
    System.out.println(Reader.readLastUserInfo());
    Writer.writeUserInfo("jackson is the best");
  }
}