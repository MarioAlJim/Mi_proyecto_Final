package uv.fei.tutorias.domain;

import java.util.Objects;

public class ProblematicaAcademica {
    private int idProblematicaAcademica;
    private int cantidadTutorados;
    private String titulo;
    private String descripcion;
    private String solucion;
    private int idDocenteEePrograma;

    public int getCantidadTutorados() {
        return cantidadTutorados;
    }

    public void setCantidadTutorados(int cantidadTutorados) {
        this.cantidadTutorados = cantidadTutorados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdProblematicaAcademica(int idProblematicaAcademica) {
        this.idProblematicaAcademica = idProblematicaAcademica;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public void setIdDocenteEePrograma(int idDocenteEePrograma) {
        this.idDocenteEePrograma = idDocenteEePrograma;
    }

    public int getIdProblematicaAcademica() {
        return idProblematicaAcademica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public int getIdDocenteEePrograma() {
        return idDocenteEePrograma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblematicaAcademica that = (ProblematicaAcademica) o;
        return idDocenteEePrograma == that.idDocenteEePrograma && Objects.equals(descripcion, that.descripcion) && Objects.equals(solucion, that.solucion);
    }

}
