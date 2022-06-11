package uv.fei.tutorias.domain;

import java.util.Objects;

public class DocenteEEPrograma {
    private int idOfertaAcademica;
    private String nrc;
    private String ee;
    private String docente;
    private String programaEducativo;

    public int getIdOfertaAcademica() {
        return idOfertaAcademica;
    }

    public String getNrc(){
        return nrc;
    }

    public String getEe() {return ee; }

    public String getDocente() {
        return docente;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setIdOfertaAcademica(int idOfertaAcademica) {
        this.idOfertaAcademica = idOfertaAcademica;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public void setNrc(String nrc){
        this.nrc = nrc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocenteEEPrograma ofertaAcademica = (DocenteEEPrograma) o;
        return Objects.equals(ee, ofertaAcademica.ee)
                && Objects.equals(docente, ofertaAcademica.docente)
                && Objects.equals(programaEducativo, ofertaAcademica.programaEducativo);
    }

}
