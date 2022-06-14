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


public class ModificarFechasDeSesionDeTutoriaController implements Initializable {

    @FXML
    private DatePicker dpPrimeraSesion;
    @FXML
    private DatePicker dpSegundaSesion;
    @FXML
    private DatePicker dpTerceraSesion;
    @FXML
    private AnchorPane panelModificarSesionTutoria;
    @FXML
    private TextField tfPeriodoActivo;
    @FXML
    private Text txtPrimeraTutoria;
    @FXML
    private Text txtSegundaTutoria;
    @FXML
    private Text txtTerceraTutoria;
    
    Stage stage;
    
    private Usuario usuarioActivo;
    private ProgramaEducativo programaEducativoActivo;
    
    public void recibirParametros(Usuario usuarioRecibido, ProgramaEducativo programaEducativo) throws SQLException{
        usuarioActivo = usuarioRecibido;
        programaEducativoActivo = programaEducativo;
    }
    

    /**
     * Initializes the controller class.
     */
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
    private void guardarInformacion(ActionEvent event) throws SQLException {
        
        modificarSesion(dpPrimeraSesion, txtPrimeraTutoria);
        modificarSesion(dpSegundaSesion, txtSegundaTutoria);
        modificarSesion(dpTerceraSesion, txtTerceraTutoria);
        
        
    }
    
    public void modificarSesion(DatePicker fechaTutoria, Text numeroTutoria) throws SQLException{
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo periodo = new Periodo();
        periodo = periodoDao.consultarPeriodoActivo();
        int idPeriodo = periodo.getIdPeriodo();
        
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
        String fecha = fechaTutoria.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        nuevaSesionTutoria.setFechaTutoria(fecha);
        
        String numTutoria = numeroTutoria.getText();
        
        System.out.println("IdPeriodo "+ idPeriodo + "NumTutoria "+ numTutoria);
        
        try{
        SesionTutoriaDAO.actualizarFechasDeSesionTutoria(nuevaSesionTutoria, idPeriodo, numTutoria);
        }catch(SQLException e){
            mostrarAlertaErrorConexionDB();
        }
        
    }

    @FXML
    private void cancelarModificacion(ActionEvent event) {
        /*Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.ERROR, "Cancelar", "Confirmar cancelar registro",
                "¿Esta seguro de que desea cancelar el registro?");
        if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) panelModificarSesionTutoria.getScene().getWindow();
                stage.close();
        }*/
    }
    
}
