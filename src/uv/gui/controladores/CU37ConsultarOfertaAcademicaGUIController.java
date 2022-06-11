package uv.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.ProgramaEducativoDAO;
import uv.fei.tutorias.domain.DocenteEEPrograma;
import uv.fei.tutorias.bussinesslogic.DocenteEEProgramasDAO;
import uv.fei.tutorias.domain.ProgramaEducativo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;


public class CU37ConsultarOfertaAcademicaGUIController implements Initializable {

    @FXML
    private TableView<DocenteEEPrograma> tblOfertaAcademica;
    @FXML
    private TableColumn colNRC;
    @FXML
    private TableColumn colExperiencia;
    @FXML
    private TableColumn colDocente;
    @FXML
    private TableColumn colProgramaEducativo;
    @FXML
    private Button btnCerrarVentana;
    @FXML
    private ChoiceBox cbbSeleccionProgramaEducativo;
    @FXML
    private Label lblMensajeError;

    private void inicializarTablaOfertaAcademica() {
        colNRC.setCellValueFactory(new PropertyValueFactory <DocenteEEPrograma, String>("nrc"));
        colExperiencia.setCellValueFactory(new PropertyValueFactory <DocenteEEPrograma, String>("ee"));
        colDocente.setCellValueFactory(new PropertyValueFactory <DocenteEEPrograma, String>("docente"));
        colProgramaEducativo.setCellValueFactory(new PropertyValueFactory <DocenteEEPrograma, String>("programaEducativo"));

        DocenteEEProgramasDAO docenteEEProgramasDAO = new DocenteEEProgramasDAO();
        ArrayList<DocenteEEPrograma> docentesEEProgramasDAO;
        docentesEEProgramasDAO = docenteEEProgramasDAO.obtenerOfertaAcademicaGeneral();

        ObservableList<DocenteEEPrograma> ofertaAcademicaTabla = FXCollections.observableArrayList();
        for (DocenteEEPrograma docenteEEPrograma : docentesEEProgramasDAO) {
            ofertaAcademicaTabla.add(docenteEEPrograma);
        }
        
        tblOfertaAcademica.setItems(ofertaAcademicaTabla);
    }
    
    private void actualizarPorOferta (){
        ObservableList<String> opcionesCombo;
        opcionesCombo = FXCollections.observableArrayList();
        ProgramaEducativoDAO programaEducativoDAO = new ProgramaEducativoDAO();
        ArrayList<ProgramaEducativo> programasEducativos = programaEducativoDAO.consultarTodosLosProgramasEducativos();
        opcionesCombo.add("Vista general");
        for(ProgramaEducativo programaEducativo : programasEducativos){
            opcionesCombo.add(programaEducativo.getNombre());
        }
        cbbSeleccionProgramaEducativo.setItems(opcionesCombo);
        cbbSeleccionProgramaEducativo.getSelectionModel().select(0);
        cbbSeleccionProgramaEducativo.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                colNRC.setCellValueFactory(new PropertyValueFactory <DocenteEEPrograma, String>("nrc"));
                colExperiencia.setCellValueFactory(new PropertyValueFactory <DocenteEEPrograma, String>("ee"));
                colDocente.setCellValueFactory(new PropertyValueFactory <DocenteEEPrograma, String>("docente"));
                colProgramaEducativo.setCellValueFactory(new PropertyValueFactory <DocenteEEPrograma, String>("programaEducativo"));

                ObservableList<DocenteEEPrograma> ofertaAcademicaTabla = FXCollections.observableArrayList();
                DocenteEEProgramasDAO docenteEEProgramasDAO = new DocenteEEProgramasDAO();
                ArrayList<DocenteEEPrograma> docentesEEProgramas;

                if(newValue == "Vista general"){
                    docentesEEProgramas = docenteEEProgramasDAO.obtenerOfertaAcademicaGeneral();
                    for (DocenteEEPrograma docenteEEPrograma : docentesEEProgramas) {
                        ofertaAcademicaTabla.add(docenteEEPrograma);
                    }
                }else {
                    docentesEEProgramas = docenteEEProgramasDAO.consultarOfertaAcademicaPorProgramaEducativo(newValue);
                    for (DocenteEEPrograma docenteEEPrograma : docentesEEProgramas) {
                        ofertaAcademicaTabla.add(docenteEEPrograma);
                    }
                }
                if (docentesEEProgramas.isEmpty()){
                    lblMensajeError.setVisible(true);
                }
                else {
                    lblMensajeError.setVisible(false);
                }
                tblOfertaAcademica.setItems(ofertaAcademicaTabla);
            }

        });
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.inicializarTablaOfertaAcademica();
        this.actualizarPorOferta();
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }
    
}
