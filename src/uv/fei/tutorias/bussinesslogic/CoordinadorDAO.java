package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Coordinador;
import org.apache.log4j.Logger;

/**
 *
 * @author Valea
 */
public class CoordinadorDAO implements ICoordinadorDAO{
    
    final static Logger log = Logger.getLogger(CoordinadorDAO.class);
    
    @Override
    public List<Coordinador> consultAllCoordinadors() {
        ArrayList<Coordinador> coordinadores = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="select * from usuarios right join usuariosroles on usuariosroles.CuentaUV = usuarios.CuentaUV right join roles on roles.IdRol = usuariosroles.IdRol where roles.Descripcion = 'Coordinador';";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                throw new SQLException("No se encontraron coordinadores");
            }else{
                String cuentaUV = "";
                String nombre = "";
                String apellidoPaterno = "";
                String apellidoMaterno = "";
                String correo = "";
                do {
                    cuentaUV = resultSet.getString("CuentaUV");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("Paterno");
                    apellidoMaterno = resultSet.getString("Materno");
                    correo = resultSet.getString("Correo");
                    Coordinador coordinador = new Coordinador();
                    coordinador.setCuentaUV(cuentaUV);
                    coordinador.setNombre(nombre);
                    coordinador.setApellidoPaterno(apellidoPaterno);
                    coordinador.setApellidoMaterno(apellidoMaterno);
                    coordinador.setCorreo(correo);
                    coordinadores.add(coordinador);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return coordinadores;
    }
    
    @Override
    /*should be exist a register before from Usuarios */
    public void registerCoordinador(Coordinador coordinador) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){  
            String queryconection = "INSERT INTO usuariosroles VALUES (" + "'" + coordinador.getCuentaUV() + "' , 3" ;
            PreparedStatement statementconection = connection.prepareStatement(queryconection);
            statementconection.executeUpdate();
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        
    }  
    
    @Override
    public void deleteCoordinador(Coordinador coordinador) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query = "DELETE FROM usuariosroles   WHERE  CuentaUV= ('" + coordinador.getCuentaUV() + " )" ;
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                throw new SQLException("No se pudo eliminar el coordinador");
            }else{
                System.out.println("El coordinador ha sido eliminado correctaente");
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
    }

    @Override
    public List<Coordinador> searchCoordinadorByName(String searchName) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void modifyCoordinador() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
