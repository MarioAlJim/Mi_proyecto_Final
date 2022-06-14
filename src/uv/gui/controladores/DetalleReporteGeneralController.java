package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class DetalleReporteGeneralController implements Initializable {

    private SesionTutoria sesionTutoria;
    @FXML
    private TableView tableProblematicas;
    @FXML
    private TableView tableComentarios;
    @FXML
    private TableColumn colDocente;
    @FXML
    private TableColumn colTitulo;
    @FXML
    private TableColumn colTutor;
    @FXML
    private TableColumn colComentario;
    @FXML
    private TableColumn colExperienciaEducativa;
    @FXML
    private TableColumn colDescripcion;
    @FXML
    private TableColumn colNumeroAlumnos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void configurarEscena(SesionTutoria sesionTutorianueva){
        this.sesionTutoria = sesionTutorianueva;
    }
    
    public void cargarInformacionDelReporte(){
        
    }
    
    private void cargarTablaDeProblematicas() throws SQLException{
        colTutor.setCellValueFactory(new PropertyValueFactory <SesionTutoria, String>("fechaCompleta"));
        colComentario.setCellValueFactory(new PropertyValueFactory <SesionTutoria, String>("numTutoria"));
        
        SesionTutoriaDAO sesionTutoriaDao = new SesionTutoriaDAO();
        ArrayList<SesionTutoria> sesiones;
        sesiones = (ArrayList<SesionTutoria>) sesionTutoriaDao.consultarTodosLasSesiones();

        ObservableList<SesionTutoria> tablaSesiones = FXCollections.observableArrayList();
        for (SesionTutoria sesionTutoria : sesiones) {
            tablaSesiones.add(sesionTutoria);
        }
        
        tableComentarios.setItems(tablaSesiones);
        
    }

    @FXML
    private void salir(ActionEvent event) {
        
    }
    
}
