package uv.fei.tutorias.domain;

import java.util.Objects;

public class Horario extends Tutorado {
    private int  idHorario;
    private String hora;
    private int idTutoria;
    private String cuentauv;
    private int idProgramaEducativo;

    public int getIdProgramaEducativo() {
        return idProgramaEducativo;
    }

    public void setIdProgramaEducativo(int idProgramaEducativo) {
        this.idProgramaEducativo = idProgramaEducativo;
    }

    public void setCuentauv(String cuentauv) {
        this.cuentauv = cuentauv;
    }

    public String getCuentauv() {
        return cuentauv;
    }

    public void setIdTutoria(int idTutoria) {
        this.idTutoria = idTutoria;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public String getHora() {
        return hora;
    }

    public int getIdTutoria() {
        return idTutoria;
    }


}
