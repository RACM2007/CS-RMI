import java.sql.*;
import javax.swing.JOptionPane;


public class ConexionDB {
    
    Connection con = null;
    boolean estado;
    
    ConexionDB(String ip, int puerto, String user, String pass, String bd, Boolean silent){
        estado=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"+ip+":"+puerto+"/"+bd,user,pass);
                if (con!=null){
                    estado=true;
                    if (!silent) {
                        JOptionPane.showMessageDialog(null,"Coneccion a La Base de Datos Realizada");
                    }
            }else{
                    if (!silent) {
                     JOptionPane.showMessageDialog(null,"Coneccion a la base de datos no se ha efectuado");   
                    }
                }
        }catch(Exception ex){
            ex.printStackTrace();
            if (!silent) {
                JOptionPane.showMessageDialog(null,ex);
                JOptionPane.showMessageDialog(null, "Error en Conexion DB");
            }
        }     
    }
    
    ConexionDB(String ip, int puerto, String user, String pass, String bd){
        estado=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"+ip+":"+puerto+"/"+bd,user,pass);
                if (con!=null){
                    estado=true;
            JOptionPane.showMessageDialog(null,"Coneccion a La Base de Datos Realizada");
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
