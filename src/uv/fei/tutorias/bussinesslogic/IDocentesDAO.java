package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.Docente;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDocentesDAO {


    public ArrayList<Docente> recuperarDocentesPorProgramaEducativo(int idPrograma) throws SQLException;
}
