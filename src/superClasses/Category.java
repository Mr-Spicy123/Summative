package src.superClasses;

import javax.swing.*;


public class Category {
  //instance variables
  private DisplayProduct[] items;
  private String categoryName;
  private ImageIcon imageRoot;
  //constructor chain
  //default constructor
  public Category() {
    this (null, "no data", new ImageIcon("C:\\Users\\jacks\\OneDrive\\CS_Summative_Images\\noDataImage.jpg"));
  }
  //overloaded constructor
  public Category(DisplayProduct[] items, String categoryName, ImageIcon imageRoot) {
    this.items = items;
    this.categoryName = categoryName;
    this.imageRoot = imageRoot;
  }


  //instance methods
  public String getCategoryName() {
    return categoryName;
  }


  public ImageIcon getImageRoot() {
    return imageRoot;
  }


  public DisplayProduct[] getItems() {
    return items;
  }
  //toString

  public int compareTo(Category c) {
    return c.getCategoryName().compareTo(categoryName);
  }
}






