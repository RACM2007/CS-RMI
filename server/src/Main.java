
import db.ConnectionFactory;

import ui.FramePrincipal;
import util.Parametros;

import servidor.RMIServer;

public class Main {

  public static void main(String args[]) {
    try {

      new FramePrincipal();

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

}