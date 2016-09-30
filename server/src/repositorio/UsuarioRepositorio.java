package repositorio;

import java.util.List;

import remoto.modelo.Usuario;

public interface UsuarioRepositorio {

  public void guardar(Usuario usuario);
  public void actualizar(Usuario usuario);
  public void eliminar(Usuario usuario);
  public List<Usuario> listar();
  public Usuario obtenerPorLogin(String login);

}