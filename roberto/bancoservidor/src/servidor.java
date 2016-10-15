import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperPrint;

class servidor extends UnicastRemoteObject implements bancointer{
    
    sqlope ope;
    Registry registro;
    
    public servidor(String dir, int puerto,String dirda, int puertoda, String userda, String passda, String bd) throws RemoteException{
        super();
        try{
            Parametros.HOST_DB = dirda;
            Parametros.PORT_DB = puertoda;
            Parametros.BD = bd;
            Parametros.USER = userda;
            Parametros.PASS = passda;
            
                ope= new sqlope(dirda, puertoda, userda, passda, bd);
                registro=LocateRegistry.createRegistry(puerto);
               registro.bind("bancoservidor", this);
               
           } catch (Exception ex){
               JOptionPane.showMessageDialog(null,ex.getMessage());
           }
            if(ope.con.estado){
                JOptionPane.showMessageDialog(null, "Servidor Activo");
            }
    }

    public boolean ingresar(String login, String pass) throws RemoteException {

        return ope.ingresar(login, pass);
        
    }

    @Override
    public String[][] bcliente() throws RemoteException {
        String [][] a= new String [50][50];
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","123456");
            String sentencia= "select * from cliente";
            Statement stm= (Statement) cn.createStatement();
            ResultSet rs= stm.executeQuery(sentencia);
            
            int i=0,j=0;
            while(rs.next()){
                    a[i][j]=rs.getString(2);
                    a[i][j+1]=rs.getString(3);
                    a[i][j+2]=rs.getString(4);
                    a[i][j+3]=rs.getString(5);
                    a[i][j+4]=rs.getString(6);
                i++;
                
                
            }
            
        } catch (Exception e){
            System.out.print(e);
        }
        return a;
    }

    public ArrayList<cliente> datosclientes() throws RemoteException{
        ArrayList <cliente> dc= ope.datosclientes();
        return dc;
    
    }

    public ArrayList<movimientos> datosmov() throws RemoteException {
        ArrayList <movimientos> dm= ope.datosmovi();
        return dm;
    }
    
    public ArrayList<cuenta> datoscue() throws RemoteException {
        ArrayList <cuenta> dcu= ope.datoscue();
        return dcu;
    }

    public void agregarcliente(cliente c) throws RemoteException {
        ope.agregarcliente(c);
    }

    public void agregarCuenta(cuenta c) throws RemoteException {
        ope.agregarcuenta(c);
    }
    
    public RespuestaServidor agregarMovimiento(movimientos mov) throws RemoteException {
        return ope.agregarMovimiento(mov);
    }

   
    public void modicli(int cod, String dni, String nom, String ap, String am, String tel) throws RemoteException{
        ope.modicli(cod,dni,nom,ap,am,tel);
    }

    
    public void elicli(int i) throws RemoteException{
        ope.elicli(i);
    }

    public void elicue(int i) throws RemoteException{
        ope.elicue(i);
    }

    void stop() throws RemoteException{
        try{
        UnicastRemoteObject.unexportObject(registro, true);
        registro = null;
        
        } catch (Exception ex){
               JOptionPane.showMessageDialog(null,ex);
           }
    }

    public ArrayList<cliente> datosclientesfil(String text) throws RemoteException {
        ArrayList <cliente> dc= ope.datosclientesfil(text);
        return dc;
    }

    public ArrayList<cliente> datosclientesfilnom(String text) throws RemoteException {
        ArrayList <cliente> dc= ope.datosclientesfilnom(text);
        return dc;
    }

    public Integer obteneruserid(String text) throws RemoteException {
        return ope.obtenerUsuarioId(text);
    }

    public void agregarusuario(String text, String text0) throws RemoteException {
        ope.agregarusuario(text,text0);
    }

    @Override
    public JasperPrint obtenertReporte(String nombre, Map<String, Object> parametros) throws RemoteException {
        return new ReportManager().getReport(nombre, parametros);
    }
}
