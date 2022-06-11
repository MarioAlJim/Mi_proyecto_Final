
package uv.fei.tutorias.bussinesslogic;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.domain.ExperienciaEducativa;

/**
 *
 * @author Valea
 */
public interface IExperienciaEducativaDAO {
     public ArrayList<ExperienciaEducativa> consultarTodasLasExperiencias();
     public ArrayList<ExperienciaEducativa> consultarExperienciasNoAsignadas();
     public ArrayList<ExperienciaEducativa> consultarExperienciasPorPrograma(int idProgramaEducativo) throws SQLException;
     public ArrayList<ExperienciaEducativa> consultarExperienciasPorDocente(int numPersonal) throws SQLException;

}
