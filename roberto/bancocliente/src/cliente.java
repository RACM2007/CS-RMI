
import javax.swing.*;
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
import javax.swing.UIManager;


public class cliente extends javax.swing.JFrame {
    
    String direccion;
    int puerto;
    bancointer interfaz;

    public cliente(){
        
        try{
        JPanel panel = new JPanel(new BorderLayout(5, 5));

    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
    label.add(new JLabel("Dirección", SwingConstants.RIGHT));
    label.add(new JLabel("Puerto", SwingConstants.RIGHT));
    panel.add(label, BorderLayout.WEST);

    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
    JTextField direc = new JTextField();
    controls.add(direc);
    JTextField puert = new JTextField();
    controls.add(puert);
    panel.add(controls, BorderLayout.CENTER);

    JOptionPane.showMessageDialog( null,panel, "Conexión RMI", JOptionPane.QUESTION_MESSAGE);
        
        direccion=direc.getText();
        puerto=Integer.parseInt(puert.getText());
            System.out.println(direccion+" "+puerto);
        
        Registry registro= LocateRegistry.getRegistry(direccion,puerto);     
       interfaz = (bancointer) registro.lookup("rmi://"+direccion+":"+puerto+"/bancoservidor");
            System.out.println("121212");
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        boolean i= ingresar();
        while(i==false){
            JOptionPane.showMessageDialog(null, "Error en el Login o la Contraseña");
             i=ingresar();
        }
        
        
        
        initComponents();
        
        this.setVisible(true);
       this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("CREAR DOCUMENTO");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("CUENTAS");

        jButton2.setText("REALIZAR TRANSACCIONES");

        jButton3.setText("CLIENTES");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO AL SISTEMA BANCARIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jButton2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
      
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            
        }
        
        new cliente();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private boolean ingresar() {
        try{
        JPanel paneli = new JPanel(new BorderLayout(5, 5));
        JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
    label.add(new JLabel("Login", SwingConstants.RIGHT));
    label.add(new JLabel("Password", SwingConstants.RIGHT));
    paneli.add(label, BorderLayout.WEST);

    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
    JTextField username = new JTextField();
    controls.add(username);
    JPasswordField password = new JPasswordField();
    controls.add(password);
    paneli.add(controls, BorderLayout.CENTER);
     

    JOptionPane.showMessageDialog( null,paneli, "login", JOptionPane.QUESTION_MESSAGE);
            System.out.println(interfaz.ingresar(username.getText(), password.getText()));
        return interfaz.ingresar(username.getText(), password.getText());
        }catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }
}
