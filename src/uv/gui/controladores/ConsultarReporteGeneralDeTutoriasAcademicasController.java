package uv.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.ProgramaEducativo;
import uv.fei.tutorias.domain.SesionTutoria;


public class ConsultarReporteGeneralDeTutoriasAcademicasController implements Initializable {

    @FXML
    private TableColumn colIdPeriodo;
    @FXML
    private TableView tableReporteGeneral;
    @FXML
    private TableColumn colPeriodo;
    @FXML
    private TableColumn colNumeroDeTutoria;
    @FXML
    private TableColumn colFecha;
    @FXML
    private TextField tfBuscarPeriodo;
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
        try {
            this.inicializarTablaReporteGeneral();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarReporteGeneralDeTutoriasAcademicasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickDetallesReporte(MouseEvent event) throws IOException {
        if(event.getClickCount() == 2){
            getTablaSesionTutoriaSeleccionado();
        }
    }
   
    private void abrirPantallaDetalleDelReporte(SesionTutoria sesionSeleccionada) throws IOException {
        
        Stage ventanaPrincipal = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent escenario = loader.load(getClass().getResource("/uv/gui/interfaces/DetalleReporteGeneral.fxml").openStream());

        DetalleReporteGeneralController detalles = loader.getController();
        detalles.configurarEscena(sesionSeleccionada);
        Scene scene = new Scene(escenario);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("Detalles Tutor");
        ventanaPrincipal.initModality(Modality.APPLICATION_MODAL);
        ventanaPrincipal.show();

        Stage stageActual = (Stage) tfBuscarPeriodo.getScene().getWindow();
        Stage stage = (Stage) stageActual.getScene().getWindow();
        stage.close();

    }


    public void getTablaSesionTutoriaSeleccionado() throws IOException {
        if (tableReporteGeneral != null) {
            List<SesionTutoria> tabla = tableReporteGeneral.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                SesionTutoria sesionTutoriaSeleccionado = tabla.get(0);
                
                abrirPantallaDetalleDelReporte(sesionTutoriaSeleccionado);
            } else {
                //Mande el mensaje de conexión de BD
            }
        }
        
    }
    
    
    private void inicializarTablaReporteGeneral() throws SQLException{
        colPeriodo.setCellValueFactory(new PropertyValueFactory <SesionTutoria, String>("fechaCompleta"));
        colNumeroDeTutoria.setCellValueFactory(new PropertyValueFactory <SesionTutoria, String>("numTutoria"));
        colFecha.setCellValueFactory(new PropertyValueFactory <SesionTutoria, String>("fechaTutoria"));

        SesionTutoriaDAO sesionTutoriaDao = new SesionTutoriaDAO();
        ArrayList<SesionTutoria> sesiones;
        sesiones = (ArrayList<SesionTutoria>) sesionTutoriaDao.consultarTodosLasSesiones();

        ObservableList<SesionTutoria> tablaSesiones = FXCollections.observableArrayList();
        for (SesionTutoria sesionTutoria : sesiones) {
            tablaSesiones.add(sesionTutoria);
        }
        
        tableReporteGeneral.setItems(tablaSesiones);
        
    }
    

    @FXML
    private void salir(ActionEvent event) {
    }
}
