package uv.fei.tutorias.domain;


public class Docente {
    
    private int NumPersonal;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;

    public void setNumPersonal(int NumPersonal) {
        this.NumPersonal = NumPersonal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumPersonal() {
        return NumPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return NumPersonal + " - " + nombre;
    }
}