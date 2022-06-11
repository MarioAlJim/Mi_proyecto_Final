package uv.fei.tutorias.bussinesslogic;
import uv.fei.tutorias.domain.Coordinador;
import java.util.List;

public interface ICoordinadorDAO {
    public List<Coordinador> consultAllCoordinadors();

    public List<Coordinador> searchCoordinadorByName(String searchName);

    public void deleteCoordinador(Coordinador coordinador);

    public void registerCoordinador(Coordinador coordinador);

    public void modifyCoordinador();

}
