package uv.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import uv.fei.tutorias.domain.ProgramaEducativo;
import uv.fei.tutorias.domain.Usuario;

public class MenuTutorGUIController implements Initializable {

    Usuario usuarioActivo;
    ProgramaEducativo programaEducativo;
    @FXML
    private Button btnOfertaAcademiac;
    @FXML
    private Button btnProblematica;
    @FXML
    private Button btnRegistroHorario;
    @FXML
    private Button btnConsultarHorario;
    @FXML
    private Button btn;
    @FXML
    private Label lblNombreUsuario;
    @FXML
    private Button dtnModificarHorario;
    @FXML
    private Button btnConsultarProblematicas;
    @FXML
    private Button bntRegistrarReporte;

    public void recibirParametros (Usuario usuario){
        usuarioActivo = usuario;
        lblNombreUsuario.setText(usuario.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void abrirConsultarOfertaAcademica(ActionEvent event) throws IOException {
        Stage stageOfertaAcademica = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/CU37ConsultarOfertaAcademicaGUI.fxml").openStream());
        Scene scene = new Scene(root);
        stageOfertaAcademica.setScene(scene);
        stageOfertaAcademica.setTitle("Oferta Academica");
        stageOfertaAcademica.alwaysOnTopProperty();
        stageOfertaAcademica.initModality(Modality.APPLICATION_MODAL);
        stageOfertaAcademica.show();
    }

    @FXML
    private void abrirRegistrarHorario(ActionEvent event) throws IOException, SQLException {
        Stage stageMenuTutor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/CU17RegistrarHorariodeSesiondeTutoriaGUI.fxml").openStream());
        CU17RegistrarHorariodeSesiondeTutoriaGUIController  cu17RegistrarHorariodeSesiondeTutoriaGUIController = (CU17RegistrarHorariodeSesiondeTutoriaGUIController) loader.getController();
        cu17RegistrarHorariodeSesiondeTutoriaGUIController.recibirParametros(usuarioActivo, programaEducativo);
        Scene scene = new Scene(root);
        stageMenuTutor.setScene(scene);
        stageMenuTutor.setTitle("Registrar horarios");
        stageMenuTutor.alwaysOnTopProperty();
        stageMenuTutor.initModality(Modality.APPLICATION_MODAL);
        stageMenuTutor.show();
    }
    
    @FXML
    private void abrirConsultarHorario(ActionEvent event) throws IOException, SQLException{
        Stage stageMenuTutor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/CU19ConsultarHorarioDeSesionDeTutoriaGUI.fxml").openStream());
        CU19ConsultarHorarioDeSesionDeTutoriaGUIController  cu19ConsultarHorarioDeSesionDeTutoriaGUIController = (CU19ConsultarHorarioDeSesionDeTutoriaGUIController) loader.getController();
        cu19ConsultarHorarioDeSesionDeTutoriaGUIController.recibirParametros(usuarioActivo, programaEducativo);
        Scene scene = new Scene(root);
        stageMenuTutor.setScene(scene);
        stageMenuTutor.setTitle("Consultar horarios");
        stageMenuTutor.alwaysOnTopProperty();
        stageMenuTutor.initModality(Modality.APPLICATION_MODAL);
        stageMenuTutor.show();
    }

    @FXML
    private void abrirConsultarTutor(ActionEvent event) throws IOException{
        Stage stageMenuTutor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/CU32ConsultarTutorGUI.fxml").openStream());
        CU32ConsultarTutorGUIController  cu32ConsultarTutorGUIController = (CU32ConsultarTutorGUIController) loader.getController();
        cu32ConsultarTutorGUIController.recibirParametros(usuarioActivo, programaEducativo);
        Scene scene = new Scene(root);
        stageMenuTutor.setScene(scene);
        stageMenuTutor.setTitle("Consultar tutores");
        stageMenuTutor.alwaysOnTopProperty();
        stageMenuTutor.initModality(Modality.APPLICATION_MODAL);
        stageMenuTutor.show();
    }

    @FXML
    private void abirirModificarHorario(ActionEvent event) throws IOException,SQLException {
        Stage stageMenuTutor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/CU20ModificarHorarioDeSesionDeTutoriaGUI.fxml").openStream());
        CU20ModificarHorarioDeSesionDeTutoriaGUIController  cu20ModificarHorarioDeSesionDeTutoriaGUIController = (CU20ModificarHorarioDeSesionDeTutoriaGUIController) loader.getController();
        cu20ModificarHorarioDeSesionDeTutoriaGUIController.recibirParametros(usuarioActivo, programaEducativo);
        Scene scene = new Scene(root);
        stageMenuTutor.setScene(scene);
        stageMenuTutor.setTitle("Modificar horario de tutorias");
        stageMenuTutor.alwaysOnTopProperty();
        stageMenuTutor.initModality(Modality.APPLICATION_MODAL);
        stageMenuTutor.show();
    }

    @FXML
    private void abrirConsultarProblematicas(ActionEvent event) throws IOException, SQLException {
        Stage stageMenuTutor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/CU06ConsultarProblematicasAcademicas.fxml").openStream());
        CU06ConsultarProblematicasAcademicasController cu06ConsultarProblematicasAcademicasController = (CU06ConsultarProblematicasAcademicasController) loader.getController();
        cu06ConsultarProblematicasAcademicasController.recibirParametros(usuarioActivo, programaEducativo);
        Scene scene = new Scene(root);
        stageMenuTutor.setScene(scene);
        stageMenuTutor.setTitle("Consultar problematicas academicas");
        stageMenuTutor.alwaysOnTopProperty();
        stageMenuTutor.initModality(Modality.APPLICATION_MODAL);
        stageMenuTutor.show();
    }

    @FXML
    private void registrarReporte(ActionEvent event) throws IOException, SQLException {
        Stage stageMenuTutor = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/uv/gui/interfaces/CU02LlenarReporteDeTutoria.fxml").openStream());
        CU02LlenarReporteDeTutoriaController cu02LlenarReporteDeTutoriaController = (CU02LlenarReporteDeTutoriaController) loader.getController();
        cu02LlenarReporteDeTutoriaController.recibirParametros(usuarioActivo, programaEducativo);
        Scene scene = new Scene(root);
        stageMenuTutor.setScene(scene);
        stageMenuTutor.setTitle("Registrar reporte de turoría");
        stageMenuTutor.alwaysOnTopProperty();
        stageMenuTutor.initModality(Modality.APPLICATION_MODAL);
        stageMenuTutor.show();
    }

    @FXML
    private void abrirRegistrarProblematica(ActionEvent event) {
    }
    
}
