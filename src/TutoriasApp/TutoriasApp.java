package TutoriasApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class TutoriasApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarFechasDeSesionDeTutoria.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/ConsultarEstudiante.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarTutorAcademicoGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarFechasDeCierreParaLaEntregaDelReporte.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/CU46AsignarEE.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarTutorAcademicoGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/CU37ConsultarOfertaAcademicaGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/CU32ConsultarTutorGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/CU17RegistrarHorariodeSesiondeTutoriaGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/CU19ConsultarHorarioDeSesionDeTutoriaGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/CU03RegistrarProblematicaAcademicaGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/MenuTutorGUI.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/inicioSesionGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image("/uv/fei/tutorias/img/logoUV.png"));
        stage.setTitle("Iniciar sesion");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}