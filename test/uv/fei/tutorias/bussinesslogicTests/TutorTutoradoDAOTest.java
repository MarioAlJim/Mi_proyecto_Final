/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogicTests;

import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.TutorTutoradoDAO;
import static org.junit.Assert.*;

/**
 *
 * @author Valea
 */
public class TutorTutoradoDAOTest {
    
    public TutorTutoradoDAOTest() {
    }

    /**
     * Test of asignarTutorTutorado method, of class TutorTutoradoDAO.
     */
    @Test
    public void testAsignarTutorTutorado() {
       // System.out.println("eliminarProblematica");
        
        TutorTutoradoDAO instance = new TutorTutoradoDAO();
        int expResult = 1;
        String cuenta="maria";
        String matricula="S208998";
        int result = instance.asignarTutorTutorado(cuenta, matricula);
        assertEquals(expResult, result);
    }

     
    @Test
    public void testConsultarTutoresTutoradosporId() {
    }
    
}
