import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class sfondo extends javax.swing.JPanel {

    public sfondo() {
        this.setSize(1600,1200);
        
    }
    
    public void paintComponent (Graphics g){
        Dimension tam= getSize();
        ImageIcon imagenFondo = new ImageIcon (getClass().getResource("/imagenes/fondo.png"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tam.width, tam.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}