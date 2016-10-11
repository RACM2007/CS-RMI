
import java.rmi.*;
import java.util.ArrayList;
public interface bancointer extends Remote{

    public boolean ingresar(String a, String b) throws RemoteException;
    public String [][] bcliente() throws RemoteException;
    public ArrayList<cliente> datosclientes() throws RemoteException;
    public ArrayList<movimientos> datosmov() throws RemoteException;
    public ArrayList<cuenta> datoscue() throws RemoteException;
    public void agregarcliente(cliente c) throws RemoteException;
    public void agregarCuenta(cuenta c) throws RemoteException;
    public RespuestaServidor agregarMovimiento(movimientos mov, String username) throws RemoteException;
    public void modicli(int cod, String dni, String nom, String ap, String am, String tel) throws RemoteException;
    public void elicli(int parseInt) throws RemoteException;
    public void elicue(int parseInt) throws RemoteException;
    public ArrayList<cliente> datosclientesfil(String text) throws RemoteException;
    public ArrayList<cliente> datosclientesfilnom(String text) throws RemoteException;
    
    
}
