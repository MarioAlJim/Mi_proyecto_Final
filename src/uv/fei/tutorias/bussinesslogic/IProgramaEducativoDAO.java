package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.ProgramaEducativo;

import java.util.List;

public interface IProgramaEducativoDAO {

    public List<ProgramaEducativo> consultarTodosLosProgramasEducativos();
}
