package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.DocenteEEPrograma;

public class DocenteEEProgramasDAOTest {
    
    public DocenteEEProgramasDAOTest() {
    }

    @Test
    public void testAsignarEEProfesor() {
        System.out.println("asignarEEProfesor");
        int nrc = 0;
        int numpersonal = 0;
        DocenteEEProgramasDAO instance = new DocenteEEProgramasDAO();
        int expResult = 0;
        int result = instance.asignarEEProfesor(nrc, numpersonal);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerOfertaAcademicaGeneral() {
        System.out.println("obtenerOfertaAcademicaGeneral");
        DocenteEEProgramasDAO instance = new DocenteEEProgramasDAO();
        ArrayList<DocenteEEPrograma> expResult = null;
        ArrayList<DocenteEEPrograma> result = instance.obtenerOfertaAcademicaGeneral();
        
        for(DocenteEEPrograma dep : result){
            System.out.println(String.format("%s", dep.getIdOfertaAcademica()));
        }
        assertEquals(result, result);
    }

    @Test
    public void testConsultarOfertaAcademicaPorProgramaEducativo() {
        System.out.println("consultarOfertaAcademicaPorProgramaEducativo");
        String programaEducativoSeleccionado = "";
        DocenteEEProgramasDAO instance = new DocenteEEProgramasDAO();
        ArrayList<DocenteEEPrograma> expResult = null;
        ArrayList<DocenteEEPrograma> result = instance.consultarOfertaAcademicaPorProgramaEducativo(programaEducativoSeleccionado);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
