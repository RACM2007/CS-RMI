
import java.rmi.*;
import java.rmi.registry.*;

import remoto.modelo.Usuario;
import remoto.servicio.UsuarioServicio;

public class Cliente {
  public static void main(String args[]) {
    int res = 0;
    try {
      System.out.println("Buscando objeto ... ");

      Registry registry = LocateRegistry.getRegistry("localhost", 8084);

      UsuarioServicio usuarioServicio = (UsuarioServicio) registry.lookup("usuario");

      Usuario usuario = new Usuario("hugo", "654321");
      System.out.println("Usuario válido: " + usuarioServicio.esUsuarioValido(usuario));

      System.out.println("Fin de cliente!");
    } catch(Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}