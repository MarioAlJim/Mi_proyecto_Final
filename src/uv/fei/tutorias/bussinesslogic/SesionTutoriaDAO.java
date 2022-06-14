package uv.fei.tutorias.bussinesslogic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author Usuario
 */
public class SesionTutoriaDAO implements ISesionTutoriaDAO {
    
    final static Logger log = Logger.getLogger(TutorDAO.class);

    
    @Override
    public int registrarSesionTutoria(SesionTutoria sesionTutoria) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String fechaTutoria = sesionTutoria.getFechaTutoria();
            String numTutoria = sesionTutoria.getNumTutoria();
            String query = "INSERT INTO tutorias (NumeroTutoria, FechaTutoria) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numTutoria);
            statement.setString(2, fechaTutoria);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    @Override
    public int eliminarSesionTutoriaPorId(int idTutoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SesionTutoria> consultarSesionesTutoriaPorNumero(String tutoriaBuscada) {
        ArrayList<SesionTutoria> sesiones= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutorias WHERE NumeroTutoria = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, tutoriaBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron sesiones de tutorias registradas");
            }else{
                String numTutoria;
                String fechaTutoria;
                do {
                    numTutoria = resultSet.getString("NumeroTutoria");
                    fechaTutoria = resultSet.getString("FechaTutoria");
                    SesionTutoria sesionTutoria = new SesionTutoria();
                    sesionTutoria.setNumTutoria(numTutoria);
                    sesionTutoria.setFechaTutoria(fechaTutoria);
                    sesiones.add(sesionTutoria);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return sesiones;
    }

    @Override
    public SesionTutoria consultarSesionesTutoriaPorFechayPeriodo(String fechatutoria, int idPeriodo) {
        SesionTutoria sesionTutoria = new SesionTutoria();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutorias WHERE FechaTutoria = ? and IdPeriodo = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, fechatutoria);
            statement.setInt(2, idPeriodo);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron sesiones de tutorias registradas");
            }else{
                int idTutoria;
                idTutoria = resultSet.getInt("IdTutoria");
                sesionTutoria.setIdSesionTutoria(idTutoria);
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return sesionTutoria;
    }

    @Override
    public int registrarCierreDeReporte(SesionTutoria sesionTutoria) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String fechaCierreReportes = sesionTutoria.getFechaCierreReportes();
            String query = "INSERT INTO tutorias (FechaCierreReportes) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fechaCierreReportes);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
            
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    @Override
    public List<SesionTutoria> consultarTutoriaPorId(int idTutoriaBuscada) {
        ArrayList<SesionTutoria> sesiones= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutorias WHERE IdTutoria = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idTutoriaBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                int idSesionTutoria;
                String fechaCierreReportes;
                do {
                    idSesionTutoria = resultSet.getInt("IdTutoria");
                    fechaCierreReportes = resultSet.getString("FechaCierreReportes");
                    SesionTutoria sesionTutoria = new SesionTutoria();
                    sesionTutoria.setIdSesionTutoria(idSesionTutoria);
                    sesionTutoria.setFechaCierreReportes(fechaCierreReportes);
                    sesiones.add(sesionTutoria);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return sesiones;
    }

    @Override
    public ArrayList<SesionTutoria> consultarTutoriaPorPeriodo(int idPeriodo) throws SQLException{
        ArrayList<SesionTutoria> sesiones= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection=dataBaseConnection.getConnection();
            String query="SELECT * FROM tutorias WHERE IdPeriodo = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idPeriodo);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                int idSesionTutoria;
                String fechaTutoria;
                String numTutoria;
                String fechaCierre;
                do {
                    idSesionTutoria = resultSet.getInt("IdTutoria");
                    numTutoria = resultSet.getString("NumeroTutoria");
                    fechaTutoria = resultSet.getString("FechaTutoria");
                    fechaCierre = resultSet.getString("FechaCierreReportes");
                    SesionTutoria sesionTutoria = new SesionTutoria();
                    sesionTutoria.setIdSesionTutoria(idSesionTutoria);
                    sesionTutoria.setNumTutoria(numTutoria);
                    sesionTutoria.setFechaTutoria(fechaTutoria);
                    sesionTutoria.setFechaCierreReportes(fechaCierre);
                    sesiones.add(sesionTutoria);
                }while (resultSet.next());
            }
        return sesiones;
    }
    
    
}
