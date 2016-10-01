package remoto.servicio;

import java.rmi.*;

import remoto.modelo.Usuario;

public interface UsuarioServicio extends Remote {

  public Boolean esUsuarioValido(Usuario usuario) throws RemoteException;

}