
import java.rmi.*;
public interface bancointer extends Remote{

    public boolean ingresar(String a, String b) throws RemoteException;
    public String [][] bcliente() throws RemoteException;
    
    
}
