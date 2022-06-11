package uv.fei.tutorias.bussinesslogicTests;

import java.util.ArrayList;
import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.ProgramaEducativoDAO;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.ProgramaEducativo;

/**
 *
 * @author SILVERWOLF
 */
public class ProgramaEducativoDAOTest {
    
    public ProgramaEducativoDAOTest() {
    }

    @Test
    public void testConsultarTodosLosProgramasEducativos() {
        System.out.println("consultarTodosLosProgramasEducativos");
        ProgramaEducativoDAO instance = new ProgramaEducativoDAO();
        ArrayList<ProgramaEducativo> result = instance.consultarTodosLosProgramasEducativos();
        for(ProgramaEducativo programaEducativo : result){
            System.out.println(String.format("Id: %s, Nombre: %s", programaEducativo.getIdProgramaEducativo(), programaEducativo.getNombre()));
        }
        assertEquals(result, result);
    }
    
}
