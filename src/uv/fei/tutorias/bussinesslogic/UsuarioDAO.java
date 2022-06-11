package uv.fei.tutorias.bussinesslogic;

import org.apache.log4j.Logger;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import uv.encrypt.SHA512;

public class UsuarioDAO implements IUsuarioDAO{

    final static Logger log = Logger.getLogger(SesionTutoriaDAO.class);

    @Override
    public Usuario recuperarSesion(String cuentauv, String contrasena) throws SQLException {
        Usuario usuario = new Usuario();
        SHA512 sha512 = new SHA512();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String query = ("SELECT U.cuentauv, U.contrasena, U.Nombre, U.ApellidoPaterno, U.ApellidoMaterno, UR.IdRol FROM usuarios U "
                + "inner join usuariosroles UR on UR.CuentaUV = U.cuentauv "
                + "where U.cuentauv = ? and U.contrasena = ? ");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cuentauv);
        statement.setString(2, sha512.getSHA512(contrasena));
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String cuentaUv = resultSet.getString("cuentaUV");
            String contrasenia = resultSet.getString("contrasena");
            String nombre = resultSet.getString("Nombre");
            String apellidoPaterno = resultSet.getString("ApellidoPaterno");
            String apellidoMaterno = resultSet.getString("ApellidoMaterno");
            int rol = resultSet.getInt("IdRol");
            usuario.setCuentaUV(cuentaUv);
            usuario.setContrasenia(contrasenia);
            usuario.setNombre(nombre);
            usuario.setApellidoPaterno(apellidoPaterno);
            usuario.setApellidoMaterno(apellidoMaterno);
            usuario.setRol(rol);
        }
        return usuario;
    }
}
