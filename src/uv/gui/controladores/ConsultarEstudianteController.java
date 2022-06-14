
package uv.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.TutoradoDAO;
import uv.fei.tutorias.domain.ProgramaEducativo;
import uv.fei.tutorias.domain.Tutorado;
import uv.mensajes.Alertas;

public class ConsultarEstudianteController implements Initializable {

   
    @FXML
    private TableColumn colApellidoMaterno;

    @FXML
    private TableColumn colApellidoPaterno;

    @FXML
    private TableView tableTutorados;
    
    @FXML
    private TableColumn colNombre;
    
    @FXML
    private AnchorPane panelConsultarEstudiante;
    
    @FXML
    private Text lblCorreo;

    @FXML
    private Text lblMatricula;

    @FXML
    private Text lblNombre;
    
    Stage stage;
    
    @FXML
    private TextField tfBuscar;
    private Usuario usuarioActivo;
    private ProgramaEducativo programaEducativoActivo;
    
    public void recibirParametros(Usuario usuarioRecibido, ProgramaEducativo programaEducativo) throws SQLException{
        usuarioActivo = usuarioRecibido;
        programaEducativoActivo = programaEducativo;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.inicializarTablaTutorados();
        
    }
    
    
    private void inicializarTablaTutorados(){
        colNombre.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("Nombre"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("ApellidoPaterno"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("ApellidoMaterno"));

        TutoradoDAO tutorDao = new TutoradoDAO();
        ArrayList<Tutorado> tutorados;
        tutorados = tutorDao.obtenerTutoradosPorNombreCompleto();

        ObservableList<Tutorado> tablaTutorado = FXCollections.observableArrayList();
        for (Tutorado tutorado : tutorados) {
            tablaTutorado.add(tutorado);
        }
        
        tableTutorados.setItems(tablaTutorado);
        
    }

    @FXML
    private void salirVentana(ActionEvent event) {
        /*
        Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.ERROR, "Cancelar", "Confirmar cancelar registro",
                "¿Esta seguro de que desea cancelar el registro?");
        if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) panelConsultarEstudiante.getScene().getWindow();
                stage.close();
        }*/
    }

    @FXML
    private void clickDetalles(MouseEvent event) throws IOException {
        if(event.getClickCount() == 2){
            mostrarDatosTutorado();
        }
    }
    
    public Tutorado getTablaTutoradoSeleccionado() {
        if (tableTutorados != null) {
            List<Tutorado> tabla = tableTutorados.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Tutorado tutoradoSeleccionado = tabla.get(0);
                return tutoradoSeleccionado;
            }
        }
        return null;
    }
    
    private void mostrarDatosTutorado() {
        final Tutorado tutorado = getTablaTutoradoSeleccionado();
        
        if (tutorado != null) {
            lblNombre.setText(tutorado.getNombre() + " " + tutorado.getApellidoPaterno() + " " + tutorado.getApellidoMaterno());
            System.out.print(tutorado.getMatricula());
            System.out.print(tutorado.getCorreo());
            lblMatricula.setText(tutorado.getMatricula());
            lblCorreo.setText(tutorado.getCorreo());
    }
        
    }
    
    
    @FXML
    private void filtrarNombre(KeyEvent event) {
        
        TutoradoDAO instance = new  TutoradoDAO();
	ArrayList<Tutorado> tutorados= new ArrayList<>();
	tutorados = instance.obtenerTutoradosPorNombreCompleto();
	
	
	ObservableList<Tutorado> tutoradosTabla = FXCollections.observableArrayList() ;
	String filtroTutorado =  this.tfBuscar.getText();
  
	
	if (!(filtroTutorado.isEmpty())){
	  for (Tutorado tutorado1 : tutorados){
		 if (tutorado1.getNombre().toLowerCase().contains(filtroTutorado.toLowerCase())) 
		 tutoradosTabla.add(tutorado1); 
	}
	 
		tableTutorados.setItems(tutoradosTabla);  
	}
	else{
		for (Tutorado tutorado1 : tutorados){

			tutoradosTabla.add(tutorado1); 
	
	}
		tableTutorados.setItems(tutoradosTabla);  
		
	}
    }
    }

