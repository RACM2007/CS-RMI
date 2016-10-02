package presentador;

import vista.PrincipalVista;
import servidor.RMIServer;
import util.Parametros;
import util.ServerUtil;
import db.ConnectionFactory;

public class PrincipalPresentadorImpl implements PrincipalPresentador {

  private PrincipalVista vista;
  private RMIServer rmiServer;

  public PrincipalPresentadorImpl(PrincipalVista vista) {
    this.vista = vista;
    rmiServer = new RMIServer();
  }

  public void iniciarServer(final Parametros parametros) {

    Thread thread =  new Thread() {
      public void run() {
        vista.showProgress();
        vista.enableButtons(false, false, false);
        ConnectionFactory.setParametros(parametros);

        try {
          if (!ConnectionFactory.testConnection()) {
            vista.hideProgress();
            vista.enableButtons(true, false, false);
            vista.mostrarError("Imposible conectar con la base de datos.");
            return;
          }

          if (!ServerUtil.portAvailable(parametros.getPortRMI())) {
            vista.hideProgress();
            vista.enableButtons(true, false, false);
            vista.mostrarError("Imposible inicar servidor RMI en el puerto " + parametros.getPortRMI() + ", el puerto está ocupado.");
            return;
          }

          rmiServer.iniciarServidor(parametros);
          vista.hideProgress();
          vista.enableButtons(false, true, true);
          vista.mostrarMensaje("Servidor iniciado");
        } catch (Exception e) {
          vista.hideProgress();
          vista.mostrarError("Error al iniciar servidor");
          vista.enableButtons(true, false, false);
        }
      }
    };

    thread.start();
  }


  public void detenerServer() {
    vista.showProgress();
    vista.enableButtons(false, false, false);
    rmiServer.detenerServidor();
    vista.hideProgress();
    vista.enableButtons(true, false, false);
    vista.mostrarMensaje("Servidor detenido");
  }

  public void reiniciarServer(Parametros parametros) {
    detenerServer();
    iniciarServer(parametros);
  }

}