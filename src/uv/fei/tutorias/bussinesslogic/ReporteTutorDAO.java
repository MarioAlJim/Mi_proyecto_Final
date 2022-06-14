/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.*;
import org.apache.log4j.Logger;

public class ReporteTutorDAO implements IReporteTutorDAO {

    final static Logger log = Logger.getLogger(ReporteTutorDAO.class);

    @Override
    public ArrayList<ReporteTutor> consultarReportesTutor() { // agregar variable de programa educativo
        ArrayList<ReporteTutor> reportestutores= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="select  pe.Nombre as programa, s.idSesion, concat(p.fechainicio, ' - ', p.fechafin) as periodo, t.NumeroTutoria as numTutoria,t.fechatutoria, concat(u.nombre, '  ', u.ApellidoPaterno, ' ', u.ApellidoMaterno) as nombre from sesion s inner join tutorias t on s.idtutoria=t.IdTutoria inner join periodo p on t.IdPeriodo=p.IdPeriodo inner join usuarios u on s.cuentauv=u.cuentauv inner join programaseducativos pe on s.IdProgramaEducativo=pe.IdProgramaEducativo where s.IdProgramaEducativo=2;"; 
               
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                int idsesion;
                String periodo;
                int numTutoria;
                String nombreTutor;
                String fecha;
                String programa;
                
                do {
                    numTutoria = resultSet.getInt("NumTutoria");
                    nombreTutor = resultSet.getString("Nombre");
                    periodo = resultSet.getString("periodo");
                    fecha=resultSet.getString("fechatutoria");
                    idsesion=resultSet.getInt("idsesion");
                    programa=resultSet.getString("programa");
                    
                    ReporteTutor reportetutor = new ReporteTutor();
                    reportetutor.setNombreTutor(nombreTutor);
                    reportetutor.setPeriodo(periodo);
                    reportetutor.setNumTutoria(numTutoria);
                    reportetutor.setFecha(fecha);
                    reportetutor.setIdsesion(idsesion);
                    reportetutor.setProgramaeducativo(programa);
                    reportestutores.add(reportetutor);
                }while (resultSet.next());
                
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return reportestutores;
    }

    @Override
    public ReporteTutor encabezadoReporte(int idsesion) {
        ReporteTutor reportetutor= new ReporteTutor();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="select  pe.Nombre as programa, s.idSesion, concat(p.fechainicio, ' - ', p.fechafin) as periodo, t.NumeroTutoria as numTutoria,t.fechatutoria, concat(u.nombre, '  ', u.ApellidoPaterno, ' ', u.ApellidoMaterno) as nombre from sesion s inner join tutorias t on s.idtutoria=t.IdTutoria inner join periodo p on t.IdPeriodo=p.IdPeriodo inner join usuarios u on s.cuentauv=u.cuentauv inner join programaseducativos pe on s.IdProgramaEducativo=pe.IdProgramaEducativo where s.Idsesion=?;"; 
               
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,idsesion);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                int idSesion;
                String periodo;
                int numTutoria;
                String nombreTutor;
                String fecha;
                String programa;
                
                do {
                    numTutoria = resultSet.getInt("NumTutoria");
                    nombreTutor = resultSet.getString("Nombre");
                    periodo = resultSet.getString("periodo");
                    fecha=resultSet.getString("fechatutoria");
                    idSesion=resultSet.getInt("idsesion");
                    programa=resultSet.getString("programa");
                    
                    
                    reportetutor.setNombreTutor(nombreTutor);
                    reportetutor.setPeriodo(periodo);
                    reportetutor.setNumTutoria(numTutoria);
                    reportetutor.setFecha(fecha);
                    reportetutor.setIdsesion(idsesion);
                    reportetutor.setProgramaeducativo(programa);
                    
                }while (resultSet.next());
                
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return reportetutor;
    }

    @Override
    public ArrayList<Asistencia> listaAsistencia(int idsesion) {
        ArrayList<Asistencia> asistencias= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="select a.matricula, t.nombre, a.asistencia from tutoriasasistencias a inner join tutorados t on a.matricula=t.Matricula where a.idsesion=?;"; 
               
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,idsesion);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                
                String matricula;
                String nombre;
                boolean asistencia;
               
                do {
                   
                    matricula = resultSet.getString("matricula");
                    nombre = resultSet.getString("nombre");
                    asistencia=resultSet.getBoolean("asistencia");
                    
                    Asistencia asistenciaAlumno = new Asistencia();
                    asistenciaAlumno.setNombre(nombre);
                    asistenciaAlumno.setMatricula(matricula);
                    asistenciaAlumno.setAsistencia(asistencia);
                    
                    asistencias.add(asistenciaAlumno);
                }while (resultSet.next());
                
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return asistencias;
    }

    @Override
    public String comentariosGenerales(int idsesion) {
        String comentario = null;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="select c.descripcion from tutoriascomentariosgenerales c inner join sesion s on c.IdComentarioGeneral=s.idcomentariogeneral where s.idSesion=3;"; 
               
            PreparedStatement statement=connection.prepareStatement(query);
            //statement.setInt(1,idsesion);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                
                comentario= resultSet.getString("descripcion");
                          
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return comentario;
    }

    @Override
    public ArrayList<ProblematicaReporte> problematicasReportadas(int idsesion) {
        ArrayList<ProblematicaReporte> problematicas= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="select e.nombre as experiencia, concat(d.nombre, ' ', d.ApellidoPaterno, ' ', d.ApellidoMaterno) as docente, pa.titulo as problematica from tutoriasproblematicassesiones ps inner join tutoriasproblematicasacademicas pa on ps.idproblemaacademica=pa.IdProblemaAcademica inner join docenteseeprogramas dep on pa.IdDocentesEEProgramas=dep.IdDocenteEEPrograma inner join experienciaseducativas e on dep.NRC=e.NRC inner join docentes d on dep.NumPersonal=d.NumPersonal where ps.idsesion=?;"; 
               
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,idsesion);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                
                String experiencia;
                String nombreDocente;
                String tituloProblematica;
               
                do {
                   
                    experiencia = resultSet.getString("experiencia");
                    nombreDocente = resultSet.getString("docente");
                    tituloProblematica=resultSet.getString("problematica");
                    
                    ProblematicaReporte  problematica= new ProblematicaReporte();
                    problematica.setExperiencia(experiencia);
                    problematica.setNombreDocente(nombreDocente);
                    problematica.setTitulo(tituloProblematica);
                    
                   problematicas.add(problematica);
                }while (resultSet.next());
                
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return problematicas;
    }

    @Override
    public ArrayList<Asistencia> obtenerTutoradosParaAsistencia(String cuentaUV, int idProgramaEducativo) {
        ArrayList<Asistencia> tutoradosAsistencia = new ArrayList<>();
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
                    Asistencia tutoradoAsistencia = new Asistencia();
                    tutoradoAsistencia.setMatricula(matricula);
                    tutoradoAsistencia.setNombre(nombre);
                    tutoradoAsistencia.setApellidoPaterno(apellidoPaterno);
                    tutoradoAsistencia.setApellidoMaterno(apellidoMaterno);
                    tutoradoAsistencia.setNombreCompleto(nombre + " " + apellidoPaterno + " " + apellidoMaterno);
                    tutoradosAsistencia.add(tutoradoAsistencia);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            log.fatal(ex);
        }
        return tutoradosAsistencia;
    }

    @Override
    public void eliminarReporteIncompleto(int idSesion) throws SQLException{
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasEliminadas = 0;
        Connection connection = dataBaseConnection.getConnection();
        String query = ("DELETE FROM sesion WHERE idSesion = ?");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idSesion);
        filasEliminadas = statement.executeUpdate();
    }

    @Override
    public int registrarReporte(ReporteTutor reporteTutor) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        Connection connection = dataBaseConnection.getConnection();
        int idTutoria = reporteTutor.getIdTutoria();
        int idProgramaEducativo = reporteTutor.getIdProgramaEducativo();
        String cuentaUv = reporteTutor.getCuentaUv();
        String query = "INSERT INTO sesion (IdProgramaEducativo, IdTutoria, cuentauv) "
                + "VALUES ( ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idProgramaEducativo);
        statement.setInt(2, idTutoria);
        statement.setString(3, cuentaUv);
        filasInsertadas = statement.executeUpdate();
        return filasInsertadas;
    }

    @Override
    public int obtenerIdReporte(ReporteTutor reporteBuscado) throws SQLException {
        int idReporteNuevo = 0;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String query = ("SELECT idSesion FROM sesion " +
                "WHERE IdProgramaEducativo = ? AND IdTutoria = ? AND cuentauv = ?");
        PreparedStatement statement = connection.prepareStatement(query);
        int idProgramaEducativo = reporteBuscado.getIdProgramaEducativo();
        String cuentauv = reporteBuscado.getCuentaUv();
        int idTutoria = reporteBuscado.getIdTutoria();
        statement.setInt(1, idProgramaEducativo);
        statement.setInt(2, idTutoria);
        statement.setString(3, cuentauv);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            idReporteNuevo = resultSet.getInt("idSesion");
        }
        return idReporteNuevo;
    }

    @Override
    public int registrarAsistencia(Asistencia listaAsistencia, int idSesion) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        Connection connection = dataBaseConnection.getConnection();
        String matricula = listaAsistencia.getMatricula();
        String query = "INSERT INTO tutoriasasistencias (idsesion, Matricula, asistencia, riesgo) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idSesion);
        statement.setString(2, matricula);
        statement.setInt(3, 1);
        if(listaAsistencia.getRiesgo())
            statement.setInt(4, 1);
        else
            statement.setInt(4,0);
        filasInsertadas = statement.executeUpdate();
        return filasInsertadas;
    }
}
