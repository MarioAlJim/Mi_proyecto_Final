package uv.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import uv.fei.tutorias.bussinesslogic.HorarioDAO;
import uv.fei.tutorias.domain.Usuario;
import uv.fei.tutorias.bussinesslogic.UsuarioDAO;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.mensajes.Alertas;

public class InicioSesionGUIController implements Initializable {
    
    InicioSesionGUIController inicioSesionGUIController;
    
    @FXML
    private Label lblContrasena;
    @FXML
    private PasswordField txtContrasenia;
    @FXML
    private Label lblUsuario;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Label txtTitulo;
    @FXML
    private ImageView imgLogo;
    @FXML
    private Label lblUsuarioInvalido;
    @FXML
    private Label lblContrasenaInavlida;
    @FXML
    private Button btnSalir;

    final static Logger log = Logger.getLogger(HorarioDAO.class);

    private void validarUsuarioBD(String cuentaUV, String contrasena) throws IOException {
        Alertas alertas = new Alertas();
        try{
            UsuarioDAO userDAO = new UsuarioDAO();
            Usuario usuarioRecuperado = userDAO.recuperarSesion(cuentaUV, contrasena);
            if(usuarioRecuperado != null){
                switch(usuarioRecuperado.getRol()) {
                    case 1:
                        break;
                    case 2:
                        break;

                    case 3:
                        break;

                    case 4:
                        llamarMenuTutor(usuarioRecuperado);
                        break;
                    default:
                        break;
                }
            }else{
                alertas.mostrarAlertaUsuarioIncorrecto();
            }
        }catch (SQLException exception) {
          log.fatal(exception);
           alertas.mostrarAlertaErrorConexionDB();
        }              
    }

    private void llamarMenuTutor(Usuario usuarioRecuperado) throws IOException{
        Stage stageMenuTutor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/MenuTutorGUI.fxml").openStream());
        MenuTutorGUIController menuTutorGUIController = (MenuTutorGUIController) loader.getController();
        menuTutorGUIController.recibirParametros(usuarioRecuperado);
        Scene scene = new Scene(root);
        stageMenuTutor.setScene(scene);
        stageMenuTutor.setTitle("Menu de tutores");
        stageMenuTutor.alwaysOnTopProperty();
        stageMenuTutor.initModality(Modality.APPLICATION_MODAL);
        stageMenuTutor.show();

        Stage stageActual = (Stage)lblUsuario.getScene().getWindow();
        Stage stage = (Stage) stageActual.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        URL linkLogo = getClass().getResource("/uv/fei/tutorias/img/logoUV.png");
        Image imagePdf = new Image(linkLogo.toString());
        imgLogo.setImage(imagePdf);

    }    

    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException{
        String cuentaUV = txtUsuario.getText();
        String contrasena = txtContrasenia.getText();
        if(cuentaUV.isEmpty()){
            lblUsuarioInvalido.setVisible(true);
        }else if(contrasena.isEmpty()){
            lblContrasenaInavlida.setVisible(true);
        }else {
            lblContrasenaInavlida.setVisible(false);
            lblUsuarioInvalido.setVisible(false);
            validarUsuarioBD(cuentaUV, contrasena);
        }
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
