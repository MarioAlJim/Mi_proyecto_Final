/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;
import uv.fei.tutorias.bussinesslogic.SolucionesProblematicaAcademicaDAO;
import uv.fei.tutorias.domain.ProblematicaAcademica;

/**
 * FXML Controller class
 *
 * @author Valea
 */
public class CU21RegistrarSoluciónAProblemáticaAcadémicaController implements Initializable {

    @FXML
    private TextArea txtSolucon;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCerrar;
    private TextField btnProblematica;
    @FXML
    private TextField txtEE;
    @FXML
    private TextField txtDocente;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtProblematica;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        llenarCampos();
        
        
    }    
    
    
    
    @FXML
    private void clickEvento(ActionEvent event) {
        
       // btnRegistrar.setText("Hola");
       String solucion= txtSolucon.getText();
       SolucionesProblematicaAcademicaDAO instance = new SolucionesProblematicaAcademicaDAO();
       instance.registrarSolucion(solucion,13);
       JOptionPane.showMessageDialog(null, "Solución agregada correctamente");
        
    }
    
    private void llenarCampos(){
       SolucionesProblematicaAcademicaDAO instance = new SolucionesProblematicaAcademicaDAO();
       ProblematicaAcademica problematica = new ProblematicaAcademica();
       problematica= instance.consultarProblematica(13);
       txtProblematica.setText(problematica.getDescripcion());
       
       txtDocente.setText("Maria de los Angeles");
       txtEE.setText("Requerimientos de Software");
       txtFecha.setText("05 de mayo");
      
       
    }
    
}
