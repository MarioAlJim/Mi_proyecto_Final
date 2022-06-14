package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class HorarioDAO implements IHorarioDAO {

    final static Logger log = Logger.getLogger(HorarioDAO.class);

    @Override
    public ArrayList<Horario> consultarTodosLosHorarios() {
        ArrayList<Horario> horarios= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM horarios;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron horarios");
            }else{
                int  idHorario;
                String hora;
                int idTutoria;
                String matricula;
                do {
                    idHorario = resultSet.getInt("IdHorario");
                    hora = resultSet.getString("HoraInicio");
                    idTutoria = resultSet.getInt("Idtutoria");
                    matricula = resultSet.getString("Matricula");
                    Horario horario = new Horario();
                    horario.setIdHorario(idHorario);
                    horario.setHora(hora);
                    horario.setIdTutoria(idTutoria);
                    horario.setMatricula(matricula);
                    horarios.add(horario);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
           log.fatal(ex);
        }
        return horarios;
    }

    @Override
    public ArrayList<Horario> consultarHorariosporIdTutoria(String cuentauv, int Idtutoria, int programaEducativo) {
        ArrayList<Horario> horarios= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query=
                    ("SELECT IdTutoria, IdHorario, HoraInicio, T.Matricula, concat_ws(' ', T.Nombre, T.ApellidoPaterno, ApellidoMaterno) Tutorado " +
                            "FROM horario inner join tutorados T on T.Matricula = horario.Matricula WHERE IdTutoria = ? and cuentauv = ? AND IdProgramaEducativo = ?");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, Idtutoria);
            statement.setString(2, cuentauv);
            statement.setInt(3, programaEducativo);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                int idHorario;
                String hora;
                int idTutoria;
                String matricula;
                String tutorado;
                do {
                    idTutoria = resultSet.getInt("IdTutoria");
                    idHorario = resultSet.getInt("IdHorario");
                    hora = resultSet.getString("HoraInicio");
                    matricula = resultSet.getString("Matricula");
                    tutorado = resultSet.getString("Tutorado");
                    Horario horario = new Horario();
                    horario.setIdHorario(idHorario);
                    horario.setHora(hora);
                    horario.setIdTutoria(idTutoria);
                    horario.setMatricula(matricula);
                    horario.setNombre(tutorado);
                    horarios.add(horario);
                }while(resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return horarios;
    }

    @Override
    public int registrarHorario(Horario horario) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String hora = horario.getHora();
            int idTutoria = horario.getIdTutoria();
            String matricula = horario.getMatricula();
            String cuentauv = horario.getCuentauv();
            int idProgramaEducativo = horario.getIdProgramaEducativo();
            String query = "INSERT INTO horario (HoraInicio, IdTutoria, Matricula, cuentauv, IdProgramaEducativo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hora);
            statement.setInt(2, idTutoria);
            statement.setString(3, matricula);
            statement.setString(4, cuentauv);
            statement.setInt(5, idProgramaEducativo);
            filasInsertadas = statement.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasInsertadas;
    }

    @Override
    public int actualizarHorario(Horario horario) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasActualizadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            int idHorario = horario.getIdHorario();
            String hora = horario.getHora();
            String query =
                    ("UPDATE horario SET HoraInicio = ? WHERE IdHorario = ?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hora);
            statement.setInt(2, idHorario);
            filasActualizadas = statement.executeUpdate();
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return filasActualizadas;
    }

    @Override
    public int eliminarHorario(int idHorario) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasEliminadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String query = "DELETE FROM horario WHERE IdHorario = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idHorario);
            filasEliminadas = statement.executeUpdate();
            System.out.println(filasEliminadas + " Fila eiminada");
        } catch (SQLException ex) {
            log.error(ex);
        }
        return filasEliminadas;
    }


    public ArrayList<Horario> obtenerTutoradosParaRegistrodeHorario(String cuentaUV, int idProgramaEducativo){
        ArrayList<Horario> tutoradosHorario = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query= ("SELECT tutorados.Matricula, tutorados.Nombre, tutorados.ApellidoPaterno, tutorados.ApellidoMaterno FROM tutorados " +
                    "INNER JOIN tutorestutorados ON tutorestutorados.Matricula = tutorados.Matricula " +
                    "INNER JOIN tutoradosprogramas ON tutoradosprogramas.Matricula = tutorados. Matricula " +
                    "WHERE tutorestutorados.CuentaUV = ? AND tutoradosprogramas.IdProgramaEducativo = ?;");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, cuentaUV);
            statement.setInt(2, idProgramaEducativo);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()) {
                String matricula;
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                do {
                    matricula = resultSet.getString("Matricula");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    Horario tutoradoHorario = new Horario();
                    tutoradoHorario.setMatricula(matricula);
                    tutoradoHorario.setNombre(nombre);
                    tutoradoHorario.setApellidoPaterno(apellidoPaterno);
                    tutoradoHorario.setApellidoMaterno(apellidoMaterno);
                    tutoradoHorario.setNombreCompleto(nombre + " " + apellidoPaterno + " " + apellidoMaterno);
                    tutoradosHorario.add(tutoradoHorario);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutoradosHorario;
    }
}
