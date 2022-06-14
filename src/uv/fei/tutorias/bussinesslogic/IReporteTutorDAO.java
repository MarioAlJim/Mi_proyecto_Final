
package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Asistencia;
import uv.fei.tutorias.domain.ProblematicaReporte;
import uv.fei.tutorias.domain.ReporteTutor;

/**
 *
 * @author Valea
 */
public interface IReporteTutorDAO {
     public ArrayList<ReporteTutor> consultarReportesTutor();
     public ReporteTutor encabezadoReporte(int idsesion);
     public ArrayList<Asistencia> listaAsistencia(int idsesion);
     public String comentariosGenerales(int idsesion);
     public ArrayList<ProblematicaReporte> problematicasReportadas(int idsesion);
     public ArrayList<Asistencia> obtenerTutoradosParaAsistencia(String cuentaUV, int idProgramaEducativo);
     public void eliminarReporteIncompleto(int idSesion) throws SQLException;
     public int registrarReporte(ReporteTutor reporteTutor) throws SQLException;
     public int obtenerIdReporte(ReporteTutor reporteBuscado) throws SQLException;
     public int registrarAsistencia(Asistencia listaAsistencia, int idSesion) throws SQLException;
}
