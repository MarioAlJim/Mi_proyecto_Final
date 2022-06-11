package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.Usuario;

import java.sql.SQLException;

public interface IUsuarioDAO {

    public Usuario recuperarSesion(String cuentauv, String contrasena) throws SQLException;


}
