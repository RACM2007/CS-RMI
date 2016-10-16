import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class clientermi extends javax.swing.JFrame implements ActionListener {

    public static final String RETIRO = "RETIRO";
    public static final String DEPOSITO = "DEPOSITO";
    public static final String TRANSFERENCIA = "TRANSFERENCIA";
    usuario uactivo=new usuario();
    DateFormat df = DateFormat.getDateInstance();
    private cliente clienteActual;

    String direccion;
    int puerto;
    bancointer interfaz;

    public clientermi() {
        
        boolean flag=true;
        do{
        try {
            JPanel panel = new JPanel(new BorderLayout(5, 5));

            JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
            label.add(new JLabel("Direcci�n", SwingConstants.RIGHT));
            label.add(new JLabel("Puerto", SwingConstants.RIGHT));
            panel.add(label, BorderLayout.WEST);

            JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
            JTextField direc = new JTextField();
            controls.add(direc);
            JTextField puert = new JTextField();
            controls.add(puert);
            panel.add(controls, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null, panel, "Conexi�n RMI", JOptionPane.QUESTION_MESSAGE);

            direccion = direc.getText();
            puerto = Integer.parseInt(puert.getText());
            System.out.println(direccion + " " + puerto);

            Registry registro = LocateRegistry.getRegistry(direccion, puerto);
            interfaz = (bancointer) registro.lookup("bancoservidor");
        } catch (Exception ex) {
            flag=false;
            System.out.println(ex);
        }
        if(!flag){
            int a;
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXI�N RMI, REVISE SU SERVIDOR");
            a= JOptionPane.showConfirmDialog(null,"�DESEA CERRAR EL SISTEMA?","ERROR",JOptionPane.YES_NO_OPTION);
            
            if (a==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
            }
        }while(!flag);
        
        flag=false;
        do{
            flag = ingresar();
            if(!flag){
            int a;
            JOptionPane.showMessageDialog(null, "ERROR EN EL USUARIO Y/O PASSWORD");
            a= JOptionPane.showConfirmDialog(null,"�DESEA CERRAR EL SISTEMA?","ERROR",JOptionPane.YES_NO_OPTION);
            
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
        
        btsalir.addActionListener(this);
        btaccli.addActionListener(this);
        btacmov.addActionListener(this);
        btaccue.addActionListener(this);
        btagregarcli.addActionListener(this);
        
        this.setExtendedState(this.MAXIMIZED_BOTH);
        //this.setLocationRelativeTo(null);
        //this.setResizable(false);
        this.setTitle("BANCO RMI");
        
        labelusu.setText("Usuario :"+uactivo.login);
        
        actualizartablaclientes();
        actualizartablamov();
        actualizartablacuentas();
        
        botonreportes.setEnabled(false);
        
        administrarrol();
        jPanelClientes.setVisible(false);
        jPanelMovimientos.setVisible(false);
        jPanelCuentas.setVisible(false);
        jPanelreport.setVisible(false);
        jDesktopPane1.setOpaque(false);
        
    }
    
     private void transparencia() {
             
         jPanelpresentacion.setOpaque(false);
        jPanelClientes.setOpaque(false);
        jPanelMovimientos.setOpaque(false);
        jPanelCuentas.setOpaque(false);
        jPanel1.setOpaque(false);
        btacmov.setOpaque(false);
        btaccli.setOpaque(false);
        btaccue.setOpaque(false);
        btsalir.setOpaque(false);
        jButton7.setOpaque(false);
        jPanelreport.setOpaque(false);
        boton1.setOpaque(false);
        boton2.setOpaque(false);
        boton3.setOpaque(false);
        boton4.setOpaque(false);
        btcambiarcontra.setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btsalir = new javax.swing.JButton();
        labelusu = new javax.swing.JLabel();
        btcerrarsesion = new javax.swing.JButton();
        btnewuser = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanelClientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btaccli = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablacli = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel8 = new javax.swing.JLabel();
        txtcc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtct = new javax.swing.JTextField();
        btagregarcli = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btmodcli = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtfildni = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtfilnom = new javax.swing.JTextField();
        jPanelCuentas = new javax.swing.JPanel();
        btaccue = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtcuedni = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        comboTipoCuenta = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacue = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel14 = new javax.swing.JLabel();
        jPanelMovimientos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btacmov = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablamov = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoMov = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMontoMovimiento = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        txtCuentaOrigen = new javax.swing.JTextField();
        txtCuentaDestino = new javax.swing.JTextField();
        txtDniOrigen = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btacmov1 = new javax.swing.JButton();
        txtfini = new com.toedter.calendar.JDateChooser();
        txtfter = new com.toedter.calendar.JDateChooser();
        jPanelreport = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtcuerepor = new javax.swing.JTextField();
        botonreportes = new javax.swing.JButton();
        jPanelpresentacion = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        labelusu1 = new javax.swing.JLabel();
        btcambiarcontra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setText("SISTEMA BANCARIO RMI");

        btsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btsalir.setText("SALIR DEL SISTEMA");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });

        labelusu.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        labelusu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        labelusu.setText("Usuario");

        btcerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuser.png"))); // NOI18N
        btcerrarsesion.setText("CAMBIAR DE USUARIO");
        btcerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcerrarsesionActionPerformed(evt);
            }
        });

        btnewuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/newuser.png"))); // NOI18N
        btnewuser.setText("CREAR NUEVO USUARIO");
        btnewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnewuserActionPerformed(evt);
            }
        });

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Clientes:");

        btaccli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reload.png"))); // NOI18N
        btaccli.setText("ACTUALIZAR TABLA");

        tablacli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "C�digo", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno", "Tel�fono"
            }
        ));
        tablacli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablacliMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablacli);

        jLabel8.setText("CODIGO:");

        txtcc.setEditable(false);

        jLabel2.setText("DNI:");

        txtcd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcdKeyTyped(evt);
            }
        });

        jLabel7.setText("TEL�FONO:");

        txtcam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcamKeyTyped(evt);
            }
        });

        jLabel4.setText("NOMBRE:");

        txtcn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcnKeyTyped(evt);
            }
        });

        jLabel5.setText("APELLIDO PATERNO:");

        txtcap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcapKeyTyped(evt);
            }
        });

        jLabel6.setText("APELLIDO MATERNO:");

        txtct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtctKeyTyped(evt);
            }
        });

        btagregarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new.png"))); // NOI18N
        btagregarcli.setText("NUEVO");
        btagregarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btagregarcliActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        jButton4.setText("GUARDAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jButton8.setText("ELIMINAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btmodcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        btmodcli.setText("MODIFICAR");
        btmodcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodcliActionPerformed(evt);
            }
        });

        jLabel19.setText("FILTRAR POR DNI:");

        txtfildni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfildniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfildniKeyTyped(evt);
            }
        });

        jLabel20.setText("FILTRAR POR NOMBRE COMPLETO:");

        txtfilnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfilnomKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfilnomKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtfildni, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfilnom))
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelClientesLayout.createSequentialGroup()
                                .addComponent(txtcc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcam, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelClientesLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel2)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel7))
                            .addGroup(jPanelClientesLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel5)
                                .addGap(87, 87, 87)
                                .addComponent(jLabel6))
                            .addGroup(jPanelClientesLayout.createSequentialGroup()
                                .addComponent(txtcn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcap, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtct))))
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btaccli, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btagregarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btmodcli)
                        .addGap(11, 11, 11)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btaccli, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtfildni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtfilnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btagregarcli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8)
                    .addComponent(btmodcli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btaccue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reload.png"))); // NOI18N
        btaccue.setText("ACTUALIZAR TABLA");
        btaccue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaccueActionPerformed(evt);
            }
        });

        jLabel15.setText("N�MERO DE CUENTA:");

        jTextField7.setEditable(false);

        jLabel17.setText("C�DIGO PROPIETARIO:");

        txtcuedni.setEditable(false);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new.png"))); // NOI18N
        jButton11.setText("AGREGAR CUENTA");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jButton12.setText("ELIMINAR CUENTA");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel16.setText("TIPO:");

        comboTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ahorros", "corriente" }));

        tablacue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "saldo", "tipo", "fecha de apertura", "Codigo Cliente Propietario"
            }
        ));
        tablacue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablacueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablacue);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboTipoCuenta, 0, 163, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtcuedni, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton12)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcuedni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton11))
                .addGap(2, 2, 2)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Cuenta:");

        javax.swing.GroupLayout jPanelCuentasLayout = new javax.swing.GroupLayout(jPanelCuentas);
        jPanelCuentas.setLayout(jPanelCuentasLayout);
        jPanelCuentasLayout.setHorizontalGroup(
            jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCuentasLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(btaccue)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCuentasLayout.setVerticalGroup(
            jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuentasLayout.createSequentialGroup()
                .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(btaccue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Movimientos:");

        btacmov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reload.png"))); // NOI18N
        btacmov.setText("ACTUALIZAR TABLA");

        tablamov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "monto", "usuario", "tipo", "Cuenta origen", "Origen Externo", "Cuenta Destino", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tablamov);

        jLabel9.setText("Tipo:");

        jComboBoxTipoMov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEPOSITO", "RETIRO", "TRANSFERENCIA" }));
        jComboBoxTipoMov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoMovItemStateChanged(evt);
            }
        });

        jLabel10.setText("Cuenta Origen:");

        jLabel11.setText("Cuenta Destino:");

        jLabel12.setText("Monto:");

        txtMontoMovimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoMovimientoKeyTyped(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bank.png"))); // NOI18N
        jButton7.setText("REALIZAR MOVIMIENTO BANCARIO");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        txtCuentaOrigen.setEnabled(false);
        txtCuentaOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaOrigenKeyTyped(evt);
            }
        });

        txtCuentaDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaDestinoKeyTyped(evt);
            }
        });

        txtDniOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniOrigenKeyTyped(evt);
            }
        });

        jLabel18.setText("Dni Origen:");

        jLabel21.setText("FECHA DE INICIO:");

        jLabel22.setText("FECHA DE TERMINO:");

        btacmov1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filter.png"))); // NOI18N
        btacmov1.setText("FILTRAR");
        btacmov1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btacmov1ActionPerformed(evt);
            }
        });

        txtfini.setDateFormatString("yyyy/MM/dd");

        txtfter.setDateFormatString("yyyy/MM/dd");

        javax.swing.GroupLayout jPanelMovimientosLayout = new javax.swing.GroupLayout(jPanelMovimientos);
        jPanelMovimientos.setLayout(jPanelMovimientosLayout);
        jPanelMovimientosLayout.setHorizontalGroup(
            jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(74, 74, 74)
                            .addComponent(jComboBoxTipoMov, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                            .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12))
                            .addGap(18, 18, 18)
                            .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMontoMovimiento)
                                .addComponent(txtCuentaDestino)))
                        .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                            .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel18))
                            .addGap(24, 24, 24)
                            .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDniOrigen)
                                .addComponent(txtCuentaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton7)))
                .addContainerGap(240, Short.MAX_VALUE))
            .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(txtfini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(txtfter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(btacmov1)
                        .addGap(24, 24, 24))
                    .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btacmov))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelMovimientosLayout.setVerticalGroup(
            jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btacmov, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                        .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(btacmov1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21)
                            .addComponent(txtfini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBoxTipoMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtDniOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCuentaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtCuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtfter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setText("GENERACI�N DE REPORTES");

        jLabel24.setText("N�MERO DE CUENTA:");

        txtcuerepor.setEditable(false);
        txtcuerepor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcuereporKeyTyped(evt);
            }
        });

        botonreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/report.png"))); // NOI18N
        botonreportes.setText("GENERAR REPORTE DE ESTADO DE CUENTA");
        botonreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonreportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelreportLayout = new javax.swing.GroupLayout(jPanelreport);
        jPanelreport.setLayout(jPanelreportLayout);
        jPanelreportLayout.setHorizontalGroup(
            jPanelreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelreportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanelreportLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcuerepor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(botonreportes)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanelreportLayout.setVerticalGroup(
            jPanelreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelreportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(jPanelreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtcuerepor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jLabel25.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jLabel25.setText("SISTEMA CLIENTE SERVIDOR");

        jLabel26.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel26.setText("Correa Mantilla, Roberto");

        jLabel27.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel27.setText("2016 - II");

        jLabel28.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel28.setText("Angeles Chavez, Hugo");

        javax.swing.GroupLayout jPanelpresentacionLayout = new javax.swing.GroupLayout(jPanelpresentacion);
        jPanelpresentacion.setLayout(jPanelpresentacionLayout);
        jPanelpresentacionLayout.setHorizontalGroup(
            jPanelpresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelpresentacionLayout.createSequentialGroup()
                .addGroup(jPanelpresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelpresentacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25))
                    .addGroup(jPanelpresentacionLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel27))
                    .addGroup(jPanelpresentacionLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanelpresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel26))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelpresentacionLayout.setVerticalGroup(
            jPanelpresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelpresentacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addGap(49, 49, 49)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanelClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelCuentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelMovimientos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelreport, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelpresentacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanelreport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jPanelCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(272, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addComponent(jPanelreport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(264, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        boton1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        boton1.setText("CLIENTES");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        boton2.setText("CUENTAS");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        boton3.setText("MOVIMIENTOS");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        boton4.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        boton4.setText("REPORTES");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        labelusu1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        labelusu1.setText("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES:");

        btcambiarcontra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        btcambiarcontra.setText("CAMBIAR CONTRASE�A");
        btcambiarcontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcambiarcontraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelusu)
                        .addGap(18, 18, 18)
                        .addComponent(btcerrarsesion)
                        .addGap(18, 18, 18)
                        .addComponent(btnewuser)
                        .addGap(18, 18, 18)
                        .addComponent(btcambiarcontra))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(314, 314, 314)
                        .addComponent(btsalir)))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelusu1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelusu)
                    .addComponent(btcerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnewuser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btcambiarcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelusu1)
                        .addGap(60, 60, 60)
                        .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btagregarcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btagregarcliActionPerformed
        clienteActual = new cliente();
        fillClienteForm(clienteActual);
    }//GEN-LAST:event_btagregarcliActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (!esFormClienteValido()) {
            return;
        }

        clienteActual = readClienteForm();
        try {
            interfaz.agregarcliente(clienteActual);
            showInfo("Se guardo el cliente con exitosamente");
        } catch (RemoteException ex) {
            Logger.getLogger(clientermi.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizartablaclientes();
        clienteActual = new cliente();
        fillClienteForm(clienteActual);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablacliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablacliMouseClicked
        int row = tablacli.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            int id = (Integer) tablacli.getModel().getValueAt(row, 0);
            String dni = (String) tablacli.getModel().getValueAt(row, 1);
            String nombre = (String) tablacli.getModel().getValueAt(row, 2);
            String apellidoP = (String) tablacli.getModel().getValueAt(row, 3);
            String apellidoM = (String) tablacli.getModel().getValueAt(row, 4);
            String telefono = (String) tablacli.getModel().getValueAt(row, 5);
            clienteActual = new cliente(id, dni, nombre, apellidoP, apellidoM, telefono);
            fillClienteForm(clienteActual);
            filtrartablacue(id);
        }
        botonreportes.setEnabled(false);
        
    }//GEN-LAST:event_tablacliMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        cuenta cuenta = readCuentaForm();
        try {
            interfaz.agregarCuenta(cuenta);
            showInfo("Cuenta registrada exitosamente");
        } catch (RemoteException ex) {
            showError("Error al agregar cuenta.");
            Logger.getLogger(clientermi.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizartablacuentas();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBoxTipoMovItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoMovItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String item = (String) evt.getItem();

            clearMovimientoForm();

            switch (item) {
                case RETIRO:
                    txtDniOrigen.setEnabled(false);
                    txtCuentaOrigen.setEnabled(true);
                    txtCuentaDestino.setEnabled(false);
                    break;
                case TRANSFERENCIA:
                    txtDniOrigen.setEnabled(false);
                    txtCuentaOrigen.setEnabled(true);
                    txtCuentaDestino.setEnabled(true);
                    break;
                case DEPOSITO:
                    txtDniOrigen.setEnabled(true);
                    txtCuentaOrigen.setEnabled(false);
                    txtCuentaDestino.setEnabled(true);
                    break;
            }
        }
    }//GEN-LAST:event_jComboBoxTipoMovItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (esMovimientoFormValido()) {
            movimientos mov = new movimientos();
            mov.tipo = jComboBoxTipoMov.getSelectedItem().toString();

            switch (mov.tipo) {
                case DEPOSITO:
                    mov.origene = txtDniOrigen.getText();
                    mov.destinoc = Integer.parseInt(txtCuentaDestino.getText());
                    break;
                case RETIRO:
                    mov.origenc = Integer.parseInt(txtCuentaOrigen.getText());
                    break;
                case TRANSFERENCIA:
                    mov.origenc = Integer.parseInt(txtCuentaOrigen.getText());
                    mov.destinoc = Integer.parseInt(txtCuentaDestino.getText());
                    break;
            }

            mov.monto = Double.valueOf(txtMontoMovimiento.getText());
            mov.usuario=uactivo.id;
            try {
                RespuestaServidor resp = interfaz.agregarMovimiento(mov);
                if (resp.esExito()) {
                    showInfo(resp.getMsg());
                    clearMovimientoForm();
                    actualizartablacuentas();
                    actualizartablamov();
                } else {
                    showError(resp.getMsg());
                }
            } catch (RemoteException ex) {
                showError("Error al conectar con el servidor.");
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btmodcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodcliActionPerformed
        int cod=Integer.parseInt(txtcc.getText());
        String dni=txtcd.getText();
        String nom=txtcn.getText();
        String ap=txtcap.getText();
        String am=txtct.getText();
        String tel=txtct.getText();
        try{
        interfaz.modicli(cod,dni,nom,ap,am,tel);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        actualizartablaclientes();
    }//GEN-LAST:event_btmodcliActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try{
        interfaz.elicli(Integer.parseInt(txtcc.getText()));
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        actualizartablaclientes();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try{
        interfaz.elicue(Integer.parseInt(jTextField7.getText()));
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        actualizartablacuentas();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tablacueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablacueMouseClicked
        jTextField7.setText(String.valueOf(tablacue.getValueAt(tablacue.getSelectedRow(), tablacue.getSelectedColumn())));
        int row = tablacli.rowAtPoint(evt.getPoint());
        txtcuerepor.setText(""+(int)tablacue.getValueAt(row, 0));
        filtrartablamov((int)tablacue.getValueAt(row, 0));
        botonreportes.setEnabled(true);
        
    }//GEN-LAST:event_tablacueMouseClicked

    private void txtcdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcdKeyTyped
         char c=evt.getKeyChar(); 
         
          if(!Character.isDigit(c)) { 
              
              evt.consume(); 
          }
    }//GEN-LAST:event_txtcdKeyTyped

    private void txtcamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcamKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isDigit(c)) { 
              
              evt.consume(); 
          }
    }//GEN-LAST:event_txtcamKeyTyped

    private void txtDniOrigenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniOrigenKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isDigit(c)) { 
               
              evt.consume(); 
          }
    }//GEN-LAST:event_txtDniOrigenKeyTyped

    private void txtCuentaOrigenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaOrigenKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isDigit(c)) { 
              
              evt.consume(); 
          }
    }//GEN-LAST:event_txtCuentaOrigenKeyTyped

    private void txtCuentaDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaDestinoKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isDigit(c)) { 
               
              evt.consume(); 
          }
    }//GEN-LAST:event_txtCuentaDestinoKeyTyped

    private void txtMontoMovimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoMovimientoKeyTyped
        char c=evt.getKeyChar();
          if(Character.isDigit(c) || c=='.' || c==',') { 
              
          }else{
              evt.consume(); 
          }
    }//GEN-LAST:event_txtMontoMovimientoKeyTyped

    private void txtcnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isLetter(c)) { 
               
              evt.consume(); 
          }
    }//GEN-LAST:event_txtcnKeyTyped

    private void txtcapKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcapKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isLetter(c)) { 
             
              evt.consume(); 
          }
    }//GEN-LAST:event_txtcapKeyTyped

    private void txtctKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtctKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isLetter(c)) { 
               evt.consume(); 
          }
    }//GEN-LAST:event_txtctKeyTyped

    private void txtfildniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfildniKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isDigit(c)) { 
              evt.consume(); 
          }
    }//GEN-LAST:event_txtfildniKeyTyped

    private void txtfildniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfildniKeyReleased
        filtrartabla(txtfildni.getText());
    }//GEN-LAST:event_txtfildniKeyReleased

    private void txtfilnomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfilnomKeyReleased
        filtrartablacli(txtfilnom.getText());
    }//GEN-LAST:event_txtfilnomKeyReleased

    private void txtfilnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfilnomKeyTyped
        char c=evt.getKeyChar();
          if(Character.isLetter(c) || c==' ') { 
              
          }else{
              evt.consume(); 
          }
    }//GEN-LAST:event_txtfilnomKeyTyped

    private void btacmov1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btacmov1ActionPerformed
        Date fi, ft;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try{
        fi=txtfini.getDate();
        ft=txtfter.getDate();
        
        actualizartablamov();
        DefaultTableModel modelo = (DefaultTableModel) tablamov.getModel();
        try {

            ArrayList<movimientos> datosmov;
            Object[] datos = new Object[8];
            datosmov = interfaz.datosmov();
        //System.out.println(modelo.getRowCount());

            for (int k = 0; k < modelo.getRowCount(); k++) {
                modelo.removeRow(0);
                k--;
            }

            for (int i = 0; i < datosmov.size(); i++) {
                if(datosmov.get(i).fecha.after(fi) && datosmov.get(i).fecha.before(ft)){
                datos[0] = datosmov.get(i).id;
                datos[1] = datosmov.get(i).monto;
                datos[2] = datosmov.get(i).usuario;
                datos[3] = datosmov.get(i).tipo;
                datos[4] = datosmov.get(i).origenc;
                datos[5] = datosmov.get(i).origene;
                datos[6] = datosmov.get(i).destinoc;
                datos[7] = datosmov.get(i).fecha;
                modelo.addRow(datos);
                }
            }

            tablamov.setModel(modelo);
            }catch(Exception e){
            e.printStackTrace();
        }
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        botonreportes.setEnabled(false);
    }//GEN-LAST:event_btacmov1ActionPerformed

    private void btcerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcerrarsesionActionPerformed
           boolean i = ingresar();
        while (i == false) {
            int a;
            JOptionPane.showMessageDialog(null, "ERROR EN EL USUARIO Y/O PASSWORD");
            a= JOptionPane.showConfirmDialog(this, "�DESEA CERRAR EL SISTEMA?","ERROR",JOptionPane.YES_NO_OPTION);
            if (a==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }else{
                i = ingresar();
            }
        }
        
        labelusu.setText(uactivo.login);
        
        administrarrol();
            
    }//GEN-LAST:event_btcerrarsesionActionPerformed

    private void btnewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnewuserActionPerformed
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
                JOptionPane.showMessageDialog(null, "Error en el usuario o las contrase�as");
                JOptionPane.showMessageDialog(null, "Usuario no Agregado");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnewuserActionPerformed

    private void txtcuereporKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcuereporKeyTyped
        char c=evt.getKeyChar();
          if(!Character.isDigit(c)) {
              evt.consume(); 
          }
    }//GEN-LAST:event_txtcuereporKeyTyped

    private void botonreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonreportesActionPerformed
        
        if (!esFormReporteValido()) return;
        
        Integer cuenta = Integer.valueOf(txtcuerepor.getText());
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("cuenta", cuenta);
        
        JasperPrint print = null;
        tablacue.getValueAt(tablacue.getSelectedRow(), 4);
        try {
            print = interfaz.obtenertReporte("movimientos", parametros);
            JFrame viewer = new JFrame("Estado de cuenta.");
            viewer.setSize(new Dimension(900, 700));
            viewer.setLocationRelativeTo(null);
            
            JasperViewer jrViewer = new JasperViewer(print, true);
            viewer.getContentPane().add(jrViewer.getContentPane());
            viewer.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(clientermi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonreportesActionPerformed

    private void btaccueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaccueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btaccueActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btsalirActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        jPanelClientes.setVisible(true);
        jPanelCuentas.setVisible(false);
        jPanelMovimientos.setVisible(false);
        jPanelreport.setVisible(false);
        jPanelpresentacion.setVisible(false);
    }//GEN-LAST:event_boton1ActionPerformed

    private void btcambiarcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcambiarcontraActionPerformed
        boolean a=true;
        try {
            JPanel paneli = new JPanel(new BorderLayout(5, 5));
            JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
            label.add(new JLabel("Contrase�a Actual", SwingConstants.RIGHT));
            label.add(new JLabel("Nueva Contrase�a", SwingConstants.RIGHT));
            label.add(new JLabel("Confirme Contrase�a", SwingConstants.RIGHT));
            paneli.add(label, BorderLayout.WEST);

            JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
            JPasswordField apassword = new JPasswordField();
            controls.add(apassword);
            JPasswordField password = new JPasswordField();
            controls.add(password);
            JPasswordField cpassword = new JPasswordField();
            controls.add(cpassword);
            paneli.add(controls, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null, paneli, "Cambiar de Contrase�a", JOptionPane.QUESTION_MESSAGE);
            
            if(!(apassword.getText().equalsIgnoreCase(""))&&!(password.getText().equalsIgnoreCase(""))
                    &&password.getText().equalsIgnoreCase(cpassword.getText())){
                interfaz.cambiarcontra(uactivo.getId(),apassword.getText(),password.getText());
            }else{
                JOptionPane.showMessageDialog(null, "Error en el usuario o las contrase�as");
                JOptionPane.showMessageDialog(null, "Usuario no Agregado");
            }
        } catch (Exception ex) {
            a=false;
            ex.printStackTrace();
            System.out.println(ex);
            
        }
        if(a){
            JOptionPane.showMessageDialog(null,"Cambio de contrase�a exitoso");
        }
    }//GEN-LAST:event_btcambiarcontraActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        jPanelClientes.setVisible(false);
        jPanelCuentas.setVisible(true);
        jPanelMovimientos.setVisible(false);
        jPanelreport.setVisible(false);
        jPanelpresentacion.setVisible(false);
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        jPanelClientes.setVisible(false);
        jPanelCuentas.setVisible(false);
        jPanelMovimientos.setVisible(true);
        jPanelreport.setVisible(false);
        jPanelpresentacion.setVisible(false);
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        jPanelClientes.setVisible(false);
        jPanelCuentas.setVisible(false);
        jPanelMovimientos.setVisible(false);
        jPanelreport.setVisible(true);
        jPanelpresentacion.setVisible(false);
    }//GEN-LAST:event_boton4ActionPerformed
    
    private void clearMovimientoForm() {
        txtDniOrigen.setText("");
        txtCuentaOrigen.setText("");
        txtCuentaDestino.setText("");
        txtMontoMovimiento.setText("");
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }

        new clientermi().setVisible(true);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton botonreportes;
    private javax.swing.JButton btaccli;
    private javax.swing.JButton btaccue;
    private javax.swing.JButton btacmov;
    private javax.swing.JButton btacmov1;
    private javax.swing.JButton btagregarcli;
    private javax.swing.JButton btcambiarcontra;
    private javax.swing.JButton btcerrarsesion;
    private javax.swing.JButton btmodcli;
    private javax.swing.JButton btnewuser;
    private javax.swing.JButton btsalir;
    private javax.swing.JComboBox comboTipoCuenta;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBoxTipoMov;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelCuentas;
    private javax.swing.JPanel jPanelMovimientos;
    private javax.swing.JPanel jPanelpresentacion;
    private javax.swing.JPanel jPanelreport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel labelusu;
    private javax.swing.JLabel labelusu1;
    private javax.swing.JTable tablacli;
    private javax.swing.JTable tablacue;
    private javax.swing.JTable tablamov;
    private javax.swing.JTextField txtCuentaDestino;
    private javax.swing.JTextField txtCuentaOrigen;
    private javax.swing.JTextField txtDniOrigen;
    private javax.swing.JTextField txtMontoMovimiento;
    private javax.swing.JTextField txtcam;
    private javax.swing.JTextField txtcap;
    private javax.swing.JTextField txtcc;
    private javax.swing.JTextField txtcd;
    private javax.swing.JTextField txtcn;
    private javax.swing.JTextField txtct;
    private javax.swing.JTextField txtcuedni;
    private javax.swing.JTextField txtcuerepor;
    private javax.swing.JTextField txtfildni;
    private javax.swing.JTextField txtfilnom;
    private com.toedter.calendar.JDateChooser txtfini;
    private com.toedter.calendar.JDateChooser txtfter;
    // End of variables declaration//GEN-END:variables

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

            JOptionPane.showMessageDialog(null, paneli, "Inicio de Sesi�n", JOptionPane.QUESTION_MESSAGE);
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

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (btaccli == obj) {
            txtcuerepor.setText("");
            botonreportes.setEnabled(false);
            actualizartablaclientes();
        }
        if (btsalir == obj) {
            System.exit(0);
        }

        if (btacmov == obj) {
            
            txtcuerepor.setText("");
            botonreportes.setEnabled(false);
            actualizartablamov();
        }

        if (btaccue == obj) {
            txtcuerepor.setText("");
            botonreportes.setEnabled(false);
            actualizartablacuentas();
        }

    }

    private void actualizartablaclientes() {
        DefaultTableModel modelo = (DefaultTableModel) tablacli.getModel();
        try {
            ArrayList<cliente> datoscli;
            Object[] datos = new Object[6];
            datoscli = interfaz.datosclientes();
            System.out.println(modelo.getRowCount());

            for (int k = 0; k < modelo.getRowCount(); k++) {
                modelo.removeRow(0);
                k--;
            }

            for (int i = 0; i < datoscli.size(); i++) {
                datos[0] = datoscli.get(i).id;
                datos[1] = datoscli.get(i).dni;
                datos[2] = datoscli.get(i).nombre;
                datos[3] = datoscli.get(i).apellidop;
                datos[4] = datoscli.get(i).apellidom;
                datos[5] = datoscli.get(i).telefono;
                modelo.addRow(datos);
            }

            tablacli.setModel(modelo);
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    private void actualizartablamov() {
        DefaultTableModel modelo = (DefaultTableModel) tablamov.getModel();
        try {

            ArrayList<movimientos> datosmov;
            Object[] datos = new Object[8];
            datosmov = interfaz.datosmov();
        //System.out.println(modelo.getRowCount());

            for (int k = 0; k < modelo.getRowCount(); k++) {
                modelo.removeRow(0);
                k--;
            }

            for (int i = 0; i < datosmov.size(); i++) {
                datos[0] = datosmov.get(i).id;
                datos[1] = datosmov.get(i).monto;
                datos[2] = datosmov.get(i).usuario;
                datos[3] = datosmov.get(i).tipo;
                datos[4] = datosmov.get(i).origenc;
                datos[5] = datosmov.get(i).origene;
                datos[6] = datosmov.get(i).destinoc;
                datos[7] = datosmov.get(i).fecha;
                modelo.addRow(datos);
            }

            tablamov.setModel(modelo);
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void actualizartablacuentas() {
        DefaultTableModel modelo = (DefaultTableModel) tablacue.getModel();
        try {

            ArrayList<cuenta> datoscue;
            Object[] datos = new Object[5];
            datoscue = interfaz.datoscue();
        //System.out.println(modelo.getRowCount());

            for (int k = 0; k < modelo.getRowCount(); k++) {
                modelo.removeRow(0);
                k--;
            }

            for (int i = 0; i < datoscue.size(); i++) {
                datos[0] = datoscue.get(i).id;
                datos[1] = datoscue.get(i).saldo;
                datos[2] = datoscue.get(i).tipo;
                datos[3] = datoscue.get(i).fechaa;
                datos[4] = datoscue.get(i).propietario;
                modelo.addRow(datos);
            }

            tablacue.setModel(modelo);
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void agregarcliente() {
        DefaultTableModel modelo = (DefaultTableModel) tablacli.getModel();
        try {
            cliente c = new cliente(Integer.parseInt(txtcc.getText()), txtcd.getText(), txtcn.getText(), txtcap.getText(), txtcam.getText(), txtct.getText());
            interfaz.agregarcliente(c);
            Object[] datos = new Object[6];
            datos[0] = Integer.parseInt(txtcc.getText());
            datos[1] = txtcd.getText();
            datos[2] = txtcn.getText();
            datos[3] = txtcap.getText();
            datos[4] = txtcam.getText();
            datos[5] = txtct.getText();

            modelo.addRow(datos);
            tablacli.setModel(modelo);

        } catch (Exception ex) {

        }
    }

    private void fillClienteForm(cliente clienteActual) {
        txtcc.setText("");
        if (clienteActual.getId() > 0) {
            txtcc.setText(String.valueOf(clienteActual.getId()));
            txtcuedni.setText(String.valueOf(clienteActual.getId()));
        }

        txtcd.setText(clienteActual.getDni());
        txtcn.setText(clienteActual.getNombre());
        txtcam.setText(clienteActual.getApellidom());
        txtcap.setText(clienteActual.getApellidop());
        txtct.setText(clienteActual.getTelefono());
    }

    private cliente readClienteForm() {
        cliente cli = new cliente();

        try {
            if (!txtcc.getText().equals("")) {
                cli.setId(Integer.parseInt(txtcc.getText()));
            }
        } catch (NumberFormatException e) {
        }

        cli.setDni(txtcd.getText());
        cli.setNombre(txtcn.getText());
        cli.setApellidop(txtcap.getText());
        cli.setApellidom(txtcam.getText());
        cli.setTelefono(txtct.getText());

        return cli;
    }

    private Boolean esFormClienteValido() {
        if (txtcd.getText().equals("")) {
            showError("Debe ingresar el DNI");
            return false;
        }

        if (txtcn.getText().equals("")) {
            showError("Debe ingresar el Nombre");
            return false;
        }

        if (txtcap.getText().equals("")) {
            showError("Debe ingresar el Apellido Paterno");
            return false;
        }

        if (txtcam.getText().equals("")) {
            showError("Debe ingresar el Apellido Materno");
            return false;
        }

        return true;
    }

    private cuenta readCuentaForm() {
        cuenta cuenta = new cuenta();
        cuenta.setPropietario(Integer.parseInt(txtcuedni.getText()));
        cuenta.setTipo(comboTipoCuenta.getModel().getSelectedItem().toString());

        return cuenta;
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfo(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean esMovimientoFormValido() {
        if (jComboBoxTipoMov.getSelectedItem().toString().equals(DEPOSITO)) {

            if (Validator.isEmpty(txtDniOrigen)) {
                showError("Debe ingresar el dni del depositante.");
                return false;
            }

            if (!Validator.esEnteroPositivo(txtCuentaDestino)) {
                showError("La cuenta de destino ingresada no es correcta.");
                return false;
            }

            if (!Validator.esDoubleEnRango(txtMontoMovimiento, 0.01d, Double.MAX_VALUE)) {
                showError("Debe ingresar un monto correcto.");
                return false;
            }
        }

        if (jComboBoxTipoMov.getSelectedItem().toString().equals(RETIRO)) {

            if (Validator.isEmpty(txtCuentaOrigen)) {
                showError("Debe ingresar el dni del depositante.");
                return false;
            }

            if (!Validator.esDoubleEnRango(txtMontoMovimiento, 0.01d, Double.MAX_VALUE)) {
                showError("Debe ingresar un monto correcto.");
                return false;
            }
        }

        if (jComboBoxTipoMov.getSelectedItem().toString().equals(TRANSFERENCIA)) {

            if (Validator.isEmpty(txtCuentaOrigen)) {
                showError("Debe ingresar el dni del depositante.");
                return false;
            }

            if (!Validator.esEnteroPositivo(txtCuentaDestino)) {
                showError("La cuenta de destino ingresada no es correcta.");
                return false;
            }

            if (!Validator.esDoubleEnRango(txtMontoMovimiento, 0.01d, Double.MAX_VALUE)) {
                showError("Debe ingresar un monto correcto.");
                return false;
            }
        }

        return true;
    }

    private void filtrartablacue(int id) {
        actualizartablacuentas();
        DefaultTableModel modelo = (DefaultTableModel) tablacue.getModel();
        try {

            ArrayList<cuenta> datoscue;
            Object[] datos = new Object[5];
            datoscue = interfaz.datoscue();
        //System.out.println(modelo.getRowCount());

            for (int k = 0; k < modelo.getRowCount(); k++) {
                modelo.removeRow(0);
                k--;
            }

            for (int i = 0; i < datoscue.size(); i++) {
                if(id==datoscue.get(i).propietario){
                datos[0] = datoscue.get(i).id;
                datos[1] = datoscue.get(i).saldo;
                datos[2] = datoscue.get(i).tipo;
                datos[3] = datoscue.get(i).fechaa;
                datos[4] = datoscue.get(i).propietario;
                modelo.addRow(datos);
                }
            }

            tablacue.setModel(modelo);
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void filtrartablamov(int valor) {
        actualizartablamov();
        DefaultTableModel modelo = (DefaultTableModel) tablamov.getModel();
        try {

            ArrayList<movimientos> datosmov;
            Object[] datos = new Object[8];
            datosmov = interfaz.datosmov();
        //System.out.println(modelo.getRowCount());

            for (int k = 0; k < modelo.getRowCount(); k++) {
                modelo.removeRow(0);
                k--;
            }

            for (int i = 0; i < datosmov.size(); i++) {
                if(datosmov.get(i).origenc==valor || datosmov.get(i).destinoc==valor){
                datos[0] = datosmov.get(i).id;
                datos[1] = datosmov.get(i).monto;
                datos[2] = datosmov.get(i).usuario;
                datos[3] = datosmov.get(i).tipo;
                datos[4] = datosmov.get(i).origenc;
                datos[5] = datosmov.get(i).origene;
                datos[6] = datosmov.get(i).destinoc;
                datos[7] = datosmov.get(i).fecha;
                modelo.addRow(datos);
                }
            }

            tablamov.setModel(modelo);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void filtrartabla(String text) {
        DefaultTableModel modelo = (DefaultTableModel) tablacli.getModel();
        try {
            ArrayList<cliente> datoscli;
            Object[] datos = new Object[6];
            datoscli = interfaz.datosclientesfil(text);
            System.out.println(modelo.getRowCount());

            for (int k = 0; k < modelo.getRowCount(); k++) {
                modelo.removeRow(0);
                k--;
            }

            for (int i = 0; i < datoscli.size(); i++) {
                datos[0] = datoscli.get(i).id;
                datos[1] = datoscli.get(i).dni;
                datos[2] = datoscli.get(i).nombre;
                datos[3] = datoscli.get(i).apellidop;
                datos[4] = datoscli.get(i).apellidom;
                datos[5] = datoscli.get(i).telefono;
                modelo.addRow(datos);
            }

            tablacli.setModel(modelo);
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void filtrartablacli(String text) {
        DefaultTableModel modelo = (DefaultTableModel) tablacli.getModel();
        try {
            ArrayList<cliente> datoscli;
            Object[] datos = new Object[6];
            datoscli = interfaz.datosclientesfilnom(text);
            System.out.println(modelo.getRowCount());

            for (int k = 0; k < modelo.getRowCount(); k++) {
                modelo.removeRow(0);
                k--;
            }

            for (int i = 0; i < datoscli.size(); i++) {
                datos[0] = datoscli.get(i).id;
                datos[1] = datoscli.get(i).dni;
                datos[2] = datoscli.get(i).nombre;
                datos[3] = datoscli.get(i).apellidop;
                datos[4] = datoscli.get(i).apellidom;
                datos[5] = datoscli.get(i).telefono;
                modelo.addRow(datos);
            }

            tablacli.setModel(modelo);
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void administrarrol() {
        switch (uactivo.login.charAt(0)){
            case 'p':
                jButton7.setVisible(true);
                btagregarcli.setVisible(true);
                btaccli.setVisible(true);
                btmodcli.setVisible(true);
                jButton4.setVisible(true);
                jButton8.setVisible(true);
                jButton11.setVisible(true);
                jButton12.setVisible(true);
                btnewuser.setVisible(false);
                boton1.setVisible(true);
                boton2.setVisible(true);
                boton3.setVisible(false);
                boton4.setVisible(true);
                break;
            case 'c':
                jButton7.setVisible(true);
                btagregarcli.setVisible(false);
                btaccli.setVisible(false);
                btmodcli.setVisible(false);
                jButton4.setVisible(false);
                jButton8.setVisible(false);
                jButton11.setVisible(false);
                jButton12.setVisible(false);
                btnewuser.setVisible(false);
                boton1.setVisible(false);
                boton2.setVisible(false);
                boton3.setVisible(true);
                boton4.setVisible(true);
                break;
            case 'a':
                jButton7.setVisible(true);
                btagregarcli.setVisible(true);
                btaccli.setVisible(true);
                btmodcli.setVisible(true);
                jButton4.setVisible(true);
                jButton8.setVisible(true);
                jButton11.setVisible(true);
                jButton12.setVisible(true);
                btnewuser.setVisible(true);
                boton1.setVisible(true);
                boton2.setVisible(true);
                boton3.setVisible(true);
                boton4.setVisible(true);
                break;
            
        }
    }
    
    private Boolean esFormReporteValido() {
        if (txtcuerepor.getText() == null || txtcuerepor.getText().isEmpty()) {
            showError("Debe seleccionar una cuenta");
            return false;
        }
        
        if (!Validator.esEnteroPositivo(txtcuerepor.getText())) {
            showError("El n�mero de cuenta no es correcto.");
            return false;
        }
        
        return true;
    }
   
}
