import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

class servidor extends UnicastRemoteObject implements bancointer{

    sqlope ope;
    
    public servidor(String dir, int puerto,String dirda, int puertoda, String userda, String passda, String bd) throws RemoteException{
        super();
        try{
                ope= new sqlope(dirda, puertoda, userda, passda, bd);
               Registry registro=LocateRegistry.createRegistry(1099);
               registro.rebind("rmi://"+dir+":"+puerto+"/bancoservidor", this);
               JOptionPane.showMessageDialog(null,"Servidor Activo");
           } catch (Exception ex){
               JOptionPane.showMessageDialog(null,ex.getMessage());
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

    
}
