package uv.fei.tutorias.domain;

public class ProblematicaReporte extends ProblematicaAcademica{
    private String experiencia;
    private String NombreDocente;
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getNombreDocente() {
        return NombreDocente;
    }

    public void setNombreDocente(String NombreDocente) {
        this.NombreDocente = NombreDocente;
    }

}
