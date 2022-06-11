/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.ProblematicaAcademica;
import uv.fei.tutorias.domain.ProblematicaReporte;

/**
 *
 * @author SILVERWOLF
 */
public class ProblematicaAcademicaDAO2Test {
    
    public ProblematicaAcademicaDAO2Test() {
    }

    @Test
    public void testConsultarTodasLasProblematicasPorProgramaEducativoCuenta() throws Exception {
        System.out.println("consultarTodasLasProblematicasPorProgramaEducativoCuenta");
        int idProgramaEducativo = 0;
        String cuentaUv = "arivera";
        ProblematicaAcademicaDAO instance = new ProblematicaAcademicaDAO();
        ArrayList<ProblematicaReporte> expResult = null;
        ArrayList<ProblematicaReporte> result = instance.consultarTodasLasProblematicasPorProgramaEducativoCuenta(idProgramaEducativo, cuentaUv);
        assertEquals(expResult, result);
    }

    
}
