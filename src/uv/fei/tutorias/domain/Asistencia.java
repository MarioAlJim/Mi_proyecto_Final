package uv.fei.tutorias.domain;

public class Asistencia extends Tutorado{
    private Boolean  asistencia;
    private Boolean riesgo;

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Boolean getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(Boolean riesgo) {
        this.riesgo = riesgo;
    }
}
