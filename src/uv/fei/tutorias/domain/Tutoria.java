package uv.fei.tutorias.domain;


public class Tutoria {

    private int idTutoria;
    private int numeroTutoria;
    private String fechaTutoria;
    private String fechaCierreReportes;
    private int IdPeriodo;

    public int getIdTutoria() {
        return idTutoria;
    }

    public void setIdTutoria(int idTutoria) {
        idTutoria = idTutoria;
    }

    public int getNumeroTutoria() {
        return numeroTutoria;
    }

    public void setNumeroTutoria(int numeroTutoria) {
        this.numeroTutoria = numeroTutoria;
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

    public int getIdPeriodo() {
        return IdPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        IdPeriodo = idPeriodo;
    }
}
