
package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import uv.fei.tutorias.domain.ProgramaEducativo;
import uv.fei.tutorias.domain.Tutor;
import static uv.mensajes.Alertas.mostrarAlertaCamposVacios;
import static uv.mensajes.Alertas.mostrarAlertaErrorConexionDB;


public class RegistrarTutorAcademicoGUIController implements Initializable {

    @FXML
    private Button btGuardar;

    @FXML
    private TextField tfApellidoMaterno;

    @FXML
    private TextField tfApellidoPaterno;

    @FXML
    private TextField tfCorreo;

    @FXML
    private TextField tfCuenta;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfPassword;

    Stage stage;
    @FXML
    private AnchorPane panelTutor;
    final static Logger log = Logger.getLogger(RegistrarTutorAcademicoGUIController.class);
    private Usuario usuarioActivo;
    private ProgramaEducativo programaEducativoActivo;
    
    public void recibirParametros(Usuario usuarioRecibido, ProgramaEducativo programaEducativo) throws SQLException{
        usuarioActivo = usuarioRecibido;
        programaEducativoActivo = programaEducativo;
    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void enviarInformacion(ActionEvent event) {
        if (tfCuenta.getText().equals("") || tfNombre.getText().equals("") || tfApellidoPaterno.getText().equals("") || tfApellidoMaterno.getText().equals("") || tfCorreo.getText().equals("") || tfPassword.getText().equals("") || tfCuenta.getText().equals("")) {
                mostrarAlertaCamposVacios();

            } else {

        
                TutorDAO nuevoTutorDAO = new TutorDAO();
                Tutor nuevoTutor = new Tutor();
                nuevoTutor.setCuentaUV(tfCuenta.getText());
                nuevoTutor.setNombreTutor(tfNombre.getText());
                nuevoTutor.setApellidoPaternoTutor(tfApellidoPaterno.getText());
                nuevoTutor.setApellidoMaternoTutor(tfApellidoMaterno.getText());
                nuevoTutor.setCorreo(tfCorreo.getText());
                nuevoTutor.setPassword(tfPassword.getText());
                try {
                nuevoTutorDAO.registrarTutor(nuevoTutor);
                /*Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.INFORMATION, "Información registrada", 
                        "Se a registrado con éxito la información", null);
                if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) panelTutor.getScene().getWindow();
                stage.close();
                }*/
                
                } catch (SQLException e) {
                    mostrarAlertaErrorConexionDB();
            }
            }
            
    
    }
    
        

    @FXML
    private void btnCancelar(ActionEvent event) {
        /*Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.ERROR, "Cancelar", "Confirmar cancelar registro",
                "¿Esta seguro de que desea cancelar el registro?");
        if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) panelTutor.getScene().getWindow();
                stage.close();
        }*/
    }
   
}