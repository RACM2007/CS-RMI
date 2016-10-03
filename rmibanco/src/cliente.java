import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;


public class cliente extends JFrame implements ActionListener{

    private static boolean ingresar() {
        try{
                
                Registry registro= LocateRegistry.getRegistry("localhost",1099);
                
                bancointer interfaz = (bancointer) registro.lookup("rmi://localhost:1099/rmibanco");
                
                JPanel panel = new JPanel(new BorderLayout(5, 5));

    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
    label.add(new JLabel("Login", SwingConstants.RIGHT));
    label.add(new JLabel("Password", SwingConstants.RIGHT));
    panel.add(label, BorderLayout.WEST);

    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
    JTextField username = new JTextField();
    controls.add(username);
    JPasswordField password = new JPasswordField();
    controls.add(password);
    panel.add(controls, BorderLayout.CENTER);

    JOptionPane.showMessageDialog( null,panel, "login", JOptionPane.QUESTION_MESSAGE);
                
            System.out.println(interfaz.ingresar(username.getText(),password.getText()));            
        return interfaz.ingresar(username.getText(),password.getText());
               
                     
            }catch(Exception ex){
              JOptionPane.showMessageDialog(null,ex);
            }
        return false;
    }
    
      JButton cliente, cuenta, movimiento;
    JLabel cad;
    JTextField txt;
    JPanel pan;
    
    public cliente (){
           
           
           cliente=new JButton ("Clientes") ;
           cuenta=new JButton ("Cuenta");
           movimiento=new JButton ("Realizar un Movimiento Bancario");
           
        pan = new JPanel ();
        pan.add(cliente);
        pan.add(cuenta);
        pan.add(movimiento);
        
        cliente.addActionListener(this);
        
        this.add(pan);
        this.setTitle("BANCO");
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        
//        if(boton==obj){
//            try{
//                
//                Registry registro= LocateRegistry.getRegistry("localhost",1099);
//                
//                bancointer interfaz = (bancointer) registro.lookup("rmi://localhost:1099/rmibanco");
//                
//                String prop;
//                prop=JOptionPane.showInputDialog("Ingrese el codigo del propietario");
//                
//                if(interfaz.buscar(prop)==null){
//                    JOptionPane.showMessageDialog(null, "No encontrado");
//                }else{
//                    JOptionPane.showMessageDialog(null, interfaz.buscar(prop).getSaldo());
//                }
//                     
//            }catch(Exception ex){
//              JOptionPane.showMessageDialog(null,ex);
//            }
//                
//        }
        
        if(cliente==obj){
            new bcliente();
        }
    }
    
    public static void main(String[] args) {
        boolean a= ingresar();
        while(a==false){
            JOptionPane.showMessageDialog(null, "Error en el Login o la Contraseña");
             a= ingresar();
        }
        new cliente();
        
        
    }
    
}
