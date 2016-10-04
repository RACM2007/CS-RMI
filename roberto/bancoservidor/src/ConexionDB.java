import java.sql.*;
import javax.swing.JOptionPane;


public class ConexionDB {
    
    Connection con = null;
    
    ConexionDB(String ip, int puerto, String user, String pass, String bd){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"+ip+":"+puerto+"/"+bd,user,pass);
                if (con!=null){
            JOptionPane.showMessageDialog(null,"Coneccion a base de datos Realizada");
         }else{
                    JOptionPane.showMessageDialog(null,"Coneccion a la base de datos no se ha efectuado");
                }
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null,ex);
         JOptionPane.showMessageDialog(null, "Error en Conexion DB");
        }     
    }
    
    public Connection getConnection(){
      return con;
   }

   public void desconectar(){
      con = null;
      JOptionPane.showMessageDialog(null,"La conexion a la  base de datos a terminado");
   }
    
    

}
