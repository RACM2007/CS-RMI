
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

import remoto.servicio.Sumador;
import servicio.SumadorImpl;
import db.ConnectionFactory;

import remoto.modelo.Usuario;

import repositorio.UsuarioRepositorio;
import repositorio.impl.UsuarioRepositorioImpl;

import remoto.servicio.UsuarioServicio;
import servicio.UsuarioServicioImpl;

public class SumadorServer {

  public static void main(String args[]) {
    try {

      UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorioImpl(ConnectionFactory.getConnection());
      UsuarioServicio usuarioServicio = new UsuarioServicioImpl(usuarioRepositorio);

      System.out.println("Iniciando servidor ... ");
      Sumador sumador = new SumadorImpl();

      // Bind the remote object's stub in the registry
      Registry registry = LocateRegistry.createRegistry(8084);
      registry.bind("sumador", sumador);
      registry.bind("usuario", usuarioServicio);

      System.out.println("Server ready!");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

}