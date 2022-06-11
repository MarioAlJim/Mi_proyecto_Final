package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author Usuario
 */
public interface ISesionTutoriaDAO {
    public List<SesionTutoria> consultarSesionesTutoriaPorNumero(String tutoriaBuscada);

    public SesionTutoria consultarSesionesTutoriaPorFechayPeriodo(String fechatutoria, int idPeriodo);

    public int registrarSesionTutoria(SesionTutoria sesionTutoria);

    public int registrarCierreDeReporte(SesionTutoria sesionTutoria);

    public int eliminarSesionTutoriaPorId(int idTutoria);
    
    public List<SesionTutoria> consultarTutoriaPorId(int idTutoriaBuscada);

    public ArrayList<SesionTutoria> consultarTutoriaPorPeriodo(int idPeriodo);
}



    