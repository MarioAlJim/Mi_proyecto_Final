/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogicTests;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.HorarioDAO;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Horario;

/**
 *
 * @author SILVERWOLF
 */
public class HorarioDAORegistroTest {
    
    public HorarioDAORegistroTest() {
    }

    /*@Test
    public void testRegistrarHorarioExistosa1() {
        System.out.println("registrarHorario");
        HorarioDAO horarioDAO = new HorarioDAO();
        Horario horarionuevo = new Horario();
        horarionuevo.setHora("2022-03-09 11:45:00.0");
        horarionuevo.setIdTutoria(3);
        horarionuevo.setMatricula("s20078908");
        horarioDAO.registrarHorario(horarionuevo);

        int idHorarioBuscado = 10;
        ArrayList<Horario> expResult = new ArrayList<>();
        Horario horarioEsperado = new Horario();
        horarioEsperado.setIdHorario(10);
        horarioEsperado.setHora("2022-03-09 11:45:00.0");
        horarioEsperado.setIdTutoria(3);
        horarioEsperado.setMatricula("s20078908");
        expResult.add(horarioEsperado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegistrarHorarioExitosa2() {
        System.out.println("registrarHorario");
        HorarioDAO horarioDAO = new HorarioDAO();
        Horario horarionuevo = new Horario();
        horarionuevo.setHora("2022-03-09 12:15:00.0");
        horarionuevo.setIdTutoria(3);
        horarionuevo.setMatricula("z20067806");
        horarioDAO.registrarHorario(horarionuevo);

        int idHorarioBuscado = 11;
        ArrayList<Horario> expResult = new ArrayList<>();
        Horario horarioEsperado = new Horario();
        horarioEsperado.setIdHorario(11);
        horarioEsperado.setHora("2022-03-09 12:15:00.0");
        horarioEsperado.setIdTutoria(3);
        horarioEsperado.setMatricula("z20067806");
        expResult.add(horarioEsperado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        assertEquals(expResult, result);
    }*/
    
}
