package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.Tutoria;
    import java.util.List;

public interface ITutoriaDAO {
    
    public List<Tutoria> consultarTodasTutorias();

    public int registrarTutoria(Tutoria tutoria);

    public int eliminarTutoriaPorId(int idTutoria);
    
}
