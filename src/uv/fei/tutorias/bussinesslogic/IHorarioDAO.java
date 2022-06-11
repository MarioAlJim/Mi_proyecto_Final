package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.Horario;

import java.util.ArrayList;
import java.util.List;

public interface IHorarioDAO {
    public ArrayList<Horario> consultarTodosLosHorarios();

    public ArrayList<Horario> consultarHorariosporIdTutoria(String cuentauv, int Idtutoria, int idProgramaEducativo);

    public int registrarHorario(Horario horario);

    public int actualizarHorario(Horario horario);

    public int eliminarHorario(int idHorario);

}

