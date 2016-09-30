package remoto.servicio;

import java.rmi.*;

public interface Sumador extends Remote {

  public int sumar(int a, int b) throws RemoteException;

}