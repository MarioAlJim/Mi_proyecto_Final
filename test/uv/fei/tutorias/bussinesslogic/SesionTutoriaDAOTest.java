/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 *
 * @author SILVERWOLF
 */
public class SesionTutoriaDAOTest {
    
    public SesionTutoriaDAOTest() {
    }


    @Test
    public void testConsultarTutoriaPorPeriodo() throws SQLException {
        System.out.println("consultarTutoriaPorPeriodo");
        int idPeriodo = 10;
        SesionTutoriaDAO instance = new SesionTutoriaDAO();
        ArrayList<SesionTutoria> expResult = null;
        ArrayList<SesionTutoria> result = instance.consultarTutoriaPorPeriodo(idPeriodo);
        for (SesionTutoria sesionTutoria : result) {
            System.out.println(String.format("Id: %s, num tutoria: %s, fecha cierre: %s", sesionTutoria.getIdSesionTutoria(), sesionTutoria.getNumTutoria(), sesionTutoria.getFechaTutoria()));
        }
        assertEquals(result, result);
    }
    
}
