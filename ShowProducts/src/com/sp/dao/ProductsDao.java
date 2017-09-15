package com.sp.dao;

import com.sp.beans.Products;
import com.sp.connection.Connections;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao
{
  public ProductsDao() {}
  
  public List<Products> getProducts(String categogy) throws Exception
  {
    List<Products> listproducts = new ArrayList();
    if (categogy.equalsIgnoreCase("lifestyle")) {
      Products products = null;
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      





      con = Connections.getConnection();
      

      stmt = con.createStatement();
      rs = stmt.executeQuery("select *from LIFESTYLE");
      
      while (rs.next()) {
        products = new Products();
        products.setProductcode(rs.getInt("PRODUCTNO"));
        products.setProductname(rs.getString("PRODUCTNAME"));
        products.setProductprice(rs.getDouble("PRODUCTPRICE"));
        listproducts.add(products);
      }
      

      Connections.closeConnection();
    }
    else {
      throw new Exception("Plz enter a valid URL");
    }
    
    return listproducts;
  }
}
