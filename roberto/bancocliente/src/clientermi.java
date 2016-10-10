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

public class clientermi extends javax.swing.JFrame implements ActionListener {

    public static final String RETIRO = "RETIRO";
    public static final String DEPOSITO = "DEPOSITO";
    public static final String TRANSFERENCIA = "TRANSFERENCIA";

    private cliente clienteActual;

    String direccion;
    int puerto;
    bancointer interfaz;

    public clientermi() {

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
            interfaz = (bancointer) registro.lookup("rmi://" + direccion + ":" + puerto + "/bancoservidor");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        boolean i = ingresar();
        while (i == false) {
            JOptionPane.showMessageDialog(null, "Error en el Login o la Contraseña");
            i = ingresar();
        }

        initComponents();
        btsalir.addActionListener(this);
        btaccli.addActionListener(this);
        btacmov.addActionListener(this);
        btaccue.addActionListener(this);
        btagregarcli.addActionListener(this);

        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setVisible(true);
        //this.setLocationRelativeTo(null);
        //this.setResizable(false);
        this.setTitle("BANCO RMI");

        actualizartablaclientes();
        actualizartablamov();
        actualizartablacuentas();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btsalir = new javax.swing.JButton();
        jPanelClientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btaccli = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablacli = new javax.swing.JTable();
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
        jPanelCuentas = new javax.swing.JPanel();
        btaccue = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacue = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtcuedni = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        comboTipoCuenta = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jPanelMovimientos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btacmov = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablamov = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoMov = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMontoMovimiento = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        txtCuentaOrigen = new javax.swing.JTextField();
        txtCuentaDestino = new javax.swing.JTextField();
        txtDniOrigen = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("BIENVENIDO AL SISTEMA BANCARIO");

        btsalir.setText("SALIR DEL SISTEMA");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Clientes:");

        btaccli.setText("ACTUALIZAR");

        tablacli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno", "Teléfono"
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

        jLabel7.setText("TELÉFONO:");

        jLabel4.setText("NOMBRE:");

        jLabel5.setText("APELLIDO PATERNO:");

        jLabel6.setText("APELLIDO MATERNO:");

        btagregarcli.setText("NUEVO");
        btagregarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btagregarcliActionPerformed(evt);
            }
        });

        jButton4.setText("GUARDAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setText("ELIMINAR");

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addComponent(btaccli, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btagregarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btaccli, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btaccue.setText("ACTUALIZAR");

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
        jScrollPane2.setViewportView(tablacue);

        jLabel15.setText("NÚMERO DE CUENTA:");

        jTextField7.setEditable(false);

        jLabel17.setText("DNI PROPIETARIO:");

        txtcuedni.setEditable(false);

        jButton11.setText("AGREGAR CUENTA");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("ELIMINAR CUENTA");

        jLabel16.setText("TIPO:");

        comboTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ahorros", "corriente" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipoCuenta, 0, 156, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtcuedni, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addGap(127, 127, 127))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcuedni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCuentasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCuentasLayout.createSequentialGroup()
                        .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btaccue, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCuentasLayout.setVerticalGroup(
            jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuentasLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btaccue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Movimientos:");

        btacmov.setText("ACTUALIZAR");

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

        jComboBoxTipoMov.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DEPOSITO", "RETIRO", "TRANSFERENCIA" }));
        jComboBoxTipoMov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoMovItemStateChanged(evt);
            }
        });

        jLabel10.setText("Cuenta Origen:");

        jLabel11.setText("Cuenta Destino:");

        jLabel12.setText("Monto:");

        jButton7.setText("REALIZAR MOVIMIENTO BANCARIO");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        txtCuentaOrigen.setEnabled(false);

        jLabel18.setText("Dni Origen:");

        javax.swing.GroupLayout jPanelMovimientosLayout = new javax.swing.GroupLayout(jPanelMovimientos);
        jPanelMovimientos.setLayout(jPanelMovimientosLayout);
        jPanelMovimientosLayout.setHorizontalGroup(
            jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btacmov, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                                .addGap(157, 157, 157)
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
                                            .addComponent(txtCuentaOrigen)))))))
                    .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jButton7)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanelMovimientosLayout.setVerticalGroup(
            jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btacmov, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(476, 476, 476)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        }
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

            try {
                RespuestaServidor resp = interfaz.agregarMovimiento(mov, strUsername);
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

        new clientermi();
    }

    private String strUsername;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btaccli;
    private javax.swing.JButton btaccue;
    private javax.swing.JButton btacmov;
    private javax.swing.JButton btagregarcli;
    private javax.swing.JButton btsalir;
    private javax.swing.JComboBox comboTipoCuenta;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBoxTipoMov;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField7;
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

            JOptionPane.showMessageDialog(null, paneli, "login", JOptionPane.QUESTION_MESSAGE);
            strUsername = username.getText();
            return interfaz.ingresar(username.getText(), password.getText());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (btaccli == obj) {
            actualizartablaclientes();
        }
        if (btsalir == obj) {
            System.exit(0);
        }

        if (btacmov == obj) {
            actualizartablamov();
        }

        if (btaccue == obj) {
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
}
