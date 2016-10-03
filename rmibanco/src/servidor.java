import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

class servidor extends UnicastRemoteObject implements bancointer{

    public servidor() throws RemoteException{
        super();
    }

    @Override
    public cuenta buscar(String prop) throws RemoteException {
        int id;
        double saldo;
        String tipo, fecha;
        int propietario;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","123456");
            String sentencia= "select * from cuenta where propietario='"+prop+"'";
            Statement stm= (Statement) cn.createStatement();
            ResultSet rs= stm.executeQuery(sentencia);
            while(rs.next()){
                System.out.println("tatata");
                id=rs.getInt(1);
                System.out.println(id);
                saldo=rs.getDouble(2);
                tipo=rs.getString(3);
                fecha=rs.getString(4);
                propietario=rs.getInt(5);
                cuenta cu = new cuenta (id,saldo,tipo,fecha,propietario);
                return cu;
                
            }
            
        } catch (Exception e){
            System.out.print(e);
        }
        return null;
    }


    @Override
    public boolean eliminar(String cod) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(String id, double saldo, String tipo, String fecha, int prop) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(String id, double saldo, String tipo, String fecha, int prop) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        try{
               Registry registro=LocateRegistry.createRegistry(1099);
               registro.rebind("rmi://localhost:1099/rmibanco", new servidor());
               JOptionPane.showMessageDialog(null,"Servidor Activo");
           } catch (Exception ex){
               System.out.println(ex.getMessage());
           }
    }
}
