package com.sp.beans;

public class Products { private int productcode;
  private String productname;
  private double productprice;
  
  public Products() {}
  
  public int getProductcode() { return productcode; }
  
  public void setProductcode(int productcode)
  {
    this.productcode = productcode;
  }
  
  public String getProductname() {
    return productname;
  }
  
  public void setProductname(String productname) {
    this.productname = productname;
  }
  
  public double getProductprice() {
    return productprice;
  }
  
  public void setProductprice(double productprice) {
    this.productprice = productprice;
  }
}
