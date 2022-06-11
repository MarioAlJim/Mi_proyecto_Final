package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.ProblematicaAcademica;
import uv.fei.tutorias.domain.ProblematicaReporte;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPoblematicaAcademicaDAO {

    ArrayList<ProblematicaReporte> consultarTodasLasProblematicasPorProgramaEducativoCuenta(int idProgramaEducativo, String cuentaUv) throws SQLException;

    public int registrarProblematicaAcademica(ProblematicaAcademica problematicaAcademica) throws SQLException;

    public int eliminarProblematica(int idProblematicaAcademica) throws SQLException;

    public int actualizarProblematica(ProblematicaAcademica problematicaAcademica) throws SQLException;

}
