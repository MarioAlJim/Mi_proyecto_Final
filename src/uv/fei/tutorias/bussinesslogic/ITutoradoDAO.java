package uv.fei.tutorias.bussinesslogic;
import java.util.ArrayList;
import uv.fei.tutorias.domain.Tutorado;
import java.util.List;


public interface ITutoradoDAO {
    public ArrayList<Tutorado> mostrarTodosLosTutoradosRegistrados();

    public ArrayList<Tutorado> buscarTutoradoPorMatricula(String matriculaBuscada);

    public ArrayList<Tutorado> buscarTutoradoPorTutorPrograma(String cuentaUV, int idProgramaEducativo);

    public void eliminarTutoradoPorMatricula(String matriculaEliminada);

    public void registrarTutorado(Tutorado tutorado);

    public void actualizarTutorado(Tutorado tutorado);
    
    public ArrayList<Tutorado> obtenerTutoradosPorNombreCompleto();

}

