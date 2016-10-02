package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import util.Parametros;

public class ConnectionFactory {

  private static Connection connection = null;
  private static Parametros parametros = null;

  public static void setParametros(Parametros params) {
    parametros = params;
  }

  public static Connection getConnection() {
    try {

      String driver = "com.mysql.jdbc.Driver";
      String host = parametros.getHostDB();
      Integer port = parametros.getPortDB();
      String user = parametros.getUserDB();
      String pass = parametros.getPassDB();
      String database = parametros.getNameDB();
      String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";

      Class.forName(driver);
      connection = DriverManager.getConnection(url, user, pass);

    } catch(ClassNotFoundException e) {
      connection = null;
      e.printStackTrace();
    } catch(SQLException e) {
      connection = null;
      e.printStackTrace();
    }

    return connection;
  }

  public static Boolean testConnection() {
    Boolean isConnected = false;
    try {
      Connection con = getConnection();
      isConnected = con != null && !con.isClosed();
     } catch(SQLException e) {
      e.printStackTrace();
    }

    return isConnected;
  }

}