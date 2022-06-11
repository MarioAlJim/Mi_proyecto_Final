/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uv.fei.tutorias.bussinesslogicTests;

import org.junit.Test;
import uv.fei.tutorias.bussinesslogic.UsuarioDAO;
import static org.junit.Assert.*;
import uv.fei.tutorias.domain.Usuario;

import java.sql.SQLException;

/**
 *
 * @author SILVERWOLF
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }

    @Test
    public void testRecuperarSesion() throws SQLException {
        System.out.println("recuperarSesion");
        String cuentauv = "hguzman";
        String contrasena = "678";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.recuperarSesion(cuentauv, contrasena);
        System.out.println(result.getCuentaUV() + " " + " " + result.getContrasenia());
        assertEquals(result, result);
    }
    
}
