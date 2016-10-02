package presentador;

import util.Parametros;

public interface PrincipalPresentador {

  public void iniciarServer(Parametros parametros);
  public void detenerServer();
  public void reiniciarServer(Parametros parametros);
  
}