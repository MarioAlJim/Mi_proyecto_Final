package uv.fei.tutorias.bussinesslogic;
import java.util.ArrayList;

import uv.fei.tutorias.domain.Asistencia;
import uv.fei.tutorias.domain.Tutorado;
import java.util.List;


public interface ITutoradoDAO {
    public ArrayList<Tutorado> mostrarTodosLosTutoradosRegistrados();

    public ArrayList<Tutorado> buscarTutoradoPorMatricula(String matriculaBuscada);

    public ArrayList<Tutorado> buscarTutoradoPorTutorPrograma(String cuentaUV, int idProgramaEducativo);

    public void registrarTutorado(Tutorado tutorado);

    
    public ArrayList<Tutorado> obtenerTutoradosPorNombreCompleto();

    public ArrayList<Asistencia> obtenerTutoradosParaAsistencia(String cuentaUV, int idProgramaEducativo);

}

