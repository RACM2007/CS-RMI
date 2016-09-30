package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory {

  public static final String driver = "com.mysql.jdbc.Driver";
  public static final String host = "localhost";
  public static final String port = "3306";
  public static final String user = "root";
  public static final String pass = "123456";
  public static final String database = "banco";
  public static final String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";

  private static Connection connection = null;

  public static Connection getConnection() {
    try {
      if (connection == null || connection.isClosed()) {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Connected!");
      }
    } catch(ClassNotFoundException e) {
      e.printStackTrace();
    } catch(SQLException e) {
      e.printStackTrace();
    }

    return connection;
  }

}