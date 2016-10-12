import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class sqlope {
    
    public static final String RETIRO = "RETIRO";
    public static final String DEPOSITO = "DEPOSITO";
    public static final String TRANSFERENCIA = "TRANSFERENCIA";
    
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
    
    cuenta obtenerCuentaPorId(Integer id) {
        cuenta cuenta = null;
        try{
            String query = "select * from cuenta where id=?";
            PreparedStatement statement = con.getConnection().prepareStatement(query);
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                cuenta = new cuenta();
                cuenta.setId(rs.getInt(1));
                cuenta.setSaldo(rs.getDouble(2));
                cuenta.setTipo(rs.getString(3));
                cuenta.setFechaa(rs.getDate(4));
                cuenta.setPropietario(rs.getInt(5));
            }
        } catch (Exception e) {
            
        }
        return cuenta;
    }
    
    Integer obtenerUsuarioId(String username) {
        Integer userId = null;
        try{
            String query = "select id from usuario where login=?";
            PreparedStatement statement = con.getConnection().prepareStatement(query);
            statement.setString(1, username);
            
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                userId = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("UserID: " + userId + ", Username: " + username);
        return userId;
    }
    
    void actualizarCuenta(cuenta cuenta, Connection connection) {
        try{
            String query = "UPDATE cuenta SET saldo=?, tipo=?, fechaa=?, propietario=? WHERE id=?";
            PreparedStatement statement =connection.prepareStatement(query);
            statement.setDouble(1, cuenta.saldo);
            statement.setString(2, cuenta.tipo);
            statement.setDate(3, cuenta.fechaa);
            statement.setInt(4, cuenta.propietario);
            statement.setInt(5, cuenta.id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    void agregarMovimiento(movimientos mov, Connection connection) {
        try{
            String query = "INSERT INTO movimientos (monto, usuario, tipo, origenc, origene, destinoc, fecha) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, mov.monto);
            statement.setInt(2, mov.usuario);
            statement.setString(3, mov.tipo);
            
            if (mov.origenc == null) {
                statement.setNull(4, java.sql.Types.INTEGER);
            } else {
                statement.setInt(4, mov.origenc);
            }
            
            if (mov.origene == null) {
                statement.setNull(5, java.sql.Types.VARCHAR);
            } else {
                statement.setString(5, mov.origene);
            }
            
            if (mov.destinoc == null) {
                statement.setNull(6, java.sql.Types.INTEGER);
            } else {
                statement.setInt(6, mov.destinoc);
            }
            
            statement.setDate(7, new java.sql.Date(new Date().getTime()));
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    Connection getConnection() {
        return con.getConnection();
    }
    
    public RespuestaServidor agregarMovimiento(movimientos mov) throws RemoteException {
        RespuestaServidor resp = null;
        Connection connection = null;
        try {
            connection = this.con.getConnection();
            connection.setAutoCommit(false);
            switch (mov.tipo) {
                case RETIRO:
                    resp = retiro(mov, connection);
                    break;
                case TRANSFERENCIA:
                    resp = transferencia(mov, connection);
                    break;
                case DEPOSITO:
                    resp = deposito(mov, connection);
                    break;
            }
            connection.commit();
        } catch (BusinessException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {}
            resp = RespuestaServidor.getError(e.getMessage());
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {}
            resp = RespuestaServidor.getError("Error al procesar, transacción cancelada.");
        }
        
        return resp;
    }
    
    private RespuestaServidor retiro(movimientos mov, Connection connection) throws BusinessException {
        cuenta cuentaOrigen = obtenerCuentaPorId(mov.origenc);
                
        if (cuentaOrigen == null) {
            throw new BusinessException("Cuenta de origen del retiro inexistente, trasacción cancelada.");
        }

        if (cuentaOrigen.saldo < mov.monto) {
            throw new BusinessException("Saldo insuficiente para realizar el retiro, trasacción cancelada.");
        } 
        cuentaOrigen.saldo -= mov.monto;
        
        actualizarCuenta(cuentaOrigen, connection);
        agregarMovimiento(mov, connection);
        return RespuestaServidor.getExito("Retiro realzado con exitosamente");
    }
    
    private RespuestaServidor transferencia(movimientos mov, Connection connection) throws BusinessException {
        cuenta cuentaOrigen = obtenerCuentaPorId(mov.origenc);
        cuenta cuentaDestino = obtenerCuentaPorId(mov.destinoc);

        if (cuentaOrigen == null) {
            throw new BusinessException("Cuenta de origen de la transferencia inexistente, trasacción cancelada.");
        }

        if (cuentaDestino == null) {
            throw new BusinessException("Cuenta de destino de la transferencia inexistente, trasacción cancelada.");
        }

        if (cuentaOrigen.saldo < mov.monto) {
            throw new BusinessException("Saldo insuficiente para realizar la transferencia, trasacción cancelada.");
        }

        cuentaOrigen.saldo -= mov.monto;
        cuentaDestino.saldo += mov.monto;
        
        actualizarCuenta(cuentaOrigen, connection);
        actualizarCuenta(cuentaDestino, connection);
        agregarMovimiento(mov, connection);
        return RespuestaServidor.getExito("Transferencia realzada con exitosamente.");
    }
    
    private RespuestaServidor deposito(movimientos mov, Connection connection) throws BusinessException {
        cuenta cuentaDestino = obtenerCuentaPorId(mov.destinoc);
                
        if (cuentaDestino == null) {
            throw new BusinessException("Cuenta de destino del deposito inexistente, trasacción cancelada.");
        }

        cuentaDestino.saldo += mov.monto;
        
        actualizarCuenta(cuentaDestino, connection);
        agregarMovimiento(mov, connection);
        return RespuestaServidor.getExito("Deposito realzado con exitosamente.");
    }

    void modicli(int cod, String dni, String nom, String ap, String am, String tel) {
          
        //String q = " UPDATE cliente SET dni = "+dni+", nombre = "+nom+" apellidop = "+ap+" apellidom = "+am+" telefono = "+tel+" WHERE id= " + cod;
        try {
            String query = "UPDATE CLIENTE SET dni = ?, nombre = ? , apellidop = ?, apellidom = ?, telefono = ? WHERE id = ?";
            PreparedStatement statement = con.getConnection().prepareStatement(query);
            
            statement.setString(1, dni);
            statement.setString(2, nom);
            statement.setString(3, ap);
            statement.setString(4, am);
            statement.setString(5, tel);
            statement.setInt(6, cod);
            
            statement.executeUpdate();
           
         }catch(SQLException e){            
             e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No se realizó por "+e);
        }
    }

    void elicli(int i) {
        try {
            String query = "DELETE FROM CLIENTE  WHERE id = ?";
            PreparedStatement statement = con.getConnection().prepareStatement(query);
            
            statement.setInt(1, i);
            
            statement.executeUpdate();
           
         }catch(SQLException e){            
             e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No se realizó por "+e);
        }
    }

    void elicue(int i) {
        try {
            String query = "DELETE FROM CUENTA  WHERE id = ?";
            PreparedStatement statement = con.getConnection().prepareStatement(query);
            
            statement.setInt(1, i);
            
            statement.executeUpdate();
           
         }catch(SQLException e){            
             e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No se realizó por "+e);
        }
    }

    ArrayList<cliente> datosclientesfil(String text) {
        ArrayList <cliente> dc= new ArrayList();
        cliente c;
        try{
            String sentencia= "select * from cliente where dni like '"+text+"%'";
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

    ArrayList<cliente> datosclientesfilnom(String text) {
        ArrayList <cliente> dc= new ArrayList();
        cliente c;
        try{
            String sentencia= "select * from cliente where concat (nombre,' ',apellidop,' ',apellidom) like '"+text+"%'";
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

    void agregarusuario(String text, String text0) {
        boolean flag=true;
        try{
            PreparedStatement statement = con.getConnection().prepareStatement("INSERT INTO `usuario` (login, password) VALUES (?,?)");
            statement.setString(1, text);
            statement.setString(2, text0);
            flag=false;
            statement.executeUpdate();
            
        } catch (Exception e){
            System.out.print(e);
        }
        if(!flag){
            JOptionPane.showMessageDialog(null, "Usuario "+text+" Exitosamente Agregado");
        }
    }
    
}
