
import java.rmi.*;
import java.rmi.server.*;

public class SumadorImpl extends UnicastRemoteObject
              implements Sumador {

  public SumadorImpl() throws RemoteException {
    super();
  }

  public int sumar(int a, int b) throws RemoteException {
    return a + b;
  }
}