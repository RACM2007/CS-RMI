package servidor;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

import db.ConnectionFactory;

import remoto.modelo.Usuario;
import remoto.servicio.UsuarioServicio;

import repositorio.UsuarioRepositorio;
import repositorio.impl.UsuarioRepositorioImpl;

import servicio.UsuarioServicioImpl;

import util.Parametros;

public class RMIServer {

  private Registry registry;
  private Parametros parametros;

  public RMIServer() {
  }

  public void iniciarServidor(Parametros parametros) {
    try {
      System.out.println("Iniciando servidor ... ");
      ConnectionFactory.setParametros(parametros);
      UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorioImpl(ConnectionFactory.getConnection());
      UsuarioServicio usuarioServicio = new UsuarioServicioImpl(usuarioRepositorio);

      // Bind the remote object's stub in the registry
      registry = LocateRegistry.createRegistry(parametros.getPortRMI());
      registry.bind("usuario", usuarioServicio);

      System.out.println("Servidor iniciado!");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public void detenerServidor() {
    System.out.println("Deteniendo servidor ... ");
    if (registry != null) {
      try {
        UnicastRemoteObject.unexportObject(registry, true);
        registry = null;
        System.out.println("Servidor detenido!");
      } catch (NoSuchObjectException e) {
        e.printStackTrace();
      }
    }
  }

}