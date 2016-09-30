
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

import remoto.servicio.Sumador;
import servicio.SumadorImpl;
import db.ConnectionFactory;

import remoto.modelo.Usuario;

import repositorio.UsuarioRepositorio;
import repositorio.impl.UsuarioRepositorioImpl;

public class SumadorServer {

  public static void main(String args[]) {
    try {

      UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorioImpl(ConnectionFactory.getConnection());

      Usuario usuario = new Usuario("test1", "test1");
      usuario.setId(7);
      usuario.setLogin("asdf");
      usuario.setPassword("asdf");

      System.out.println(usuarioRepositorio.obtenerPorLogin("hugo"));

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