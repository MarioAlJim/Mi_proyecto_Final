package uv.fei.tutorias.domain;

import java.util.Objects;

public class SesionTutoria {
    private int idSesionTutoria;
    private String numTutoria;
    private String fechaTutoria;
    private String fechaCierreReportes;

    public int getIdSesionTutoria() {
        return idSesionTutoria;
    }

    public void setIdSesionTutoria(int idSesionTutoria) {
        this.idSesionTutoria = idSesionTutoria;
    }

    public String getNumTutoria() {
        return numTutoria;
    }

    public void setNumTutoria(String numTutoria) {
        this.numTutoria = numTutoria;
    }

    public String getFechaTutoria() {
        return fechaTutoria;
    }

    public void setFechaTutoria(String fechaTutoria) {
        this.fechaTutoria = fechaTutoria;
    }

    public String getFechaCierreReportes() {
        return fechaCierreReportes;
    }

    public void setFechaCierreReportes(String fechaCierreReportes) {
        this.fechaCierreReportes = fechaCierreReportes;
    }

    @Override
    public String toString() {
        return numTutoria + " - " + fechaTutoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SesionTutoria sesionTutoria = (SesionTutoria) o;
        return idSesionTutoria == sesionTutoria.idSesionTutoria && Objects.equals(numTutoria, sesionTutoria.numTutoria) && Objects.equals(fechaTutoria, sesionTutoria.fechaTutoria) && Objects.equals(fechaCierreReportes, sesionTutoria.fechaCierreReportes);
    }
    
}