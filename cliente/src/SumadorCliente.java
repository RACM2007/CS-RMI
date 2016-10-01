
import java.rmi.*;
import java.rmi.registry.*;

import remoto.servicio.Sumador;
import remoto.modelo.Usuario;
import remoto.servicio.UsuarioServicio;

public class SumadorCliente {
  public static void main(String args[]) {
    int res = 0;
    try {
      System.out.println("Buscando objeto ... ");

      Registry registry = LocateRegistry.getRegistry("localhost", 8084);
      Sumador sumador = (Sumador) registry.lookup("sumador");
      UsuarioServicio usuarioServicio = (UsuarioServicio) registry.lookup("usuario");

      Usuario usuario = new Usuario("hugo", "sdfasdf");
      System.out.println("Usuario válido: " + usuarioServicio.esUsuarioValido(usuario));

      res = sumador.sumar(10, 10);

      System.out.println("10 + 10 = " + res);

      System.out.println("Fin de cliente!");
    } catch(Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}