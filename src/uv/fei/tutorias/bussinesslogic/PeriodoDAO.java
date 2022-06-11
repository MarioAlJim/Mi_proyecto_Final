package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class PeriodoDAO implements IPeriodoDAO {

    final static Logger log = Logger.getLogger(PeriodoDAO.class);
    
    @Override
    public ArrayList<Periodo> consultarTodosLosPeriodos() {
        ArrayList<Periodo> periodos= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM periodo;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron periodos");
            }else{
                int  idPeriodo;
                String fechaInicio;
                String fechaFin;
                do {
                    idPeriodo = resultSet.getInt("IdPeriodo");
                    fechaInicio = resultSet.getString("FechaInicio");
                    fechaFin = resultSet.getString("FechaFin");
                    Periodo periodo = new Periodo();
                    periodo.setIdPeriodo(idPeriodo);
                    periodo.setFechaInicio(fechaInicio);
                    periodo.setFechaFin(fechaFin);
                    periodos.add(periodo);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
           log.fatal(ex);
        }
        return periodos;
    }

    @Override
    public int registrarPeriodo(Periodo periodo) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String fechaInicio = periodo.getFechaInicio();
            String fechaFin = periodo.getFechaFin();
            String query = "INSERT INTO periodo (FechaInicio, FechaFin) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fechaInicio);
            statement.setString(2, fechaFin);
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    @Override
    public int eliminarPeriodoId(int idPeriodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int actualizarPeriodo(Periodo periodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Periodo consultarPeriodoPorId(int idPeriodoBuscado) {
        Periodo periodo = new Periodo();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM periodo WHERE IdPeriodo = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idPeriodoBuscado);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron periodos");
            }else{
                String fechaInicio;
                String fechaFin;
                fechaInicio = resultSet.getString("FechaInicio");
                fechaFin = resultSet.getString("FechaFin");
                periodo.setFechaInicio(fechaInicio);
                periodo.setFechaFin(fechaFin);
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return periodo;
    }

    @Override
    public Periodo consultarPeriodoActivo() throws SQLException{
        Periodo periodo = new Periodo();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection=dataBaseConnection.getConnection();
            String query="SELECT * FROM periodo WHERE activo = 1";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron periodos");
            }else{
                String fechaInicio;
                String fechaFin;
                int idPeriodo;
                idPeriodo = resultSet.getInt("IdPeriodo");
                fechaInicio = resultSet.getString("FechaInicio");
                fechaFin = resultSet.getString("FechaFin");
                periodo.setIdPeriodo(idPeriodo);
                periodo.setFechaInicio(fechaInicio);
                periodo.setFechaFin(fechaFin);
            }
        return periodo;
    }
}
