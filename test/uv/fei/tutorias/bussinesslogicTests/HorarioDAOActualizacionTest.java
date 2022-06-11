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
public class HorarioDAOActualizacionTest {
    
    public HorarioDAOActualizacionTest() {
    }

  /*  @Test
    public void testActualizarHorarioExisoto1() {
        HorarioDAO horarioDAO = new HorarioDAO();
        Horario horarioactualizado = new Horario();
        horarioactualizado.setIdHorario(8);
        horarioactualizado.setHora("2022-03-09 07:30:00.0");
        horarioactualizado.setIdTutoria(3);
        horarioactualizado.setMatricula("s20015692");
        horarioDAO.actualizarHorario(horarioactualizado);

        int idHorarioBuscado = 8;
        ArrayList<Horario> expResult = new ArrayList<>();
        expResult.add(horarioactualizado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals(expResult, result);
    }


    @Test
    public void testActualizarHorarioExitoso2() {
        HorarioDAO horarioDAO = new HorarioDAO();
        Horario horarioactualizado = new Horario();
        horarioactualizado.setIdHorario(8);
        horarioactualizado.setHora("2022-03-09 10:30:00.0");
        horarioactualizado.setIdTutoria(3);
        horarioactualizado.setMatricula("s20015736");
        horarioDAO.actualizarHorario(horarioactualizado);

        int idHorarioBuscado = 8;
        ArrayList<Horario> expResult = new ArrayList<>();
        expResult.add(horarioactualizado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testActualizarHorarioExitoso3() {
        HorarioDAO horarioDAO = new HorarioDAO();
        Horario horarioactualizado = new Horario();
        horarioactualizado.setIdHorario(8);
        horarioactualizado.setHora("2022-03-09 11:30:00.0");
        horarioactualizado.setIdTutoria(3);
        horarioactualizado.setMatricula("S20015752");
        horarioDAO.actualizarHorario(horarioactualizado);

        int idHorarioBuscado = 8;
        ArrayList<Horario> expResult = new ArrayList<>();
        expResult.add(horarioactualizado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals(expResult, result);
    }*/
}
