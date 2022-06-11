/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogicTests;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Periodo;

/**
 *
 * @author DMS19
 */
public class PeriodoDAOTest {
    
    public PeriodoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultarPeriodoTodosLosPeriodos method, of class PeriodoDAO.
     */
    @Test
    public void testConsultarPeriodoTodosLosPeriodos() {
        System.out.println("consultarPeriodoTodosLosPeriodos");
        PeriodoDAO instance = new PeriodoDAO();
        List<Periodo> expResult = null;
        List<Periodo> result = instance.consultarTodosLosPeriodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarPeriodo method, of class PeriodoDAO.
     */
    @Test
    public void testRegistrarPeriodo() {
        System.out.println("registrarPeriodo");
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo periodoNuevo = new Periodo();
        periodoNuevo.setFechaInicio("2022-03-09");
        periodoNuevo.setFechaFin("2022-03-09");
        periodoDao.registrarPeriodo(periodoNuevo);
    }

    /**
     * Test of eliminarPeriodoId method, of class PeriodoDAO.
     */
    @Test
    public void testEliminarPeriodoId() {
        System.out.println("eliminarPeriodoId");
        int idPeriodo = 0;
        PeriodoDAO instance = new PeriodoDAO();
        int expResult = 0;
        int result = instance.eliminarPeriodoId(idPeriodo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarPeriodo method, of class PeriodoDAO.
     */
    @Test
    public void testActualizarPeriodo() {
        System.out.println("actualizarPeriodo");
        Periodo periodo = null;
        PeriodoDAO instance = new PeriodoDAO();
        int expResult = 0;
        int result = instance.actualizarPeriodo(periodo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
