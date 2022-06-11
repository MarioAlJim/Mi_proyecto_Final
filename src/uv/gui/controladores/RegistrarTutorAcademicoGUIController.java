/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import uv.fei.tutorias.domain.Tutor;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class RegistrarTutorAcademicoGUIController implements Initializable {

    @FXML
    private TextField tfCuenta;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfApellidoMaterno;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button btGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enviarInformacion(ActionEvent event) {
        
            TutorDAO nuevoTutorDAO = new TutorDAO();
            Tutor nuevoTutor = new Tutor();
           
                nuevoTutor.setCuentaUV(tfCuenta.getText());
                nuevoTutor.setNombre(tfNombre.getText());
                nuevoTutor.setApellidoPaterno(tfApellidoPaterno.getText());
                nuevoTutor.setApellidoMaterno(tfApellidoMaterno.getText());
                nuevoTutor.setCorreo(tfCorreo.getText());
                nuevoTutor.setPassword(tfPassword.getText());
                
                nuevoTutorDAO.registrarTutor(nuevoTutor);
                
                JOptionPane.showMessageDialog(null, "Tutor registrado");
                
                
        
    }
    
}
