
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class SumadorServer {

  public static void main(String args[]) {
    try {
      System.out.println("Iniciando servidor ... ");
      Sumador sumador = new SumadorImpl();

      // Bind the remote object's stub in the registry
      Registry registry = LocateRegistry.createRegistry(8084);
      registry.bind("sumador", sumador);

      System.out.println("Server ready!");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

}