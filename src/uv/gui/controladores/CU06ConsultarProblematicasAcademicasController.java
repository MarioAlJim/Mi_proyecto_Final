package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import uv.fei.tutorias.bussinesslogic.ProblematicaAcademicaDAO;
import uv.fei.tutorias.domain.*;
import uv.mensajes.Alertas;

public class CU06ConsultarProblematicasAcademicasController implements Initializable {

    @FXML
    private TableView<ProblematicaReporte> tblProblematicas;
    @FXML
    private TableColumn colIdProblematica;
    @FXML
    private TableColumn colFecha;
    @FXML
    private TableColumn colTitulo;
    @FXML
    private TableColumn colExperiencia;
    @FXML
    private Button btnCerrar;
    @FXML
    private TextField txtAlumnos;
    @FXML
    private TextField txtDocente;
    @FXML
    private TextField txtExperiencia;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private Label lblAlumnos;
    @FXML
    private Label lblDocente;
    @FXML
    private Label lblExperiencia;
    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblDescripcion;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Label lblSugerencia;
    @FXML
    private Button btnCerrarinformacion;
    @FXML
    private Label lblProblematica;

    ProgramaEducativo programaEducativo;
    Usuario usuarioActivo;
    final static Logger log = Logger.getLogger(CU06ConsultarProblematicasAcademicasController.class);

    public void recibirParametros(Usuario usuarioRecibido, ProgramaEducativo programaRecibido) throws SQLException {
        usuarioActivo = usuarioRecibido;
        programaEducativo = programaRecibido;
        establecerListaProblematicas();
    }

    private void establecerListaProblematicas() throws SQLException {
        colIdProblematica.setCellValueFactory(new PropertyValueFactory<ProblematicaReporte, String>("idProblematicaAcademica"));
        colExperiencia.setCellValueFactory(new PropertyValueFactory<ProblematicaReporte, String>("experiencia"));
        colFecha.setCellValueFactory(new PropertyValueFactory<ProblematicaReporte, String>("fecha"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<ProblematicaReporte, String>("titulo"));
        ArrayList<ProblematicaReporte> problematicaReportes;
        ProblematicaAcademicaDAO problematicaAcademicaDAO = new ProblematicaAcademicaDAO();
        problematicaReportes = problematicaAcademicaDAO.consultarTodasLasProblematicasPorProgramaEducativoCuenta(2, usuarioActivo.getCuentaUV());
        ObservableList<ProblematicaReporte> problematicaAcademicaObservableList = FXCollections.observableArrayList();
        if(!problematicaReportes.isEmpty()) {
            for (ProblematicaReporte problematicaReporte : problematicaReportes) {
                problematicaAcademicaObservableList.add(problematicaReporte);
            }
        }else {
            Alertas alertas = new Alertas();
            alertas.mostrarAlertarSinProblematicas();
        }
        tblProblematicas.setItems(problematicaAcademicaObservableList);
    }

    private final ListChangeListener<ProblematicaReporte> selectorTablaProblematicas = new ListChangeListener<ProblematicaReporte>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends ProblematicaReporte> c) {
            mostraDatosProblematica();
        }
    };
    public ProblematicaReporte getTablaProblematicaSeleccionada() {
        ProblematicaReporte problematicaReporte = new ProblematicaReporte();
        if (tblProblematicas != null) {
            List<ProblematicaReporte> tabla = tblProblematicas.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                problematicaReporte = tabla.get(0);
            }
        }
        return problematicaReporte;
    }

    private void mostraDatosProblematica() {
        datosProblematicaVisibles();
        ProblematicaReporte problematicaReporte = getTablaProblematicaSeleccionada();
        String cantidadAlumnos = String.valueOf(problematicaReporte.getCantidadTutorados());
        String descripcion = problematicaReporte.getDescripcion();
        String titulo = problematicaReporte.getTitulo();
        String experiencia = problematicaReporte.getExperiencia();
        String docente = problematicaReporte.getNombreDocente();
        txtAlumnos.setText(cantidadAlumnos);
        txtDescripcion.setText(descripcion);
        txtTitulo.setText(titulo);
        txtDocente.setText(docente);
        txtExperiencia.setText(experiencia);
    }

    private void datosProblematicaVisibles() {
        tblProblematicas.setVisible(false);
        btnCerrar.setVisible(false);
        lblSugerencia.setVisible(false);
        lblProblematica.setVisible(true);
        btnCerrarinformacion.setVisible(true);
        btnEliminar.setVisible(true);
        btnModificar.setVisible(true);
        txtAlumnos.setVisible(true);
        txtDescripcion.setVisible(true);
        txtTitulo.setVisible(true);
        txtDocente.setVisible(true);
        txtExperiencia.setVisible(true);
        lblAlumnos.setVisible(true);
        lblDescripcion.setVisible(true);
        lblDocente.setVisible(true);
        lblExperiencia.setVisible(true);
        lblTitulo.setVisible(true);
    }

    @FXML
    private void cerrarInformacion(ActionEvent event) {
        tblProblematicas.setVisible(true);
        btnCerrar.setVisible(true);
        lblSugerencia.setVisible(true);
        lblProblematica.setVisible(false);
        btnCerrarinformacion.setVisible(false);
        btnEliminar.setVisible(false);
        btnModificar.setVisible(false);
        txtAlumnos.setVisible(false);
        txtDescripcion.setVisible(false);
        txtTitulo.setVisible(false);
        txtDocente.setVisible(false);
        txtExperiencia.setVisible(false);
        lblAlumnos.setVisible(false);
        lblDescripcion.setVisible(false);
        lblDocente.setVisible(false);
        lblExperiencia.setVisible(false);
        lblTitulo.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ObservableList<ProblematicaReporte> problematicaReportes = tblProblematicas.getSelectionModel().getSelectedItems();
        problematicaReportes.addListener(selectorTablaProblematicas);
        txtAlumnos.setEditable(false);
        txtDescripcion.setEditable(false);
        txtTitulo.setEditable(false);
        txtDocente.setEditable(false);
        txtExperiencia.setEditable(false);
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void abrirEliminar(ActionEvent event) {
    }

    @FXML
    private void abrirModificar(ActionEvent event) {
    }

}
