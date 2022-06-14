package uv.gui.controladores;

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
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import uv.fei.tutorias.bussinesslogic.TutoradoDAO;
import uv.fei.tutorias.domain.ProgramaEducativo;
import uv.fei.tutorias.domain.Tutor;
import uv.fei.tutorias.domain.Tutorado;
import uv.fei.tutorias.domain.TutoresTutorados;

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class ModificarAsignacionDeTutorAcademicoController implements Initializable {

    
    private ObservableList<Tutorado> listaTutores;
    @FXML
    private TextField tfBuscarNombre;
    @FXML
    private TableColumn tfMatricula;
    @FXML
    private TableColumn tfTutorado;
    @FXML
    private TableColumn tfTutor;
    @FXML
    private TableView tableTutoradosTutores;
    @FXML
    private TableColumn tfCuentaUv;
    
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
            this.inicializarTablaTutorados();
        } catch (SQLException ex) {
            Logger.getLogger(ModificarAsignacionDeTutorAcademicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    private void inicializarTablaTutorados() throws SQLException{
        tfMatricula.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("matricula"));
        tfTutorado.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("nombre"));
        tfCuentaUv.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("cuentaUV"));
        tfTutor.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("nombreTutor"));
        
        
        TutoradoDAO tutoradoDao = new TutoradoDAO();
        ArrayList<Tutorado> tutorados;
        tutorados = tutoradoDao.obtenerTutoradosConTutores();
        
        ObservableList<Tutorado> tablaTutorados = FXCollections.observableArrayList();
        for (Tutorado tutorado : tutorados) {
            tablaTutorados.add(tutorado);
        }
        
        tableTutoradosTutores.setItems(tablaTutorados);
    }
    
    public Tutorado getTablaTutoradoSeleccionado() {
        if (tableTutoradosTutores != null) {
            List<Tutorado> tabla = tableTutoradosTutores.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Tutorado tutoradoSeleccionado = tabla.get(0);
                return tutoradoSeleccionado;
            }
        }
        return null;
    }
    @FXML
    private void eliminarAsignacion(ActionEvent event) throws SQLException {
        Tutorado tutorado = getTablaTutoradoSeleccionado();
        TutoradoDAO tutorDao = new TutoradoDAO();
        
        //tableTutoradosTutores.getItems().remove(tutorado);
        
       String cuentaUv = tutorado.getCuentaUV();
       
        String matricula = tutorado.getMatricula();
        tutorDao.eliminarAsignacion(cuentaUv, matricula);
        this.inicializarTablaTutorados();
        System.out.print(cuentaUv + "");
        System.out.print(matricula+"");
   }

    @FXML
    private void agregarAsignacion(ActionEvent event) {
    }


    
    
}
        
    
/*
    private void filtrarNombre(KeyEvent event) {
        TutorDAO instance = new  TutorDAO();
	ArrayList<Tutor> tutores= new ArrayList<>();
	tutores = instance.obtenerTutoresPorNombreCompleto();
	
	
	ObservableList<Tutor> tutoresTabla = FXCollections.observableArrayList() ;
	String filtroTutor =  this.tfBuscarNombre.getText();
  
	
	if (!(filtroTutor.isEmpty())){
	  for (Tutor tutor1 : tutores){
		 if (tutor1.getNombre().toLowerCase().contains(filtroTutor.toLowerCase())) 
		 tutoresTabla.add(tutor1); 
	}
	 
		tableTutores.setItems(tutoresTabla);  
	}
	else{
		for (Tutor tutor1 : tutores){

			tutoresTabla.add(tutor1); 
	
	}
		tableTutores.setItems(tutoresTabla);  
		
	}
    }
*/
