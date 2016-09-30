
import java.rmi.*;
import java.rmi.registry.*;

public class SumadorCliente {
  public static void main(String args[]) {
    int res = 0;
    try {
      System.out.println("Buscando objeto ... ");

      Registry registry = LocateRegistry.getRegistry("localhost", 8084);
      Sumador sumador = (Sumador) registry.lookup("sumador");

      res = sumador.sumar(140, 234);

      System.out.println("140 + 234 = " + res);

      System.out.println("Fin de cliente!");
    } catch(Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}