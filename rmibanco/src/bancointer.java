import java.rmi.*;
import java.util.Arrays;
public interface bancointer extends Remote{

    public cuenta buscar(String prop) throws RemoteException;
    public boolean eliminar(String cod) throws RemoteException;
    public boolean agregar(String id, double saldo, String tipo, String fecha, int prop) throws RemoteException;
    public boolean modificar(String id, double saldo, String tipo, String fecha, int prop) throws RemoteException;
}
