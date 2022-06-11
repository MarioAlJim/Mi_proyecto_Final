/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogicTests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.ProblematicaAcademicaDAO;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.ProblematicaAcademica;

/**
 *
 * @author SILVERWOLF
 */
public class ProblematicaAcademicaDAORegistrarTest {
    
    public ProblematicaAcademicaDAORegistrarTest() {
    }

    /*@Test
    public void testRegistrarProblematicaAcademicaExito1() throws SQLException {
        System.out.println("registrarProblematicaAcademica");
        ProblematicaAcademicaDAO instance = new ProblematicaAcademicaDAO();
        ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
        problematicaAcademica.setDescripcion("El profesor no explica las tareas");
        problematicaAcademica.setSolucion("");
        problematicaAcademica.setIdDocenteEePrograma(2);
        problematicaAcademica.setIdHorario(9);
        instance.registrarProblematicaAcademica(problematicaAcademica);

        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) instance.consultarProblematicaPorId(19);
        problematicaAcademica.setIdProblematicaAcademica(19);
        problematicasEsperadas.add(problematicaAcademica);
        assertEquals("", problematicasEsperadas, problematicasAcademicas);

        for(ProblematicaAcademica problematicaAcademicaesp : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademicaesp.getIdProblematicaAcademica(), problematicaAcademicaesp.getDescripcion(),
                    problematicaAcademicaesp.getSolucion(), problematicaAcademicaesp.getIdDocenteEePrograma(), problematicaAcademicaesp.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademicares  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademicares.getIdProblematicaAcademica(), problematicaAcademicares.getDescripcion(),
                    problematicaAcademicares.getSolucion(), problematicaAcademicares.getIdDocenteEePrograma(), problematicaAcademicares.getIdHorario()));
        }

    }


    @Test
    public void testRegistrarProblematicaAcademicaExito2() throws SQLException {
        System.out.println("registrarProblematicaAcademica");
        ProblematicaAcademicaDAO instance = new ProblematicaAcademicaDAO();
        ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
        problematicaAcademica.setIdProblematicaAcademica(20);
        problematicaAcademica.setDescripcion("El profesor va muy lento en los temas");
        problematicaAcademica.setSolucion("");
        problematicaAcademica.setIdDocenteEePrograma(4);
        problematicaAcademica.setIdHorario(9);
        instance.registrarProblematicaAcademica(problematicaAcademica);

        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) instance.consultarProblematicaPorId(20);
        problematicasEsperadas.add(problematicaAcademica);

        for(ProblematicaAcademica problematicaAcademicaesp : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademicaesp.getIdProblematicaAcademica(), problematicaAcademicaesp.getDescripcion(),
                    problematicaAcademicaesp.getSolucion(), problematicaAcademicaesp.getIdDocenteEePrograma(), problematicaAcademicaesp.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademicares  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademicares.getIdProblematicaAcademica(), problematicaAcademicares.getDescripcion(),
                    problematicaAcademicares.getSolucion(), problematicaAcademicares.getIdDocenteEePrograma(), problematicaAcademicares.getIdHorario()));
        }

        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }

    @Test
    public void testRegistrarProblematicaAcademicaFalla1() throws SQLException {
        System.out.println("registrarProblematicaAcademica");
        ProblematicaAcademicaDAO instance = new ProblematicaAcademicaDAO();
        ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();

        problematicaAcademica.setIdProblematicaAcademica(21);
        problematicaAcademica.setDescripcion("La profesora no termina su clase a la hora del horario");
        problematicaAcademica.setSolucion("");
        problematicaAcademica.setIdDocenteEePrograma(4);
        problematicaAcademica.setIdHorario(8);
        instance.registrarProblematicaAcademica(problematicaAcademica);

        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) instance.consultarProblematicaPorId(21);
        ProblematicaAcademica problematicaEsperada = new ProblematicaAcademica();
        problematicaEsperada.setIdProblematicaAcademica(21);
        problematicaEsperada.setDescripcion("La Profesora no termina su clase a la hora del horario");
        problematicaEsperada.setSolucion("");
        problematicaEsperada.setIdDocenteEePrograma(2);
        problematicaEsperada.setIdHorario(8);
        problematicasEsperadas.add(problematicaEsperada);

        for(ProblematicaAcademica problematicaAcademicaesp : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademicaesp.getIdProblematicaAcademica(), problematicaAcademicaesp.getDescripcion(),
                    problematicaAcademicaesp.getSolucion(), problematicaAcademicaesp.getIdDocenteEePrograma(), problematicaAcademicaesp.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademicares  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademicares.getIdProblematicaAcademica(), problematicaAcademicares.getDescripcion(),
                    problematicaAcademicares.getSolucion(), problematicaAcademicares.getIdDocenteEePrograma(), problematicaAcademicares.getIdHorario()));
        }

        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }

    @Test
    public void testRegistrarProblematicaAcademicaFalla2() throws SQLException {
        System.out.println("registrarProblematicaAcademica");
        ProblematicaAcademicaDAO instance = new ProblematicaAcademicaDAO();
        ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();

        problematicaAcademica.setIdProblematicaAcademica(22);
        problematicaAcademica.setDescripcion("La profesora no soluciona dudas acerca del proyecto");
        problematicaAcademica.setSolucion("");
        problematicaAcademica.setIdDocenteEePrograma(1);
        problematicaAcademica.setIdHorario(7);
        instance.registrarProblematicaAcademica(problematicaAcademica);

        ArrayList<ProblematicaAcademica> problematicasEsperadas = new ArrayList<>();
        ArrayList<ProblematicaAcademica> problematicasAcademicas =
                (ArrayList<ProblematicaAcademica>) instance.consultarProblematicaPorId(22);
        ProblematicaAcademica problematicaEsperada = new ProblematicaAcademica();
        problematicaEsperada.setIdProblematicaAcademica(22);
        problematicaEsperada.setDescripcion("La Profesora no soluciona dudas acerca del proyecto");
        problematicaEsperada.setSolucion("");
        problematicaEsperada.setIdDocenteEePrograma(1);
        problematicaEsperada.setIdHorario(7);
        problematicasEsperadas.add(problematicaEsperada);

        for(ProblematicaAcademica problematicaAcademicaesp : problematicasAcademicas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademicaesp.getIdProblematicaAcademica(), problematicaAcademicaesp.getDescripcion(),
                    problematicaAcademicaesp.getSolucion(), problematicaAcademicaesp.getIdDocenteEePrograma(), problematicaAcademicaesp.getIdHorario()));
        }
        for(ProblematicaAcademica problematicaAcademicares  : problematicasEsperadas){
            System.out.println(String.format("Id: %s, Descripcion: %s, Solucion: %s, Experiencia: %s, Horario: %s", problematicaAcademicares.getIdProblematicaAcademica(), problematicaAcademicares.getDescripcion(),
                    problematicaAcademicares.getSolucion(), problematicaAcademicares.getIdDocenteEePrograma(), problematicaAcademicares.getIdHorario()));
        }

        assertEquals("", problematicasEsperadas, problematicasAcademicas);
    }


*/
    
}
