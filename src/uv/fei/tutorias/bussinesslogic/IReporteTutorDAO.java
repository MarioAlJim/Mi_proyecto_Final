
package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
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

}
