import java.awt.BorderLayout;
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


public class cliente extends JFrame implements ActionListener{
    
      JButton boton;
    JLabel cad;
    JTextField txt;
    JPanel pan;
    
    public cliente (){
           boton = new JButton ("Presióname!");
//        cad = new JLabel ("Escriba su Cadena: ");
//        txt = new JTextField (20);
        pan = new JPanel ();
//        
        this.add(boton,BorderLayout.SOUTH);
//        pan.add(cad);
//        pan.add(txt);
//        
        boton.addActionListener(this);
        
        this.add(pan,BorderLayout.CENTER);
        this.setTitle("Cifrar Cadena");
        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        
        if(boton==obj){
            try{
                
                Registry registro= LocateRegistry.getRegistry("localhost",1099);
                
                bancointer interfaz = (bancointer) registro.lookup("rmi://localhost:1099/rmibanco");
                
                String prop;
                prop=JOptionPane.showInputDialog("Ingrese el codigo del propietario");
                
                if(interfaz.buscar(prop)==null){
                    JOptionPane.showMessageDialog(null, "No encontrado");
                }else{
                    JOptionPane.showMessageDialog(null, interfaz.buscar(prop).getSaldo());
                }
                     
            }catch(Exception ex){
              JOptionPane.showMessageDialog(null,ex);
            }
                
        }
    }
    
    public static void main(String[] args) {
        new cliente();
    }
    
}
