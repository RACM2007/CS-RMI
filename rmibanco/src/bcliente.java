
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class bcliente extends JFrame implements ActionListener{
    
    JButton agregar,eliminar,modificar;
    JTable tabla;
    JPanel pan;
    
    public bcliente(){
        agregar= new JButton("Agregar Cliente");
        eliminar= new JButton("Elimnar Cliente");
        modificar= new JButton("Actualizar");
        
        pan = new JPanel ();
        pan.add(agregar);
        pan.add(eliminar);
        pan.add(modificar);
        
       String[] columnNames ={"DNI","Nombre", "Apellido Paterno", "Apellido Materno", "Teléfono"};
  Object[][] data = obtenerdatos();

    JTable tabla=new JTable(data,columnNames);    
    tabla.setPreferredScrollableViewportSize(new Dimension(100, 70));
     
    JScrollPane sPane = new JScrollPane(tabla);
    this.add(sPane);
    this.add(pan,BorderLayout.SOUTH);
   this.setSize(new Dimension(500, 400)); 
    this.setVisible(true);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        
        if(agregar==obj){
            
        }
    }
    
    public static void main(String[] args) {
        new bcliente();
    }

    private Object[][] obtenerdatos() {
        String [][] a= new String [50][50];
        try{
                
                Registry registro= LocateRegistry.getRegistry("localhost",1099);
                
                bancointer interfaz = (bancointer) registro.lookup("rmi://localhost:1099/rmibanco");
                
                if(interfaz.bcliente()==null){
                    JOptionPane.showMessageDialog(null, "No Hay Datos");
                }else{
                    a=interfaz.bcliente();
                }
                     
            }catch(Exception ex){
              JOptionPane.showMessageDialog(null,ex);
            }
        
        
        return a;
    }
    
}
