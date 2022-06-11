package uv.fei.tutorias.bussinesslogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.domain.Periodo;


public interface IPeriodoDAO {
    
    public ArrayList<Periodo> consultarTodosLosPeriodos();

    public Periodo consultarPeriodoPorId(int idPeriodoBuscado);

    public Periodo consultarPeriodoActivo() throws SQLException;
    
    public int registrarPeriodo(Periodo periodo);

    public int eliminarPeriodoId(int idPeriodo);

    public int actualizarPeriodo(Periodo periodo);
}