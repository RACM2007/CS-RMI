
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

import db.ConnectionFactory;

import remoto.modelo.Usuario;
import remoto.servicio.UsuarioServicio;

import repositorio.UsuarioRepositorio;
import repositorio.impl.UsuarioRepositorioImpl;

import servicio.UsuarioServicioImpl;

import ui.FramePrincipal;

public class Server {

  public static void main(String args[]) {
    try {

      UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorioImpl(ConnectionFactory.getConnection());
      UsuarioServicio usuarioServicio = new UsuarioServicioImpl(usuarioRepositorio);

      System.out.println("Iniciando servidor ... ");
      new FramePrincipal();

      // Bind the remote object's stub in the registry
      Registry registry = LocateRegistry.createRegistry(8084);
      registry.bind("usuario", usuarioServicio);

      System.out.println("Server ready!");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

}