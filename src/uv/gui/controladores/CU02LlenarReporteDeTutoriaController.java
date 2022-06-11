package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
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

    Alertas alertas = new Alertas();
    Usuario usuarioActivo;
    ProgramaEducativo programaEducativoActivo;
    final static Logger log = Logger.getLogger(CU02LlenarReporteDeTutoriaController.class);

    public void recibirParametros(Usuario usuario, ProgramaEducativo programaEducativo) throws SQLException {
        usuarioActivo = usuario;
        programaEducativoActivo = programaEducativo;
        establecerPeriodoFechasTutoria();
    }

    private void establecerPeriodoFechasTutoria() {
        Periodo periodo = new Periodo();
        PeriodoDAO periodoDAO = new PeriodoDAO();
        try {
            periodo = periodoDAO.consultarPeriodoActivo();
            txtPeriodo.setText(periodo.toString());
            obtenerTutoriaActiva(periodo);
        } catch (SQLException exception) {
            log.fatal(exception);
        }
    }

    private String obtenerFechaActual(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaActual = String.valueOf(dateTimeFormatter);
        return fechaActual;
    }

    private void obtenerTutoriaActiva(Periodo periodo) {
        SesionTutoria sesionTutoriaActiva = new SesionTutoria();
        SesionTutoriaDAO sesionTutoriaDAO = new SesionTutoriaDAO();
        ArrayList<SesionTutoria> sesionesTutorias = sesionTutoriaDAO.consultarTutoriaPorPeriodo(periodo.getIdPeriodo());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Date fechaActual = null;
        try {
            if (!sesionesTutorias.isEmpty()) {
                for (SesionTutoria sesionTutoriaCiclo : sesionesTutorias) {
                    Date fechaTutoriaInicio = dateFormat.parse(sesionTutoriaCiclo.getFechaTutoria());
                    Date fechaTutoriaCierre = dateFormat.parse(sesionTutoriaCiclo.getFechaCierreReportes());
                    if (fechaActual.equals(fechaTutoriaInicio)) {
                        sesionTutoriaActiva = sesionTutoriaCiclo;
                    } else if (fechaActual.after(fechaTutoriaInicio) && fechaActual.before(fechaTutoriaCierre)) {
                        sesionTutoriaActiva = sesionTutoriaCiclo;
                    }
                }
            } else {
                alertas.mostrarAlertaNoHayFechasDeTutoriaRegistradas();
            }
        } catch (ParseException exception) {
            log.fatal(exception);
        }
        mostrarFechasDeTutoria(sesionTutoriaActiva);
    }


    private void mostrarFechasDeTutoria(SesionTutoria sesionTutoria){
            txtTutoria.setText(sesionTutoria.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardarReporte(ActionEvent event) {
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
    private void registrarProblematicas(ActionEvent event) {
    }
    
}
