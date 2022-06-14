package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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

public class CU20ModificarHorarioDeSesionDeTutoriaGUIController implements Initializable {
    
    @FXML
    private TableView<Horario> tblTutoradosHorario;
    @FXML
    private TableColumn  colMatricula;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colHorario;
    @FXML
    private ComboBox cbbFechaTutoria;
    @FXML
    private TextField lblPeriodo;
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txtHorario;

    Alertas alertas = new Alertas();
    Usuario usuarioActivo;
    ProgramaEducativo programaEducativoActivo;
    Horario horarioSeleccionado;
    ObservableList<Horario> horarioExistenteObservableList;
    final static Logger log = Logger.getLogger(CU03RegistrarProblematicaAcademicaGUIController.class);

    public void recibirParametros(Usuario usuario, ProgramaEducativo programaEducativo) {
        usuarioActivo = usuario;
        programaEducativoActivo = programaEducativo;
        establecerPeriodoFechasTutoria();
    }

    private void establecerPeriodoFechasTutoria() {
        Periodo periodo;
        PeriodoDAO periodoDAO = new PeriodoDAO();
        try {
            periodo = periodoDAO.consultarPeriodoActivo();
            lblPeriodo.setText(periodo.toString());
            mostrarFechasDeTutoria(periodo);
        } catch (SQLException exception) {
            alertas.mostrarAlertaErrorConexionDB();
            log.fatal(exception);
        }
    }

    private void mostrarFechasDeTutoria(Periodo periodo) throws SQLException{
        ObservableList<SesionTutoria> opcionesCombo;
        opcionesCombo = FXCollections.observableArrayList();
        SesionTutoriaDAO sesionTutoriaDAO = new SesionTutoriaDAO();
        ArrayList<SesionTutoria> sesionesTutorias = sesionTutoriaDAO.consultarTutoriaPorPeriodo(periodo.getIdPeriodo());

        for(SesionTutoria sesionTutoriaciclo : sesionesTutorias){
            opcionesCombo.add(sesionTutoriaciclo);
        }
        cbbFechaTutoria.setItems(opcionesCombo);

        cbbFechaTutoria.valueProperty().addListener((ov, valorAntiguo, valorNuevo) -> {
                tblTutoradosHorario.getItems().clear();
                if(valorNuevo != null){
                    SesionTutoria sesionTutoria = (SesionTutoria) valorNuevo;
                    mostrarHorario(sesionTutoria);
                }
        });
    }

    private void mostrarHorario(SesionTutoria sesionTutoria){
        colMatricula.setCellValueFactory(new PropertyValueFactory<Horario, String>("matricula"));
        colNombre.setCellValueFactory(new PropertyValueFactory <Horario, String>("nombre"));
        colHorario.setCellValueFactory(new PropertyValueFactory <Horario, String>("hora"));
        btnCerrar.setDisable(false);
        btnGuardar.setDisable(true);
        HorarioDAO horarioDAO = new HorarioDAO();
        ArrayList<Horario> horarioArrayList = horarioDAO.consultarHorariosporIdTutoria(usuarioActivo.getCuentaUV(), sesionTutoria.getIdSesionTutoria(), 2);//reemplazar por programa
        horarioExistenteObservableList = FXCollections.observableArrayList();
        if (!horarioArrayList.isEmpty()){
            for (Horario horario : horarioArrayList) {
                horarioExistenteObservableList.add(horario);
            }
            tblTutoradosHorario.setItems(horarioExistenteObservableList);
            tblTutoradosHorario.setDisable(false);
        }else {
            tblTutoradosHorario.setDisable(true);
            alertas.mostrarAlertarHorarioNoRegistrado();
        }
    }

    private final ListChangeListener<Horario> selectorTablaTutorados =
            new ListChangeListener<Horario>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Horario> c) {
                    ponerHorarioSeleccionado();
                }
            };

    public Horario getTablaHorarioSeleccionada() {
        Horario horarioseleccionado = new Horario();
        if (tblTutoradosHorario != null) {
            List<Horario> tabla = tblTutoradosHorario.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                horarioseleccionado = tabla.get(0);
            }
        }
        return horarioseleccionado;
    }

    private void ponerHorarioSeleccionado() {
        horarioSeleccionado = getTablaHorarioSeleccionada();
        if (horarioSeleccionado != null) {
            btnGuardar.setDisable(false);
            txtHorario.setDisable(false);
            btnCerrar.setDisable(true);
        }
    }

    @FXML
    private void modificarHorario(ActionEvent event) {
        if(!txtHorario.getText().isEmpty()){
            String horarioEscrito = txtHorario.getText();
            horarioSeleccionado.setHora(horarioEscrito);
            horarioExistenteObservableList.set(horarioExistenteObservableList.indexOf(horarioSeleccionado), horarioSeleccionado);
            HorarioDAO horarioDAO = new HorarioDAO();
            horarioDAO.actualizarHorario(horarioSeleccionado);
            btnCerrar.setDisable(false);
            btnGuardar.setDisable(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ObservableList<Horario> horariosNuevos = tblTutoradosHorario.getSelectionModel().getSelectedItems();
        horariosNuevos.addListener(selectorTablaTutorados);
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
