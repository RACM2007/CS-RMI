
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class sqlope {
    ConexionDB con;
    
    public sqlope(String ip, int puerto, String user, String pass, String bd){
        con=new ConexionDB(ip,puerto,user,pass,bd);
    }
    
    public boolean ingresar(String login, String pass){
        try{
            String sentencia= "select * from usuario";
            Statement stm= (Statement) con.getConnection().createStatement();
            ResultSet rs= stm.executeQuery(sentencia);
            while(rs.next()){
                if(login.equalsIgnoreCase(rs.getString(2))&&pass.equalsIgnoreCase(rs.getString(3))){
                    return true;
                }   
            }
        } catch (Exception e){
            System.out.print(e);
        }
        return false;
    }
    
    public String[][] bcliente() throws RemoteException {
        String [][] a= new String [50][50];
        try{
            String sentencia= "select * from cliente";
            Statement stm= (Statement) con.getConnection().createStatement();
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
