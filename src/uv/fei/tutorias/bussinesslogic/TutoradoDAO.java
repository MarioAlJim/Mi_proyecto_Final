package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Asistencia;
import uv.fei.tutorias.domain.SesionTutoria;
import uv.fei.tutorias.domain.Tutorado;
import org.apache.log4j.Logger;


public class TutoradoDAO implements ITutoradoDAO{
    
    final static Logger log = Logger.getLogger(TutoradoDAO.class);

    @Override
    public ArrayList<Tutorado> mostrarTodosLosTutoradosRegistrados(){
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="select * from tutorados;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron tutorados");
            }else{
                String matricula;
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                String correo;
                do {
                    matricula = resultSet.getString("Matricula");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    correo = resultSet.getString("Correo");
                    Tutorado tutoradoBuscado = new Tutorado();
                    tutoradoBuscado.setMatricula(matricula);
                    tutoradoBuscado.setNombre(nombre);
                    tutoradoBuscado.setApellidoPaterno(apellidoPaterno);
                    tutoradoBuscado.setApellidoMaterno(apellidoMaterno);
                    tutoradoBuscado.setCorreo(correo);
                    tutorados.add(tutoradoBuscado);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutorados;
    }

    @Override
    public ArrayList<Tutorado> buscarTutoradoPorMatricula(String matriculaBuscada){
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="Select * from tutorados where Matricula = ";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,"'" + matriculaBuscada + "'");
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron tutorados");
            }else{
                String matricula;
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                String correo;
                do {
                    matricula = resultSet.getString("Matricula");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    correo = resultSet.getString("Correo");
                    Tutorado tutoradoBuscado = new Tutorado();
                    tutoradoBuscado.setMatricula(matricula);
                    tutoradoBuscado.setNombre(nombre);
                    tutoradoBuscado.setApellidoPaterno(apellidoPaterno);
                    tutoradoBuscado.setApellidoMaterno(apellidoMaterno);
                    tutoradoBuscado.setCorreo(correo);
                    tutorados.add(tutoradoBuscado);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutorados;
    }

    @Override
    public ArrayList<Tutorado> buscarTutoradoPorTutorPrograma(String cuentaUV, int idProgramaEducativo) {
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query= ("SELECT T.Matricula, T.Nombre, T.ApellidoPaterno, T.ApellidoMaterno FROM tutorados T  " +
                    "INNER JOIN tutoradosprogramas TP on TP.Matricula = T.Matricula  " +
                    "INNER JOIN tutorestutorados TT on TT.Matricula = T.Matricula " +
                    "WHERE TT.CuentaUV = ? AND TP.IdProgramaEducativo = ?");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, cuentaUV);
            statement.setInt(2, idProgramaEducativo);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                String matricula;
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                do {
                    matricula = resultSet.getString("Matricula");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    Tutorado tutoradoBuscado = new Tutorado();
                    tutoradoBuscado.setMatricula(matricula);
                    tutoradoBuscado.setNombre(nombre);
                    tutoradoBuscado.setApellidoPaterno(apellidoPaterno);
                    tutoradoBuscado.setApellidoMaterno(apellidoMaterno);
                    tutorados.add(tutoradoBuscado);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutorados;
    }

    @Override
    public void registrarTutorado(Tutorado tutorado){ //inseguro
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){  
            String matricula = tutorado.getMatricula();
            String nombre = tutorado.getNombre();
            String apellidoPaterno = tutorado.getApellidoPaterno();
            String apellidoMaterno = tutorado.getApellidoMaterno();
            String correo = tutorado.getCorreo();
            String query = "INSERT INTO tutorados VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, matricula);
            statement.setString(2, nombre);
            statement.setString(3, apellidoPaterno);
            statement.setString(4, apellidoMaterno);
            statement.setString(5, correo);
            int filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            log.fatal(ex);
        }
    }
    
    @Override
    public ArrayList<Tutorado> obtenerTutoradosPorNombreCompleto() {
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT Nombre , ApellidoPaterno, ApellidoMaterno from tutorados";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No hay tutorados registrados tutorados");
            }else{
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                
                do {
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    Tutorado tutoradoBuscado = new Tutorado();
                    tutoradoBuscado.setNombre(nombre);
                    tutoradoBuscado.setApellidoPaterno(apellidoPaterno);
                    tutoradoBuscado.setApellidoMaterno(apellidoMaterno);
                    tutorados.add(tutoradoBuscado);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutorados;
    }

    public ArrayList<Asistencia> obtenerTutoradosParaAsistencia(String cuentaUV, int idProgramaEducativo){
        ArrayList<Asistencia> tutoradosAsistencia = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query= ("SELECT T.Matricula, T.Nombre, T.ApellidoPaterno, T.ApellidoMaterno FROM tutorados T  " +
                    "INNER JOIN tutoradosprogramas TP on TP.Matricula = T.Matricula  " +
                    "INNER JOIN tutorestutorados TT on TT.Matricula = T.Matricula " +
                    "WHERE TT.CuentaUV = ? AND TP.IdProgramaEducativo = ?");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, cuentaUV);
            statement.setInt(2, idProgramaEducativo);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                String matricula;
                String nombre;
                String apellidoPaterno;
                String apellidoMaterno;
                String nombreCompleto;
                do {
                    matricula = resultSet.getString("Matricula");
                    nombre = resultSet.getString("Nombre");
                    apellidoPaterno = resultSet.getString("ApellidoPaterno");
                    apellidoMaterno = resultSet.getString("ApellidoMaterno");
                    Asistencia asistencia = new Asistencia();
                    asistencia.setMatricula(matricula);
                    asistencia.setNombre(nombre);
                    asistencia.setApellidoPaterno(apellidoPaterno);
                    asistencia.setApellidoMaterno(apellidoMaterno);
                    asistencia.setNombreCompleto(nombre + " " + apellidoPaterno + " "+ apellidoPaterno);
                    tutoradosAsistencia.add(asistencia);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutoradosAsistencia;
    }

}
