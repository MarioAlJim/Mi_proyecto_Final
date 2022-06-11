package uv.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uv.fei.tutorias.bussinesslogic.TutoradoDAO;
import uv.fei.tutorias.domain.Tutorado;

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class ConsultarEstudianteController implements Initializable {

   
    @FXML
    private TableColumn colApellidoMaterno;

    @FXML
    private TableColumn colApellidoPaterno;

    @FXML
    private TableView tableTutorados;
    @FXML
    private TableColumn colNombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //this.inicializarTablaTutorados();
    }
    
    
    /*private void inicializarTablaTutorados() {
        colNombre.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("Nombre"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("ApellidoPaterno"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("ApellidoMaterno"));

        TutoradoDAO tutorDao = new TutoradoDAO();
        ArrayList<Tutorado> tutorados;
        //utorados = tutorDao.obtenerTutoradosPorNombreCompleto();

        ObservableList<Tutorado> tablaTutorado = FXCollections.observableArrayList();
        for (Tutorado tutorado : tutorados) {
            tablaTutorado.add(tutorado);
        }
        
        tableTutorados.setItems(tablaTutorado);
    }*/
    
}
