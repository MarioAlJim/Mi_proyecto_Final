/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogicTests;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.ProblematicaAcademicaDAO;
import static org.junit.Assert.*;

import uv.fei.tutorias.domain.Horario;
import uv.fei.tutorias.domain.ProblematicaAcademica;

/**
 *
 * @author SILVERWOLF
 */
public class ProblematicaAcademicaDAOConsultarTest {
    
    public ProblematicaAcademicaDAOConsultarTest() {
    }

    /*@Test
    public void testConsultarProblematicaPorIdExisto1() {
        System.out.println("Consultar problematica por id");
        ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ProblematicaAcademica problematicaEsperada = new ProblematicaAcademica();
        problematicaEsperada.setIdProblematicaAcademica(1);
        problematicaEsperada.setDescripcion("El maestro falta a clases");
        problematicaEsperada.setSolucion("Hablar con el maestro acerca del porqué falta");
        problematicaEsperada.setIdDocenteEePrograma(3);
        problematicasEsperadas.add(problematicaEsperada);
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) problematicaAcademicaDAO.consultarProblematicaPorId(1);
        for(ProblematicaAcademica problematicaAcademica : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademica  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }

    @Test
    public void testConsultarProblematicaPorIdExito2() {
        System.out.println("Consultar problematica por id");
        ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ProblematicaAcademica problematicaEsperada = new ProblematicaAcademica();
        problematicaEsperada.setIdProblematicaAcademica(7);
        problematicaEsperada.setDescripcion("El profesor no porporcionó la rubrica del proyecto");
        problematicaEsperada.setSolucion("");
        problematicaEsperada.setIdDocenteEePrograma(3);
        problematicaEsperada.setIdHorario(3);
        problematicasEsperadas.add(problematicaEsperada);
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) problematicaAcademicaDAO.consultarProblematicaPorId(7);
        for(ProblematicaAcademica problematicaAcademica : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademica  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }

    @Test
    public void testConsultarProblematicaPorIdFalla1() {
        System.out.println("Consultar problematica por id");
        ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ProblematicaAcademica problematicaEsperada = new ProblematicaAcademica();
        problematicaEsperada.setIdProblematicaAcademica(8);
        problematicaEsperada.setDescripcion("El profesor no porporcionó la rubrica del proyecto");
        problematicaEsperada.setSolucion("");
        problematicaEsperada.setIdDocenteEePrograma(3);
        problematicaEsperada.setIdHorario(3);
        problematicasEsperadas.add(problematicaEsperada);
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) problematicaAcademicaDAO.consultarProblematicaPorId(8);
        for(ProblematicaAcademica problematicaAcademica : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademica  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }

    @Test
    public void testConsultarProblematicaPorIdFalla2() {
        System.out.println("Consultar problematica por id");
        ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ProblematicaAcademica problematicaEsperada = new ProblematicaAcademica();
        problematicaEsperada.setIdProblematicaAcademica(9);
        problematicaEsperada.setDescripcion("La profesora no asignó correctamente equipos");
        problematicaEsperada.setSolucion("");
        problematicaEsperada.setIdDocenteEePrograma(1);
        problematicaEsperada.setIdHorario(3);
        problematicasEsperadas.add(problematicaEsperada);
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) problematicaAcademicaDAO.consultarProblematicaPorId(9);
        for(ProblematicaAcademica problematicaAcademica : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademica  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademica.getIdProblematicaAcademica(), problematicaAcademica.getDescripcion(),
                    problematicaAcademica.getSolucion(), problematicaAcademica.getIdDocenteEePrograma(), problematicaAcademica.getIdHorario()));
        }
        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }*/

}
