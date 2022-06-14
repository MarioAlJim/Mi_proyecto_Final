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
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import uv.fei.tutorias.bussinesslogic.*;
import uv.fei.tutorias.domain.*;
import uv.mensajes.Alertas;


public class CU03RegistrarProblematicaAcademicaGUIController implements Initializable {

    @FXML
    private ComboBox cbbDocente;
    @FXML
    private ComboBox cbbExperienciaEducativa;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnNuevaProblematica;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextArea txtDescrpcion;
    @FXML
    private TextField txtCantidadTutorados;

    int idProblematica [];
    Usuario usuarioActivo;
    private Alertas alertas = new Alertas();
    ProgramaEducativo programaEducativoActivo;
    Docente docenteSeleccionado;
    ExperienciaEducativa experienciaEducativaSeleccionada;
    
    final static Logger log = Logger.getLogger(CU03RegistrarProblematicaAcademicaGUIController.class);

    public void recibirParametros(Usuario usuario, ProgramaEducativo programaEducativo, int idsesion) throws SQLException {
        usuarioActivo = usuario;
        programaEducativoActivo = programaEducativo;
        establecerDocentes();
    }

    private void establecerDocentes() throws SQLException {
        ArrayList<Docente> docentes;
        DocenteDAO docenteDAO = new DocenteDAO();
        docentes = docenteDAO.recuperarDocentesPorProgramaEducativo(1); // reemplazar por programa educativo
        ObservableList<Docente> docentesObservableList = FXCollections.observableArrayList();
        for (Docente docente : docentes) {
            docentesObservableList.add(docente);
        }
        cbbDocente.setItems(docentesObservableList);
        cbbDocente.valueProperty().addListener((ov, valorAntiguo, valorNuevo) -> {
            docenteSeleccionado = (Docente) valorNuevo;
            try {
                establecerExperiencias(docenteSeleccionado.getNumPersonal());
            } catch (SQLException exception) {
                log.fatal(exception);
            }
        });
    }

    private void establecerExperiencias(int numPersonal) throws SQLException {
        ArrayList<ExperienciaEducativa> experienciasEducativas;
        ObservableList<ExperienciaEducativa> experienciaEducativaObservableList = FXCollections.observableArrayList();
        ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
        experienciasEducativas = experienciaEducativaDAO.consultarExperienciasPorDocente(numPersonal);
        for(ExperienciaEducativa experienciaEducativa: experienciasEducativas){
            experienciaEducativaObservableList.add(experienciaEducativa);
        }
        cbbExperienciaEducativa.setItems(experienciaEducativaObservableList);
        cbbExperienciaEducativa.valueProperty().addListener((ov, valorAntiguo, valorNuevo) -> {
            experienciaEducativaSeleccionada = (ExperienciaEducativa) valorNuevo;
        });
    }

    @FXML
    private void comprobarProblematica(ActionEvent event) throws SQLException {
        Alertas alertas = new Alertas();
        if(txtCantidadTutorados.getText().isEmpty()){
            alertas.mostrarAlertaCamposVacios();
        }else if(txtTitulo.getText().isEmpty()){
            alertas.mostrarAlertaCamposVacios();
        }else if(txtDescrpcion.getText().isEmpty()){
            alertas.mostrarAlertaCamposVacios();
        }else if(docenteSeleccionado == null){
            alertas.mostrarAlertaCamposVacios();
        }else if(experienciaEducativaSeleccionada == null){
            alertas.mostrarAlertaCamposVacios();
        }else {
            guardarProblematica();
        }
    }

    private void guardarProblematica() throws SQLException {
        try {
            ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
            ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
            int cantidadTutorados = Integer.parseInt(txtCantidadTutorados.getText());
            String titulo = txtTitulo.getText();
            String descripcion = txtDescrpcion.getText();
            int numPersonal = docenteSeleccionado.getNumPersonal();
            int nrc = experienciaEducativaSeleccionada.getNrc();
            int idDocenteEE = obtenerIdDocenteEEPrograma();
            if (idDocenteEE != 0) {
                problematicaAcademica.setIdDocenteEePrograma(idDocenteEE);
            }
            problematicaAcademica.setCantidadTutorados(cantidadTutorados);
            problematicaAcademica.setDescripcion(descripcion);
            problematicaAcademica.setTitulo(titulo);
            int resultado = problematicaAcademicaDAO.registrarProblematicaAcademica(problematicaAcademica);
            if (resultado == 1) {
                Alertas alertas = new Alertas();
                alertas.mostrarAlertaRegistroExitoso();
            }
        }catch (SQLException exception){
            alertas.mostrarAlertaErrorConexionDB();
            log.fatal(exception);
        }
    }

    private int obtenerIdDocenteEEPrograma() {
        DocenteEEProgramasDAO docenteEEProgramasDAO = new DocenteEEProgramasDAO();
        int idDocenteEE = 0;
        try {
            idDocenteEE = docenteEEProgramasDAO.obtenerIdDocenteEEPrograma(docenteSeleccionado.getNumPersonal(), experienciaEducativaSeleccionada.getNrc());
        } catch (SQLException exception) {
            alertas.mostrarAlertaErrorConexionDB();
            exception.printStackTrace();
        }
        return idDocenteEE;
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void nuevoRegistro(ActionEvent event) {
        txtDescrpcion.setText("");
        txtTitulo.setText("");
        txtCantidadTutorados.setText("");
        cbbDocente.getSelectionModel().clearSelection();
        cbbExperienciaEducativa.getSelectionModel().clearSelection();
    }
}
