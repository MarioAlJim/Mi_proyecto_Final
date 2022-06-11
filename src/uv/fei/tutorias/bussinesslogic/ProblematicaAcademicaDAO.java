package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.ProblematicaAcademica;
import uv.fei.tutorias.domain.ProblematicaReporte;
import uv.gui.controladores.CU06ConsultarProblematicasAcademicasController;


public class ProblematicaAcademicaDAO implements IPoblematicaAcademicaDAO{

    final static Logger log = Logger.getLogger(CU06ConsultarProblematicasAcademicasController.class);

    @Override
    public ArrayList<ProblematicaReporte> consultarTodasLasProblematicasPorProgramaEducativoCuenta(int idProgramaEducativo, String cuentaUv) {
        ArrayList<ProblematicaReporte> problematicasAcademicas = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()){
        String query = (" SELECT tpa.*, t.FechaTutoria, d.Nombre Docente, ed.Nombre Experiencia FROM tutoriasproblematicasacademicas tpa " +
                "INNER JOIN tutoriasproblematicassesiones tps on tps.idproblemaacademica = tpa.IdProblemaAcademica  " +
                "INNER JOIN sesion s on s.idSesion = tps.idsesion  " +
                "INNER JOIN tutorias t on t.IdTutoria = s.IdTutoria  " +
                "INNER JOIN docenteseeprogramas deep on deep.IdDocenteEEPrograma = tpa.IdDocentesEEProgramas  " +
                "INNER JOIN experienciaseducativas ed on ed.NRC = deep.NRC  " +
                "INNER JOIN docentes d on d.NumPersonal = deep.NumPersonal " +
                "WHERE s.IdProgramaEducativo = ? AND s.cuentauv = ?;");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idProgramaEducativo);
        statement.setString(2, cuentaUv);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int idProblematicaAcademica;
            String titulo;
            String experiencia;
            String fecha;
            String descripcion;
            String docente;
            int cantidadTutorados;
            do {
                idProblematicaAcademica = resultSet.getInt("IdProblemaAcademica");
                titulo = resultSet.getString("Titulo");
                fecha = resultSet.getString("FechaTutoria");
                experiencia = resultSet.getString("Experiencia");
                descripcion = resultSet.getString("Descripcion");
                experiencia = resultSet.getString("Experiencia");
                docente = resultSet.getString("Docente");
                cantidadTutorados = resultSet.getInt("cantidadTutorados");
                ProblematicaReporte problematicaAcademica = new ProblematicaReporte();
                problematicaAcademica.setIdProblematicaAcademica(idProblematicaAcademica);
                problematicaAcademica.setFecha(fecha);
                problematicaAcademica.setExperiencia(experiencia);
                problematicaAcademica.setTitulo(titulo);
                problematicaAcademica.setDescripcion(descripcion);
                problematicaAcademica.setNombreDocente(docente);
                problematicaAcademica.setCantidadTutorados(cantidadTutorados);
                problematicasAcademicas.add(problematicaAcademica);
            } while (resultSet.next());
        }
        }catch(SQLException exception){
            log.fatal(exception);
        }
        return problematicasAcademicas;
    }

    /*@Override
    public ProblematicaReporte consultarProblematicaPorId(int idProblematicaAcademicaBuscada) throws SQLException {
        ProblematicaReporte problematicaAcademica = new ProblematicaReporte();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String query = "SELECT p.*, d.Nombre Docente, ed.Nombre Experiencia FROM tutoriasproblematicasacademicas p " +
                "INNER JOIN docenteseeprogramas deep on deep.IdDocenteEEPrograma = p.IdDocentesEEProgramas " +
                "INNER JOIN docentes d on d.NumPersonal = deep.NumPersonal " +
                "INNER JOIN experienciaseducativas ed on ed.NRC = deep.NRC " +
                "WHERE IdProblemaAcademica = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idProblematicaAcademicaBuscada);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int idProblematicaAcademica;
            String descripcion;
            String titulo;
            String experiencia;
            String docente;
            int cantidadTutorados;
            do {
                idProblematicaAcademica = resultSet.getInt("IdProblemaAcademica");
                descripcion = resultSet.getString("Descripcion");
                titulo = resultSet.getString("Titulo");
                experiencia = resultSet.getString("Experiencia");
                docente = resultSet.getString("Docente");
                cantidadTutorados = resultSet.getInt("cantidadTutorados");
                problematicaAcademica.setIdProblematicaAcademica(idProblematicaAcademica);
                problematicaAcademica.setDescripcion(descripcion);
                problematicaAcademica.setTitulo(titulo);
                problematicaAcademica.setNombreDocente(docente);
                problematicaAcademica.setExperiencia(experiencia);
                problematicaAcademica.setCantidadTutorados(cantidadTutorados);
            } while (resultSet.next());
        }
        return problematicaAcademica;
    }*/

    @Override
    public int registrarProblematicaAcademica(ProblematicaAcademica problematicaAcademica) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        Connection connection = dataBaseConnection.getConnection();
        String descripcion = problematicaAcademica.getDescripcion();
        String titulo = problematicaAcademica.getTitulo();
        int idDocenteEePrograma = problematicaAcademica.getIdDocenteEePrograma();
        int cantidadTutorados = problematicaAcademica.getCantidadTutorados();
        String query
                = "INSERT INTO tutoriasproblematicasacademicas (Titulo, Descripcion, cantidadTutorados, IdDocentesEEProgramas) "
                + "VALUES ( ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, titulo);
        statement.setString(2, descripcion);
        statement.setInt(3, cantidadTutorados);
        statement.setInt(4, idDocenteEePrograma);
        filasInsertadas = statement.executeUpdate();
        return filasInsertadas;
    }

    @Override
    public int actualizarProblematica(ProblematicaAcademica problematicaAcademica) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasActualizadas = 0;
        Connection connection=dataBaseConnection.getConnection();
            int idProblematicaAcademica = problematicaAcademica.getIdProblematicaAcademica();
            String descripcion = problematicaAcademica.getDescripcion();
            String solucion = problematicaAcademica.getSolucion();
            int idDocenteEePrograma = problematicaAcademica.getIdDocenteEePrograma();
            String query;
            query = ("UPDATE tutoriasproblematicasacademicas SET Descripcion = ?, Solucion = ?, IdDocentesEEProgramas = ?, IdHorario = ? WHERE IdProblemaAcademica = ?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, descripcion);
            statement.setString(2, solucion);
            statement.setInt(3, idDocenteEePrograma);
            statement.setInt(5, idProblematicaAcademica);
            filasActualizadas = statement.executeUpdate();
            System.out.println(filasActualizadas + " filas modificadas");
        return filasActualizadas;
    }

    @Override
    public int eliminarProblematica(int idProblematicaAcademica) throws SQLException{
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasEliminadas = 0;
        Connection connection=dataBaseConnection.getConnection();
            String query = "DELETE FROM tutoriasproblematicasacademicas WHERE IdProblemaAcademica = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idProblematicaAcademica);
            filasEliminadas = statement.executeUpdate();
            System.out.println(filasEliminadas + " Fila eiminada");
        return filasEliminadas;
    }
}
