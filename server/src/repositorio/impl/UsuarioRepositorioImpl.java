package repositorio.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import remoto.modelo.Usuario;
import repositorio.UsuarioRepositorio;

public class UsuarioRepositorioImpl implements UsuarioRepositorio {

  private Connection connection;

  public UsuarioRepositorioImpl(Connection connection) {
    this.connection = connection;
  }

  public void guardar(Usuario usuario) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("insert into usuario (login, password) values (?,?)", Statement.RETURN_GENERATED_KEYS);

      statement.setString(1, usuario.getLogin());
      statement.setString(2, usuario.getPassword());

      statement.executeUpdate();

      // Obtener ID generado
      ResultSet rs = statement.getGeneratedKeys();
      if (rs.next()) {
        Integer newId = rs.getInt(1);
        usuario.setId(newId);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

  }

  public void actualizar(Usuario usuario) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("update usuario set login=?, password=? where id=?");

      statement.setString(1, usuario.getLogin());
      statement.setString(2, usuario.getPassword());
      statement.setInt(3, usuario.getId());

      statement.executeUpdate();

    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public void eliminar(Usuario usuario) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("delete from usuario where id=?");

      statement.setInt(1, usuario.getId());
      statement.executeUpdate();
      usuario.setId(null);

      System.out.println(usuario);
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Usuario> listar() {
    List<Usuario> usuarios = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from usuario");

      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt(1));
        usuario.setLogin(rs.getString(2));
        usuario.setPassword(rs.getString(3));

        usuarios.add(usuario);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  public Usuario obtenerPorLogin(String login) {
    Usuario usuario = null;

    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from usuario where login=?");

      statement.setString(1, login);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        usuario = new Usuario();
        usuario.setId(rs.getInt(1));
        usuario.setLogin(rs.getString(2));
        usuario.setPassword(rs.getString(3));
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

    return usuario;
  }

}