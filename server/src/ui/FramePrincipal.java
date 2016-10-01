package ui;

import vista.PrincipalVista;
import presentador.PrincipalPresentador;
import presentador.PrincipalPresentadorImpl;

public class FramePrincipal extends javax.swing.JFrame
              implements PrincipalVista {

  private PrincipalPresentador principalPresentador;

  public FramePrincipal() {
    initComponents();

    principalPresentador = new PrincipalPresentadorImpl(this);
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jPanelConfiguracion = new javax.swing.JPanel();
    jLabelHost = new javax.swing.JLabel();
    jTextFieldHost = new javax.swing.JTextField();
    jLabelPuertoBD = new javax.swing.JLabel();
    jTextFieldPuertoBD = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jLabelPuertoRMI = new javax.swing.JLabel();
    jTextFieldPuertoRMI = new javax.swing.JTextField();
    jTextFieldNombreBD = new javax.swing.JTextField();
    jLabelPasswordBD = new javax.swing.JLabel();
    jPasswordFieldPasswordBD = new javax.swing.JPasswordField();
    jPanelControles = new javax.swing.JPanel();
    jButtonStop = new javax.swing.JButton();
    jButtonStart = new javax.swing.JButton();
    jButtonRestart = new javax.swing.JButton();
    jMenuBar = new javax.swing.JMenuBar();
    jMenuArchivo = new javax.swing.JMenu();
    jMenuItemSalir = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Banco RMI - Server");
    setResizable(false);

    jPanelConfiguracion.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración"));

    jLabelHost.setText("Host BD");

    jLabelPuertoBD.setText("Puerto BD");

    jLabel2.setText("Nombre BD");

    jLabelPuertoRMI.setText("Puerto RMI");

    jLabelPasswordBD.setText("Password BD");

    javax.swing.GroupLayout jPanelConfiguracionLayout = new javax.swing.GroupLayout(jPanelConfiguracion);
    jPanelConfiguracion.setLayout(jPanelConfiguracionLayout);
    jPanelConfiguracionLayout.setHorizontalGroup(
      jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabelHost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jTextFieldHost)
          .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
            .addGroup(jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel2)
              .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                .addComponent(jLabelPuertoBD)
                .addGap(41, 41, 41)
                .addComponent(jLabelPuertoRMI))
              .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                .addComponent(jTextFieldPuertoBD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPuertoRMI, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jLabelPasswordBD)
              .addComponent(jTextFieldNombreBD, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
              .addComponent(jPasswordFieldPasswordBD))
            .addGap(0, 65, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanelConfiguracionLayout.setVerticalGroup(
      jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabelHost)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelPuertoBD)
          .addComponent(jLabelPuertoRMI))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldPuertoBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldPuertoRMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldNombreBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabelPasswordBD)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPasswordFieldPasswordBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanelControles.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

    jButtonStop.setText("Stop");
    jButtonStop.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonStopActionPerformed(evt);
      }
    });

    jButtonStart.setText("Start");
    jButtonStart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonStartActionPerformed(evt);
      }
    });

    jButtonRestart.setText("Restart");
    jButtonRestart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonRestartActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelControlesLayout = new javax.swing.GroupLayout(jPanelControles);
    jPanelControles.setLayout(jPanelControlesLayout);
    jPanelControlesLayout.setHorizontalGroup(
      jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelControlesLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButtonRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18))
    );
    jPanelControlesLayout.setVerticalGroup(
      jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelControlesLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButtonStop)
          .addComponent(jButtonRestart)
          .addComponent(jButtonStart))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(jPanelConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jMenuArchivo.setText("Archivo");

    jMenuItemSalir.setText("Salir");
    jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemSalirActionPerformed(evt);
      }
    });
    jMenuArchivo.add(jMenuItemSalir);

    jMenuBar.add(jMenuArchivo);

    setJMenuBar(jMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 12, Short.MAX_VALUE))
    );

    pack();
    setVisible(true);
  }

  private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {                                               
    System.exit(0);
  }

  private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {                                               
    principalPresentador.detenerServer();
  }

  private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {                                               
    principalPresentador.iniciarServer();
  }

  private void jButtonRestartActionPerformed(java.awt.event.ActionEvent evt) {                                               
    principalPresentador.reiniciarServer();
  }

  public void mostrarMensaje(String mensaje) {
    javax.swing.JOptionPane.showMessageDialog(
      this, 
      mensaje, 
      "Mensaje",
      javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
  }

  public void mostrarError(String error) {
    javax.swing.JOptionPane.showMessageDialog(
      this, 
      error, 
      "Error",
      javax.swing.JOptionPane.ERROR_MESSAGE
    );
  }

                    
  private javax.swing.JButton jButtonRestart;
  private javax.swing.JButton jButtonStart;
  private javax.swing.JButton jButtonStop;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabelHost;
  private javax.swing.JLabel jLabelPasswordBD;
  private javax.swing.JLabel jLabelPuertoBD;
  private javax.swing.JLabel jLabelPuertoRMI;
  private javax.swing.JMenu jMenuArchivo;
  private javax.swing.JMenuBar jMenuBar;
  private javax.swing.JMenuItem jMenuItemSalir;
  private javax.swing.JPanel jPanelConfiguracion;
  private javax.swing.JPanel jPanelControles;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JPasswordField jPasswordFieldPasswordBD;
  private javax.swing.JTextField jTextFieldHost;
  private javax.swing.JTextField jTextFieldNombreBD;
  private javax.swing.JTextField jTextFieldPuertoBD;
  private javax.swing.JTextField jTextFieldPuertoRMI;              
}
