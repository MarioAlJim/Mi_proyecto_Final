package uv.fei.tutorias.domain;

import java.util.Objects;

public class Usuario {
    private String cuentaUV;
    private String contrasenia;
    private int rol;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public void setRol(int rol) {
        this.rol = rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setCuentaUV(String cuentaUV) {
        this.cuentaUV = cuentaUV;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public String getCuentaUV() {
        return cuentaUV;
    }

    public int getRol(){
        return rol;
    }

    public String getContrasenia() {
        return contrasenia;
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

    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cuentaUV, usuario.cuentaUV) && Objects.equals(contrasenia, usuario.contrasenia);
    }
}



