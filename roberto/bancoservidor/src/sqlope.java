import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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

    ArrayList<cliente> datosclientes() throws RemoteException{
        ArrayList <cliente> dc= new ArrayList();
        cliente c;
        try{
            String sentencia= "select * from cliente";
            Statement stm= (Statement) con.getConnection().createStatement();
            ResultSet rs= stm.executeQuery(sentencia);
  
            while(rs.next()){
                
                c= new cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
                dc.add(c);
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al extraer datos del cliente sqlope");
        }
        
        return dc;
    }

    ArrayList<movimientos> datosmovi() throws RemoteException{
        ArrayList <movimientos> dm= new ArrayList();
        movimientos c;
        try{
            String sentencia= "select * from movimientos";
            Statement stm= (Statement) con.getConnection().createStatement();
            ResultSet rs= stm.executeQuery(sentencia);
            while(rs.next()){
                //System.out.println(rs.getInt(1)+rs.getDouble(2)+rs.getInt(3)+rs.getString(4)+rs.getInt(5)+rs.getString(6)+rs.getInt(7)+rs.getString(8));
             c= new movimientos(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getString(4), rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getDate(8));
                dm.add(c);
            }
            
            
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al extraer datos del cliente sqlope11"+e);
        }
        
        return dm;
    }

    ArrayList<cuenta> datoscue() {
        ArrayList <cuenta> dcu= new ArrayList();
        cuenta c;
        try{
            String sentencia= "select * from cuenta";
            Statement stm= (Statement) con.getConnection().createStatement();
            ResultSet rs= stm.executeQuery(sentencia);
            while(rs.next()){
                //System.out.println(rs.getInt(1)+rs.getDouble(2)+rs.getInt(3)+rs.getString(4)+rs.getInt(5)+rs.getString(6)+rs.getInt(7)+rs.getString(8));
             c= new cuenta(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getDate(4), rs.getInt(5));
                dcu.add(c);
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al extraer datos del cliente sqlope "+e);
        }
        
        return dcu;
    }

    void agregarcliente(cliente c) {
        try{
            PreparedStatement statement = con.getConnection().prepareStatement("INSERT INTO `cliente` (dni, nombre, apellidop, apellidom, telefono) VALUES (?,?,?,?,?)");
            statement.setString(1, c.dni);
            statement.setString(2, c.nombre);
            statement.setString(3, c.apellidop);
            statement.setString(4, c.apellidom);
            statement.setString(5, c.telefono);
            
            statement.executeUpdate();
            
        } catch (Exception e){
            System.out.print(e);
        }
    }
    
    void agregarcuenta(cuenta c) {
        try{
            PreparedStatement statement = con.getConnection().prepareStatement("INSERT INTO `cuenta` (saldo, tipo, fechaa, propietario) VALUES (?,?,?,?)");
            statement.setDouble(1, 0);
            statement.setString(2, c.tipo);
            statement.setDate(3, new java.sql.Date(new Date().getTime()));
            statement.setInt(4, c.propietario);
            
            statement.executeUpdate();
            
        } catch (Exception e){
            System.out.print(e);
        }
    }
    
}
