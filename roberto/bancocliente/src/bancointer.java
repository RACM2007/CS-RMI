
import java.rmi.*;
import java.util.ArrayList;
public interface bancointer extends Remote{

    public boolean ingresar(String a, String b) throws RemoteException;
    public String [][] bcliente() throws RemoteException;
    public ArrayList<cliente> datosclientes() throws RemoteException;
    public ArrayList<movimientos> datosmov() throws RemoteException;
    public ArrayList<cuenta> datoscue() throws RemoteException;
    public void agregarcliente(cliente c) throws RemoteException;
    
    
}
