package uv.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
import uv.fei.tutorias.bussinesslogic.ReporteTutorDAO;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.*;
import uv.mensajes.Alertas;

public class CU02LlenarReporteDeTutoriaController implements Initializable {

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEnviarReporte;
    @FXML
    private Button bntCerrarVentana;
    @FXML
    private TableView<Asistencia> tblTutorados;
    @FXML
    private TableColumn colAsistencia;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colRiesgo;
    @FXML
    private TextField txtPeriodo;
    @FXML
    private TextField txtTutoria;
    @FXML
    private Button btnComentario;
    @FXML
    private Button btnProblematicas;

    private  ObservableList<Asistencia> asistenciaObservableArray;
    private Alertas alertas = new Alertas();
    private Usuario usuarioActivo;
    private ProgramaEducativo programaEducativoActivo;
    private ReporteTutor reporteTutor= new ReporteTutor();
    private SesionTutoria sesionTutoriaActiva = new SesionTutoria();
    final static Logger log = Logger.getLogger(CU02LlenarReporteDeTutoriaController.class);

    public void recibirParametros(Usuario usuario, ProgramaEducativo programaEducativo) {
        usuarioActivo = usuario;
        programaEducativoActivo = programaEducativo;
        establecerPeriodoFechasTutoria();
        llenarTablaTutorados();
    }

    private void establecerPeriodoFechasTutoria() {
        Periodo periodo = new Periodo();
        PeriodoDAO periodoDAO = new PeriodoDAO();
        try {
            periodo = periodoDAO.consultarPeriodoActivo();
            txtPeriodo.setText(periodo.toString());
            obtenerTutoriaActiva(periodo);
        } catch (SQLException exception) {
            alertas.mostrarAlertaErrorConexionDB();
            log.fatal(exception);
        }
    }

    private void obtenerTutoriaActiva(Periodo periodo) {
        SesionTutoriaDAO sesionTutoriaDAO = new SesionTutoriaDAO();
        ArrayList<SesionTutoria> sesionesTutorias = sesionTutoriaDAO.consultarTutoriaPorPeriodo(periodo.getIdPeriodo());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String stringFecha = fecha.format(myFormatObj);
        try {
            Date fechaActual = dateFormat.parse(stringFecha);
            if (!sesionesTutorias.isEmpty()){
                for (SesionTutoria sesionTutoriaCiclo : sesionesTutorias) {
                    String fechaInicioTutoria = sesionTutoriaCiclo.getFechaTutoria();
                    String fechaFinTutoria = sesionTutoriaCiclo.getFechaCierreReportes();
                    Date fechaTutoriaInicio = dateFormat.parse(fechaInicioTutoria);
                    Date fechaTutoriaCierre = dateFormat.parse(fechaFinTutoria);
                    if (fechaActual.equals(fechaInicioTutoria)) {
                        sesionTutoriaActiva = sesionTutoriaCiclo;
                        System.out.println(sesionTutoriaActiva.getIdSesionTutoria());
                    } else if (fechaActual.after(fechaTutoriaInicio) && fechaActual.before(fechaTutoriaCierre)) {
                        sesionTutoriaActiva = sesionTutoriaCiclo;
                    }
                }
            }else{
                alertas.mostrarAlertaNoHayFechasDeTutoriaRegistradas();
            }
        } catch (ParseException exception) {
            log.fatal(exception);
        }
        mostrarFechasDeTutoria(sesionTutoriaActiva);
        generaNuevoReporte();
    }

    private void generaNuevoReporte() {
        try {
            ReporteTutor reporteTutorNuevo = new ReporteTutor();
            reporteTutorNuevo.setIdTutoria(sesionTutoriaActiva.getIdSesionTutoria());
            reporteTutorNuevo.setIdProgramaEducativo(2 /*programaEducativoActivo.getIdProgramaEducativo()*/);
            reporteTutorNuevo.setCuentaUv(usuarioActivo.getCuentaUV());

            ReporteTutorDAO reporteTutorDAO = new ReporteTutorDAO();
            reporteTutorDAO.registrarReporte(reporteTutorNuevo);

            int idReporteNuevo;
            idReporteNuevo = reporteTutorDAO.obtenerIdReporte(reporteTutorNuevo);
            System.out.println("Hola");
            System.out.println(reporteTutor.getIdsesion());
            reporteTutorNuevo.setIdsesion(idReporteNuevo);
        } catch (SQLException exception){
            log.fatal(exception);
        }
    }

    private void mostrarFechasDeTutoria(SesionTutoria sesionTutoria){
        txtTutoria.setText(sesionTutoria.toString());
        llenarTablaTutorados();
    }

    private void llenarTablaTutorados(){
        colAsistencia.setCellValueFactory(new PropertyValueFactory<Asistencia, String>("checkBoxAsistencia"));
        colNombre.setCellValueFactory(new PropertyValueFactory <Asistencia, String>("nombreCompleto"));
        colRiesgo.setCellValueFactory(new PropertyValueFactory <Asistencia, String>("checkBoxRiesgo"));

        asistenciaObservableArray = FXCollections.observableArrayList();
        ArrayList<Asistencia> tutoradosAsistencia;
        ReporteTutorDAO reporteTutor = new ReporteTutorDAO();
        tutoradosAsistencia = reporteTutor.obtenerTutoradosParaAsistencia(usuarioActivo.getCuentaUV(), 2);
        if(!tutoradosAsistencia.isEmpty()){
            for(Asistencia asistencia : tutoradosAsistencia){
                asistenciaObservableArray.add(asistencia);
            }
        }
        tblTutorados.setItems(asistenciaObservableArray);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void guardarReporte(ActionEvent event) throws SQLException {
        Asistencia asistencia = new Asistencia();
        ReporteTutorDAO reporteTutorDao = new ReporteTutorDAO();
        do {
            asistencia = asistenciaObservableArray.get(0);
            System.out.println("Aqui registro " + reporteTutor.getIdsesion());
            reporteTutorDao.registrarAsistencia(asistencia, reporteTutor.getIdsesion());
            asistenciaObservableArray.remove(0);
        } while(!asistenciaObservableArray.isEmpty());
    }

    @FXML
    private void enviarReporte(ActionEvent event) {
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registrarComentario(ActionEvent event) {
    }

    @FXML
    private void registrarProblematicas(ActionEvent event) throws IOException, SQLException {
        Stage stageMenuTutor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/CU03RegistrarProblematicaAcademicaGUI.fxml").openStream());
        CU03RegistrarProblematicaAcademicaGUIController cu03RegistrarProblematicaAcademicaGUIController = (CU03RegistrarProblematicaAcademicaGUIController) loader.getController();
        cu03RegistrarProblematicaAcademicaGUIController.recibirParametros(usuarioActivo, programaEducativoActivo/*, reporteTutor.setIdsesion()*/);
        Scene scene = new Scene(root);
        stageMenuTutor.setScene(scene);
        stageMenuTutor.setTitle("Registrar problematica academica");
        stageMenuTutor.alwaysOnTopProperty();
        stageMenuTutor.initModality(Modality.APPLICATION_MODAL);
        stageMenuTutor.show();
    }
    
}
