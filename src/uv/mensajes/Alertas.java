package uv.mensajes;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertas {
    private Alert alert = new Alert(AlertType.INFORMATION);
    
    public void mostrarAlertaErrorConexionDB(){
        alert.setTitle("Atención");
        alert.setHeaderText("Perdida de conexión");
        alert.setContentText("No se pudo conectar con la base de datos, por favor intente mas tarde.");
        alert.showAndWait();        
    }
    
    public void mostrarAlertaUsuarioIncorrecto(){
        alert.setTitle("Atención");
        alert.setHeaderText("No se encontró el usuario");
        alert.setContentText("No se encontró el usuario ingresado, por favor verifique.");
        alert.showAndWait();
    }

    public void mostrarAlertaCamposVacios(){
        alert.setTitle("Atención");
        alert.setHeaderText("Campos vacíos");
        alert.setContentText("Introduzca los campos necesarios para el registro.");
        alert.showAndWait();
    }

    public void mostrarAlertaRegistroExitoso() {
        alert.setTitle("Atención");
        alert.setHeaderText("Registro completado");
        alert.setContentText("El registro de la ifnormación se a almacenado correctamente.");
        alert.showAndWait();
    }

    public void mostrarAlertaSinTutores() {
        alert.setTitle("Atención");
        alert.setHeaderText("Tutores no encontrados");
        alert.setContentText("No existen tutores registrados en el sistema.");
        alert.showAndWait();
    }

    public void mostrarAlertarSinProblematicas() {
        alert.setTitle("Atención");
        alert.setHeaderText("Problematicas no encontrados");
        alert.setContentText("No existen problematicas registradas en el sistema.");
        alert.showAndWait();
    }

    public void mostrarAlertaNoHayFechasDeTutoriaRegistradas() {
        alert.setTitle("Atención");
        alert.setHeaderText("Fechas de tutoria no encontradas");
        alert.setContentText("No existen fechas de tutorias registradas en el sistema.");
        alert.showAndWait();
    }

    public void mostrarAlertaHorarioExistente() {
        alert.setTitle("Atención");
        alert.setHeaderText("Horario ya registrado");
        alert.setContentText("Usted ya registró un horario para la fecha seleccionada, por favor seleccione otra fecha.");
        alert.showAndWait();
    }

    public void mostrarAlertarHorarioNoRegistrado() {
        alert.setTitle("Atencion");
        alert.setHeaderText("Esta fecha de tutoria no tiene un horario registrado");
        alert.setContentText("Por favor seleccione otra fecha");
        alert.showAndWait();
    }
}
