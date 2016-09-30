package servicio;

import java.rmi.*;
import java.rmi.server.*;

import remoto.servicio.Sumador;

public class SumadorImpl extends UnicastRemoteObject
              implements Sumador {

  public SumadorImpl() throws RemoteException {
    super();
  }

  public int sumar(int a, int b) throws RemoteException {
    return a + b;
  }
}