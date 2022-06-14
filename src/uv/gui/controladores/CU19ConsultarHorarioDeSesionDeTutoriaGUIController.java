package uv.gui.controladores;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import uv.fei.tutorias.bussinesslogic.HorarioDAO;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.*;
import uv.mensajes.Alertas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CU19ConsultarHorarioDeSesionDeTutoriaGUIController implements Initializable {

    @FXML
    private TableView tblTutoradosHorario;
    @FXML
    private TableColumn colMatricula;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colHorario;
    @FXML
    private ComboBox cbbFechaTutoria;
    @FXML
    private Button btnCancelar;
    @FXML
    private ComboBox cbbPeriodo;

    Usuario usuarioActivo;
    ProgramaEducativo programaEducativoActivo;
    Alertas alertas = new Alertas();
    final static Logger log = Logger.getLogger(CU19ConsultarHorarioDeSesionDeTutoriaGUIController.class);

    public void recibirParametros(Usuario usuario, ProgramaEducativo programaEducativo) throws SQLException {
        usuarioActivo = usuario;
        programaEducativoActivo = programaEducativo;
        establecerPeriodoFechasTutoria();
    }

    private void establecerPeriodoFechasTutoria() throws SQLException{
        ArrayList<Periodo> periodo;
        PeriodoDAO periodoDAO = new PeriodoDAO();
        periodo = periodoDAO.consultarTodosLosPeriodos();
        ObservableList<Periodo> opcionesCombo;
        opcionesCombo = FXCollections.observableArrayList();
        for(Periodo periodoCiclo : periodo){
            opcionesCombo.add(periodoCiclo);
        }
        cbbPeriodo.setItems(opcionesCombo);
        cbbPeriodo.valueProperty().addListener((ov, valorAntiguo, valorNuevo) -> {
            cbbFechaTutoria.getSelectionModel().clearSelection();
            Periodo periodoElegido;
            periodoElegido = (Periodo) valorNuevo;
            mostrarFechasDeTutoria(periodoElegido.getIdPeriodo());
        });
    }

    private void mostrarFechasDeTutoria(int idPeriodo) {
        try {
            ObservableList<SesionTutoria> opcionesCombo;
            opcionesCombo = FXCollections.observableArrayList();
            SesionTutoriaDAO sesionTutoriaDAO = new SesionTutoriaDAO();
            ArrayList<SesionTutoria> sesionesTutorias = sesionTutoriaDAO.consultarTutoriaPorPeriodo(idPeriodo);
            for (SesionTutoria sesionTutoriaciclo : sesionesTutorias) {
                opcionesCombo.add(sesionTutoriaciclo);
            }
            cbbFechaTutoria.setItems(opcionesCombo);

            cbbFechaTutoria.valueProperty().addListener((ov, valorAntiguo, valorNuevo) -> {
                tblTutoradosHorario.getItems().clear();
                if (valorNuevo != null) {
                    SesionTutoria sesionTutoria = (SesionTutoria) valorNuevo;
                    mostrarHorario(sesionTutoria);
                }
            });
        }catch (SQLException exception){
            log.fatal(exception);
        }
    }

    private void mostrarHorario(SesionTutoria sesionTutoria){
        colMatricula.setCellValueFactory(new PropertyValueFactory<Horario, String>("matricula"));
        colNombre.setCellValueFactory(new PropertyValueFactory <Horario, String>("nombre"));
        colHorario.setCellValueFactory(new PropertyValueFactory <Horario, String>("hora"));
        HorarioDAO horarioDAO = new HorarioDAO();
        ArrayList<Horario> horarioArrayList = horarioDAO.consultarHorariosporIdTutoria(usuarioActivo.getCuentaUV(), sesionTutoria.getIdSesionTutoria(), 2/*programaEducativoActivo.getIdProgramaEducativo()*/);
        ObservableList<Horario> horarioObservableList = FXCollections.observableArrayList();
        if (!horarioArrayList.isEmpty()){
            for (Horario horario : horarioArrayList) {
                horarioObservableList.add(horario);
            }
        } else {
            alertas.mostrarAlertarHorarioNoRegistrado();
        }
        tblTutoradosHorario.setItems(horarioObservableList);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void cancelarOperacion(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
