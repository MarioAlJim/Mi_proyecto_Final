package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.Periodo;
import uv.fei.tutorias.domain.ProgramaEducativo;
import uv.fei.tutorias.domain.SesionTutoria;
import uv.mensajes.Alertas;
import static uv.mensajes.Alertas.mostrarAlertaErrorConexionDB;

public class RegistrarFechasDeSesionDeTutoriaController implements Initializable{

  
    @FXML
    private DatePicker dpPrimeraSesion;

    @FXML
    private DatePicker dpSegundaSesion;

    @FXML
    private DatePicker dpTerceraSesion;
    
    @FXML
    private AnchorPane panelFechaSesionTutoria;
    @FXML
    private Text tfPrimeraTutoria;
    @FXML
    private Text tfSegundaTutoria;
    @FXML
    private Text tfTerceraTutoria;
    @FXML
    private TextField lblPeriodoActivo;
    
    Stage stage;
    
    private Usuario usuarioActivo;
    private ProgramaEducativo programaEducativoActivo;
    
    public void recibirParametros(Usuario usuarioRecibido, ProgramaEducativo programaEducativo) throws SQLException{
        usuarioActivo = usuarioRecibido;
        programaEducativoActivo = programaEducativo;
    }

    @FXML
    void CancelarRegistro(ActionEvent event) {
        /*Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.ERROR, "Cancelar", "Confirmar cancelar registro",
                "¿Esta seguro de que desea cancelar el registro?");
        if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) panelFechaSesionTutoria.getScene().getWindow();
                stage.close();
        }*/
    }
    

    @FXML
    void enviar(ActionEvent event) throws SQLException{
        
        registrarSesion(dpPrimeraSesion, tfPrimeraTutoria);
        registrarSesion(dpSegundaSesion, tfSegundaTutoria);
        registrarSesion(dpTerceraSesion, tfTerceraTutoria);
        
    }

    
    public void registrarSesion(DatePicker fechaTutoria, Text numeroTutoria) throws SQLException{
        
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo periodo = new Periodo();
        periodo = periodoDao.consultarPeriodoActivo();
        int idPeriodo = periodo.getIdPeriodo();
        
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String fecha = fechaTutoria.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        nuevaSesionTutoria.setFechaTutoria(fecha);
        nuevaSesionTutoria.setNumTutoria(numeroTutoria.getText());
        nuevaSesionTutoria.setIdPeriodo(idPeriodo);
        try{
        SesionTutoriaDAO.registrarSesionTutoria(nuevaSesionTutoria);
        }catch(SQLException e){
            mostrarAlertaErrorConexionDB();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo periodo = new Periodo();
        
        try {
            periodo = periodoDao.consultarPeriodoActivo();
            lblPeriodoActivo.setText(periodo.getFechaInicio()+ " - " + periodo.getFechaFin());
            lblPeriodoActivo.setEditable(false);
            //lblPeriodoActivo.setEnabled(false);
            
        } catch (SQLException ex) {
            mostrarAlertaErrorConexionDB();
            Logger.getLogger(RegistrarFechasDeSesionDeTutoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}