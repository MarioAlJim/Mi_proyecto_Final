package uv.gui.controladores;

import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javax.swing.JOptionPane;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.Periodo;
import uv.fei.tutorias.domain.SesionTutoria;

public class RegistrarFechasDeSesionDeTutoriaController {

    @FXML
    private DatePicker dpPeriodoFin;

    @FXML
    private DatePicker dpPeriodoInicio;

    @FXML
    private DatePicker dpPrimeraSesion;

    @FXML
    private DatePicker dpSegundaSesion;

    @FXML
    private DatePicker dpTerceraSesion;
    @FXML
    private ComboBox cbNumeroTutoria1;
    @FXML
    private ComboBox cbNumeroTutoria2;
    @FXML
    private ComboBox cbNumeroTutoria3;

    @FXML
    void CancelarRegistro(ActionEvent event) {

    }

    @FXML
    void enviar(ActionEvent event) {
        
        // Registramos el periodo
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo nuevoPeriodo = new Periodo();
        
        String periodoInicio = dpPeriodoInicio.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String periodoFin = dpPeriodoFin.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        nuevoPeriodo.setFechaInicio(periodoInicio);
        nuevoPeriodo.setFechaFin(periodoFin);
        
        periodoDao.registrarPeriodo(nuevoPeriodo);
        
        
        // Registramos las fechas de sesión
        registrarSesion(dpPrimeraSesion);
        registrarSesion(dpSegundaSesion);
        registrarSesion(dpTerceraSesion);
    }
    
    public void registrarSesion(DatePicker fechaTutoria){
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String fecha = fechaTutoria.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
        nuevaSesionTutoria.setFechaTutoria(fecha);
        //SesionTutoriaDAO.registrarSesionTutoria(nuevaSesionTutoria);
    }

}