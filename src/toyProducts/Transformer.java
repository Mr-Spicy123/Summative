package src.toyProducts;

import src.misc.ImageIconScaler;
import src.superClasses.Product;

import javax.swing.*;

public class Transformer extends Product {
  private static final String prodName = "Transformer";
  private static final double transformerPrice = 23.99;
  private static final int expandedWidth = 479;
  private static final int   expandedHeight = 479;
  private static final ImageIcon transformerImage = new ImageIcon("images/transformer.jpg");
  private static final ImageIcon transformerScaledImage = ImageIconScaler.scaleImageIcon(transformerImage, expandedWidth, expandedHeight);
  private static final String[] detailTransformer = {
          "Transform your playtime with the action-packed wor-",
          "ld of Transformer toys! From cars to robots in a-",
          "few easy steps, these toys offer thrilling trans-",
          "formations and endless adventures. Perfect for ima-",
          "ginative play and collectors alike, Transformers-",
          "bring iconic characters to life with their unique-",
          "designs and intricate details."
  };

  //parameter int n is to differentiate a default object with a non default object; int n is never intended to be used
  public Transformer() {
    super(prodName, transformerPrice, transformerImage, transformerScaledImage, detailTransformer);
  }

  public static String[] getDetailTransformer() {
    return detailTransformer;
  }

  public static ImageIcon getTransformerImage() {
    return transformerImage;
  }

  public static String getProdName() {
    return prodName;
  }
  public static double getTransformerPrice() {
    return transformerPrice;
  }

  public static ImageIcon getTransformerScaledImage() {
    return transformerScaledImage;
  }
  @Override
  public String toString(){
    return "\n\u001B[95mProduct type: \u001B[94m" + prodName;
  }


}
