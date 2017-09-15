package com.sp.dao;

import com.sp.beans.Products;
import java.sql.PreparedStatement;

public class UpdateProductDao
{
  public UpdateProductDao() {}
  
  public void update(Products pros)
  {
    java.sql.Connection con = null;
    PreparedStatement pstmt = null;
    con = com.sp.connection.Connections.getConnection();
    int result = 0;
    try {
      pstmt = con.prepareStatement("insert into LIFESTYLE(PRODUCTNO,PRODUCTNAME,PRODUCTPRICE) values (?,?,?)");
      pstmt.setInt(1, pros.getProductcode());
      pstmt.setString(2, pros.getProductname());
      pstmt.setDouble(3, pros.getProductprice());
      result = pstmt.executeUpdate();
    }
    catch (java.sql.SQLException e) {
      e.printStackTrace();
    }
    com.sp.connection.Connections.closeConnection();
  }
}
