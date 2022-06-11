/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class RegistrarFechasDeCierreParaLaEntregaDelReporteController implements Initializable {

    @FXML
    private ComboBox cbPeriodo;
    @FXML
    private DatePicker dpPrimeraSesion;
    @FXML
    private DatePicker dpSegundaSesion;
    @FXML
    private DatePicker dpTerceraSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelarRegistro(ActionEvent event) {
    }

    @FXML
    private void enviarInformacion(ActionEvent event) {
        registrarSesion(dpPrimeraSesion);
        registrarSesion(dpSegundaSesion);
        registrarSesion(dpTerceraSesion);
    }
    
    public void registrarSesion(DatePicker fechaReporte){
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String fecha = fechaReporte.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
        nuevaSesionTutoria.setFechaCierreReportes(fecha);
        //SesionTutoriaDAO.registrarCierreDeReporte(nuevaSesionTutoria);
    }
    
}
