package uv.fei.tutorias.bussinesslogicTests;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Tutor;
import uv.fei.tutorias.bussinesslogicTests.TutorDAOTest;

public class TutorDAOTest {
    
    public TutorDAOTest() {
    }

    @Test
    public void testRegistrarTutor() {
        System.out.println("registrarTutor");
        TutorDAO tutorDAO = new TutorDAO();
        Tutor nuevoTutor = new Tutor();
        nuevoTutor.setNombre("efhwn");
        nuevoTutor.setCuentaUV("fvdfd");
        nuevoTutor.setPassword("ldvns");
        nuevoTutor.setApellidoPaterno("fuhd");
        nuevoTutor.setApellidoMaterno("fakbdso");
        nuevoTutor.setCorreo("fdsfsf");
        tutorDAO.registrarTutor(nuevoTutor);

        String cuentaUVBuscada = "fvdfd";
        ArrayList<Tutor> expResult = new ArrayList<>();
        Tutor tutorEsperado = new Tutor();
        tutorEsperado.setNombre("efhwn");
        tutorEsperado.setCuentaUV("fvdfd");
        tutorEsperado.setPassword("ldvns");
        tutorEsperado.setApellidoPaterno("fuhd");
        tutorEsperado.setApellidoMaterno("fuhd");
        tutorEsperado.setCorreo("fdsfsf");
        expResult.add(tutorEsperado);
        ArrayList<Tutor> result = (ArrayList<Tutor>) tutorDAO.consultarTutorPorCuentaUv(cuentaUVBuscada);
        assertEquals(expResult, result);
    }
        
    }
    
