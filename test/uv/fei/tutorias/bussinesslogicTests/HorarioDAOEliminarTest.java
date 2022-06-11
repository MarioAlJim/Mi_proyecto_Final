/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogicTests;

import java.util.List;
import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.HorarioDAO;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Horario;

/**
 *
 * @author SILVERWOLF
 */
public class HorarioDAOEliminarTest {
    
    public HorarioDAOEliminarTest() {
    }

    @Test
    public void testEliminarHorario() {
        System.out.println("eliminarHorario");
        int idHorario = 10;
        HorarioDAO instance = new HorarioDAO();
        int expResult = 1;
        int result = instance.eliminarHorario(idHorario);
        assertEquals(expResult, result);
    }

    @Test
    public void testEliminarHorario2() {
        System.out.println("eliminarHorario");
        int idHorario = 11;
        HorarioDAO instance = new HorarioDAO();
        int expResult = 1;
        int result = instance.eliminarHorario(idHorario);
        assertEquals(expResult, result);
    }

    @Test
    public void testEliminarHorarioFallido() {
        System.out.println("eliminarHorario");
        int idHorario = 2;
        HorarioDAO instance = new HorarioDAO();
        int expResult = 1;
        int result = instance.eliminarHorario(idHorario);
        assertEquals(expResult, result);
    }

    @Test
    public void testEliminarHorarioFallido2() {
        System.out.println("eliminarHorario");
        int idHorario = 1;
        HorarioDAO instance = new HorarioDAO();
        int expResult = 1;
        int result = instance.eliminarHorario(idHorario);
        assertEquals(expResult, result);
    }
    
}
