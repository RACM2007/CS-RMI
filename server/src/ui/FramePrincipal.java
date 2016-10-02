package ui;

import vista.PrincipalVista;
import presentador.PrincipalPresentador;
import presentador.PrincipalPresentadorImpl;

import util.Parametros;

public class FramePrincipal extends javax.swing.JFrame
              implements PrincipalVista {

  private PrincipalPresentador principalPresentador;
  private Parametros parametros;

  public FramePrincipal() {
    initComponents();

    principalPresentador = new PrincipalPresentadorImpl(this);
    enableButtons(true, false, false);
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jPanelConfiguracion = new javax.swing.JPanel();
    jLabelHost = new javax.swing.JLabel();
    jTextFieldHost = new javax.swing.JTextField();
    jLabelPuertoBD = new javax.swing.JLabel();
    jTextFieldPuertoBD = new javax.swing.JTextField();
    jLabelNombreBD = new javax.swing.JLabel();
    jLabelUsuarioBD = new javax.swing.JLabel();
    jLabelPuertoRMI = new javax.swing.JLabel();
    jTextFieldPuertoRMI = new javax.swing.JTextField();
    jTextFieldNombreBD = new javax.swing.JTextField();
    jTextFieldUsuarioBD = new javax.swing.JTextField();
    jLabelPasswordBD = new javax.swing.JLabel();
    jPasswordFieldPasswordBD = new javax.swing.JPasswordField();
    jPanelControles = new javax.swing.JPanel();
    jButtonStop = new javax.swing.JButton();
    jButtonStart = new javax.swing.JButton();
    jButtonRestart = new javax.swing.JButton();
    jMenuBar = new javax.swing.JMenuBar();
    jMenuArchivo = new javax.swing.JMenu();
    jMenuItemSalir = new javax.swing.JMenuItem();
    jProgressBar = new javax.swing.JProgressBar();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Banco RMI - Server");
    setResizable(false);

    jPanelConfiguracion.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración"));

    jLabelHost.setText("Host BD");

    jLabelPuertoBD.setText("Puerto BD");

    jLabelNombreBD.setText("Nombre BD");

    jLabelUsuarioBD.setText("Usuario BD");

    jLabelPuertoRMI.setText("Puerto RMI");

    jLabelPasswordBD.setText("Password BD");

    jTextFieldHost.setText("localhost");
    jTextFieldPuertoBD.setText("3306");
    jTextFieldPuertoRMI.setText("8084");
    jTextFieldNombreBD.setText("banco");
    jTextFieldUsuarioBD.setText("root");

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
              .addComponent(jLabelNombreBD)
              .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                .addComponent(jLabelPuertoBD)
                .addGap(41, 41, 41)
                .addComponent(jLabelPuertoRMI))
              .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                .addComponent(jTextFieldPuertoBD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPuertoRMI, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jLabelUsuarioBD)
              .addComponent(jTextFieldUsuarioBD, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
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
        .addComponent(jLabelNombreBD)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldNombreBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabelUsuarioBD)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldUsuarioBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    jProgressBar.setIndeterminate(false);

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
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(90, 90, 90)
            .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 8, Short.MAX_VALUE))
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
    if (!validarParametros()) return;

    leerParametros();                                         
    principalPresentador.iniciarServer(parametros);
  }

  private void jButtonRestartActionPerformed(java.awt.event.ActionEvent evt) {
    if (!validarParametros()) return;

    leerParametros();                                          
    principalPresentador.reiniciarServer(parametros);
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

  public void enableButtons(Boolean start, Boolean stop, Boolean restart) {
    jButtonStart.setEnabled(start);
    jButtonStop.setEnabled(stop);
    jButtonRestart.setEnabled(restart);
  }

  public void showProgress() {
    jProgressBar.setIndeterminate(true);
  }

  public void hideProgress() {
    jProgressBar.setIndeterminate(false);
  }

  private void leerParametros() {
    parametros = new Parametros();
    parametros.setHostDB(jTextFieldHost.getText());
    parametros.setPortDB(Integer.valueOf(jTextFieldPuertoBD.getText()));
    parametros.setNameDB(jTextFieldNombreBD.getText());
    parametros.setUserDB(jTextFieldUsuarioBD.getText());
    parametros.setPassDB(new String(jPasswordFieldPasswordBD.getPassword()));
    parametros.setPortRMI(Integer.valueOf(jTextFieldPuertoRMI.getText()));

  }

  private Boolean validarParametros() {
    if (jTextFieldHost.getText().trim().equals("")) {
      mostrarError("Debe ingresar el host de la base de datos");
      return false;
    }

    if (jTextFieldPuertoBD.getText().trim().equals("")) {
      mostrarError("Debe ingresar el puerto de la base de datos");
      return false;
    }

    if (jTextFieldPuertoRMI.getText().trim().equals("")) {
      mostrarError("Debe ingresar el puerto RMI");
      return false;
    }

    if (jTextFieldNombreBD.getText().trim().equals("")) {
      mostrarError("Debe ingresar el nombre de la base de datos");
      return false;
    }

    if (jTextFieldUsuarioBD.getText().trim().equals("")) {
      mostrarError("Debe ingresar el usuario de la base de datos");
      return false;
    }

    if (new String(jPasswordFieldPasswordBD.getPassword()).trim().equals("")) {
      mostrarError("Debe ingresar el password de la base de datos");
      return false;
    }


    return true;
  }

                    
  private javax.swing.JButton jButtonRestart;
  private javax.swing.JButton jButtonStart;
  private javax.swing.JButton jButtonStop;
  private javax.swing.JLabel jLabelNombreBD;
  private javax.swing.JLabel jLabelUsuarioBD;
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
  private javax.swing.JProgressBar jProgressBar;
  private javax.swing.JTextField jTextFieldHost;
  private javax.swing.JTextField jTextFieldNombreBD;
  private javax.swing.JTextField jTextFieldUsuarioBD;
  private javax.swing.JTextField jTextFieldPuertoBD;
  private javax.swing.JTextField jTextFieldPuertoRMI;              
}
