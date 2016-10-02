
import javax.swing.UIManager;

import db.ConnectionFactory;

import ui.FramePrincipal;
import util.Parametros;

import servidor.RMIServer;

public class Main {

  public static void main(String args[]) {
    try {

      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      new FramePrincipal();

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

}