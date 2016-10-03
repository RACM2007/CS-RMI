import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class cliente extends JFrame implements ActionListener{

    public cliente (){
//        convertir = new JButton ("Convertir Cadena");
//        cad = new JLabel ("Escriba su Cadena: ");
//        txt = new JTextField (20);
//        pan = new JPanel ();
//        
//        this.add(convertir,BorderLayout.SOUTH);
//        pan.add(cad);
//        pan.add(txt);
//        
//        convertir.addActionListener(this);
        
        //this.add(pan,BorderLayout.CENTER);
        this.setTitle("Cifrar Cadena");
        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        new cliente();
    }
    
}
