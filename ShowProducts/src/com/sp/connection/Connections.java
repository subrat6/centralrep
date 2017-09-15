package com.sp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connections
{
  private static Connection connection;
  
  static
  {
    String driverclassname = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "bunty";
    String password = "oracle";
    try
    {
      Class.forName(driverclassname);
      connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    }
  }
  
  private Connections() {}
  
  public static Connection getConnection() {
	/*Connection connection = null;
    String driverclassname = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "bunty";
    String password = "oracle";
    try
    {
      Class.forName(driverclassname);
      connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException|SQLException e) {
      e.printStackTrace();
    }*/
    return connection;
  }
  
  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
