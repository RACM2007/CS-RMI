package vista;

public interface PrincipalVista {
  public void mostrarMensaje(String mensaje);
  public void mostrarError(String error);

  public void enableButtons(Boolean start, Boolean stop, Boolean restart);

  public void showProgress();
  public void hideProgress();
}