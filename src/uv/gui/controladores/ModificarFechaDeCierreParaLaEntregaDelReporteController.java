package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
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
import uv.fei.tutorias.domain.Periodo;
import uv.fei.tutorias.domain.ProgramaEducativo;
import uv.mensajes.Alertas;
import static uv.mensajes.Alertas.mostrarAlertaErrorConexionDB;


public class ModificarFechaDeCierreParaLaEntregaDelReporteController implements Initializable {

    @FXML
    private TextField tfPeriodoActivo;
    @FXML
    private Text txtPrimeraTutoria;
    @FXML
    private DatePicker dpPrimeraSesion;
    @FXML
    private Text txtSegundaTutoria;
    @FXML
    private DatePicker dpSegundaSesion;
    @FXML
    private DatePicker dpTerceraSesion;
    @FXML
    private Text txtTerceraTutoria;
    @FXML
    private AnchorPane panelFechaDeCierreDelReporte;
    
    Stage stage;

    
    private Usuario usuarioActivo;
    private ProgramaEducativo programaEducativoActivo;
    
    public void recibirParametros(Usuario usuarioRecibido, ProgramaEducativo programaEducativo) throws SQLException{
        usuarioActivo = usuarioRecibido;
        programaEducativoActivo = programaEducativo;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo periodo = new Periodo();
        
        try {
            periodo = periodoDao.consultarPeriodoActivo();
            tfPeriodoActivo.setText(periodo.getFechaInicio()+ " - " + periodo.getFechaFin());
            tfPeriodoActivo.setEditable(false);
            //lblPeriodoActivo.setEnabled(false);
            
        } catch (SQLException ex) {
            mostrarAlertaErrorConexionDB();
            Logger.getLogger(RegistrarFechasDeSesionDeTutoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void guardarInformacion(ActionEvent event) {
    }

    @FXML
    private void cancelarModificacion(ActionEvent event) {
        /*
        Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.ERROR, "Cancelar", "Confirmar cancelar registro",
                "¿Esta seguro de que desea cancelar el registro?");
        if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) panelFechaDeCierreDelReporte.getScene().getWindow();
                stage.close();
        }*/
    }

}
