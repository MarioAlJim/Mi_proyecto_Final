package uv.fei.tutorias.domain;

public class Coordinador {
    private String cuentaUV;
    private String password;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;

    public void setCuentaUV(String cuentaUV) {
        this.cuentaUV = cuentaUV;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCuentaUV() {
        return cuentaUV;
    }

    public String getCorreo(){
        return correo;

    }

    public String getPassword(){
        return password;

    }

    public String getNombre(){
        return nombre;

    }

    public String getApellidoPaterno(){
        return apellidoPaterno;

    }

    public String getApellidoMaterno(){
        return apellidoMaterno;

    }

    @Override
    public String toString() {
        return "Tutor{" +
                "cuentaUV='" + cuentaUV + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
