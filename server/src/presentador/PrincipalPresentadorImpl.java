package presentador;

import vista.PrincipalVista;

public class PrincipalPresentadorImpl implements PrincipalPresentador {

  private PrincipalVista vista;

  public PrincipalPresentadorImpl(PrincipalVista vista) {
    this.vista = vista;
  }

  public void iniciarServer() {
    vista.mostrarMensaje("Servidor iniciado ... ");
  }

  public void detenerServer() {
    vista.mostrarMensaje("Servidor detenido ... ");
  }

  public void reiniciarServer() {
    vista.mostrarMensaje("Servidor reiniciado ... ");
  }

}