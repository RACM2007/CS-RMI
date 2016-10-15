import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class interfazchida extends javax.swing.JFrame {

     public static final String RETIRO = "RETIRO";
    public static final String DEPOSITO = "DEPOSITO";
    public static final String TRANSFERENCIA = "TRANSFERENCIA";
    usuario uactivo=new usuario();

    private cliente clienteActual;

    String direccion;
    int puerto;
    bancointer interfaz;
    public interfazchida() {
        boolean flag=true;
        do{
        try {
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

            JOptionPane.showMessageDialog(null, panel, "Conexión RMI", JOptionPane.QUESTION_MESSAGE);

            direccion = direc.getText();
            puerto = Integer.parseInt(puert.getText());
            System.out.println(direccion + " " + puerto);

            Registry registro = LocateRegistry.getRegistry(direccion, puerto);
            interfaz = (bancointer) registro.lookup("bancoservidor");
        } catch (Exception ex) {
            flag=false;
            System.out.println(ex);
        }
        }while(!flag);
        
        flag=false;
        do{
            flag = ingresar();
            if(!flag){
            int a;
            JOptionPane.showMessageDialog(null, "ERROR EN EL USUARIO Y/O PASSWORD");
            a= JOptionPane.showConfirmDialog(null,"¿DESEA CERRAR EL SISTEMA?","ERROR",JOptionPane.YES_NO_OPTION);
            
            if (a==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
            }
        }while(!flag);
        System.out.println("k");
        sfondo f = new sfondo ();
        
        initComponents();
        transparencia();
        
        
        this.add(f, BorderLayout.CENTER);
        
        
        this.setExtendedState(this.MAXIMIZED_BOTH);
        //this.setLocationRelativeTo(null);
        //this.setResizable(false);
        this.setTitle("BANCO RMI");
        
        labelusu.setText("USUARIO :"+uactivo.login);
               
        administrarrol();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        labelusu = new javax.swing.JLabel();
        boton7 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("DigifaceWide", 1, 93)); // NOI18N
        jLabel1.setText("SISTEMA BANCARIO RMI");

        boton1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        boton1.setText("CLIENTES");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        boton2.setText("CUENTAS");

        boton3.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        boton3.setText("MOVIMIENTOS");

        boton4.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        boton4.setText("REPORTES");

        labelusu.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        labelusu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        labelusu.setText("Usuario");

        boton7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        boton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuser.png"))); // NOI18N
        boton7.setText("CAMBIAR DE USUARIO");
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });

        boton6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        boton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/newuser.png"))); // NOI18N
        boton6.setText("CREAR NUEVO USUARIO");
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });

        boton5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        boton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        boton5.setText("CAMBIAR CONTRASEÑA");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });

        boton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        boton8.setText("SALIR DEL SISTEMA");
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelusu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(214, 214, 214))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton8)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(labelusu)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        boolean i = ingresar();
        while (i == false) {
            int a;
            JOptionPane.showMessageDialog(null, "ERROR EN EL USUARIO Y/O PASSWORD");
            a= JOptionPane.showConfirmDialog(this, "¿DESEA CERRAR EL SISTEMA?","ERROR",JOptionPane.YES_NO_OPTION);
            if (a==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }else{
                i = ingresar();
            }
        }

        labelusu.setText(uactivo.login);

        administrarrol();

    }//GEN-LAST:event_boton7ActionPerformed

    private void administrarrol() {
        switch (uactivo.login.charAt(0)){
            case 'p':
                boton1.setVisible(true);
                boton2.setVisible(true);
                boton3.setVisible(false);
                boton4.setVisible(true);
                boton5.setVisible(true);
                boton6.setVisible(false);
                boton7.setVisible(true);
                break;
            case 'c':
              boton1.setVisible(false);
                boton2.setVisible(false);
                boton3.setVisible(true);
                boton4.setVisible(true);
                boton5.setVisible(true);
                boton6.setVisible(false);
                boton7.setVisible(true);
                break;
            case 'a':
                boton1.setVisible(true);
                boton2.setVisible(true);
                boton3.setVisible(true);
                boton4.setVisible(true);
                boton5.setVisible(true);
                boton6.setVisible(true);
                boton7.setVisible(true);
                break;
            
        }
    }
    
    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        try {
            JPanel paneli = new JPanel(new BorderLayout(5, 5));
            JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
            label.add(new JLabel("Login", SwingConstants.RIGHT));
            label.add(new JLabel("Password", SwingConstants.RIGHT));
            label.add(new JLabel("Confirme Password", SwingConstants.RIGHT));
            paneli.add(label, BorderLayout.WEST);

            JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
            JTextField username = new JTextField();
            controls.add(username);
            JPasswordField password = new JPasswordField();
            controls.add(password);
            JPasswordField cpassword = new JPasswordField();
            controls.add(cpassword);
            paneli.add(controls, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null, paneli, "Nuevo Usuario", JOptionPane.QUESTION_MESSAGE);

            if(!(username.getText().equalsIgnoreCase(""))&&!(password.getText().equalsIgnoreCase(""))
                &&password.getText().equalsIgnoreCase(cpassword.getText())&&(username.getText().charAt(0)=='a' ||
                    username.getText().charAt(0)=='c' || username.getText().charAt(0)=='p')){
                interfaz.agregarusuario(username.getText(),password.getText());
            }else{
                JOptionPane.showMessageDialog(null, "Error en el usuario o las contraseñas");
                JOptionPane.showMessageDialog(null, "Usuario no Agregado");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        
    }//GEN-LAST:event_boton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }

        new interfazchida().setVisible(true);
    }
    
    
    private boolean ingresar() {
        try {
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

            JOptionPane.showMessageDialog(null, paneli, "Inicio de Sesión", JOptionPane.QUESTION_MESSAGE);
            uactivo.setId(interfaz.obteneruserid(username.getText()));
            System.out.println(uactivo.getId());
            uactivo.setLogin(username.getText());
            uactivo.setPass(password.getText());
            //
            return interfaz.ingresar(username.getText(), password.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelusu;
    // End of variables declaration//GEN-END:variables

    private void transparencia() {
        boton1.setOpaque(false);
        boton2.setOpaque(false);
        boton3.setOpaque(false);
        boton4.setOpaque(false);
        boton5.setOpaque(false);
        boton6.setOpaque(false);
        boton7.setOpaque(false);
        boton8.setOpaque(false);
    }
}
