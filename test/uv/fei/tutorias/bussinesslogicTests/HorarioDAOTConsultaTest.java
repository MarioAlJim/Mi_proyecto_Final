
package uv.fei.tutorias.bussinesslogicTests;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.HorarioDAO;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Horario;

public class HorarioDAOTConsultaTest {
    
    public HorarioDAOTConsultaTest() {
    }
    
   /* @Test
    public void testConsultarHorarioporIdExitoso1() {
        System.out.println("consultarHorarioporId");
        int idHorarioBuscado = 4;
        HorarioDAO horarioDAO = new HorarioDAO();
        ArrayList<Horario> expResult = new ArrayList<>();
        Horario horarioEsperado = new Horario();
        horarioEsperado.setIdHorario(4);
        horarioEsperado.setHora("2002-03-09 09:00:00.0");
        horarioEsperado.setIdTutoria(3);
        horarioEsperado.setMatricula("S20015736");
        expResult.add(horarioEsperado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals("", expResult, result);
    }

    @Test
    public void testConsultarHorarioporIdFalla1() {
        System.out.println("consultarHorarioporId");
        int idHorarioBuscado = 3;
        HorarioDAO horarioDAO = new HorarioDAO();
        ArrayList<Horario> expResult = new ArrayList<>();
        Horario horarioEsperado = new Horario();
        horarioEsperado.setIdHorario(3);
        horarioEsperado.setHora("2002-03-09 08:30:00.0");
        horarioEsperado.setIdTutoria(3);
        horarioEsperado.setMatricula("S20015692");
        expResult.add(horarioEsperado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals("", expResult, result);
    }

    @Test
    public void testConsultarHorarioporIdExitoso2() {
        System.out.println("consultarHorarioporId");
        int idHorarioBuscado = 7;
        HorarioDAO horarioDAO = new HorarioDAO();
        ArrayList<Horario> expResult = new ArrayList<>();
        Horario horarioEsperado = new Horario();
        horarioEsperado.setIdHorario(7);
        horarioEsperado.setHora("2022-03-09 10:00:00.0");
        horarioEsperado.setIdTutoria(3);
        horarioEsperado.setMatricula("s20015742");
        expResult.add(horarioEsperado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals("", expResult, result);
    }

    @Test
    public void testConsultarHorarioporIdFalla2() {
        System.out.println("consultarHorarioporId");
        int idHorarioBuscado = 7;
        HorarioDAO horarioDAO = new HorarioDAO();
        ArrayList<Horario> expResult = new ArrayList<>();
        Horario horarioEsperado = new Horario();
        horarioEsperado.setIdHorario(7);
        horarioEsperado.setHora("2022-03-09 10:00:00.0");
        horarioEsperado.setIdTutoria(3);
        horarioEsperado.setMatricula("S20015742");
        expResult.add(horarioEsperado);
        ArrayList<Horario> result = (ArrayList<Horario>) horarioDAO.consultarHorarioporId(idHorarioBuscado);
        for(Horario horario : result){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        for(Horario horario : expResult){
            System.out.println(String.format("%s %s %s", horario.getHora(), horario.getIdTutoria(), horario.getMatricula()));
        }
        assertEquals("", expResult, result);
    }*/
    
}
