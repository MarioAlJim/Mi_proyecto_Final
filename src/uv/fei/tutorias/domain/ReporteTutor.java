package uv.fei.tutorias.domain;

public class ReporteTutor {
    private int idsesion;
    private String periodo;
    private int  numTutoria;
    private int idTutoria;
    private String nombreTutor;
    private String fecha;
    private String programaeducativo;
    private String cuentaUv;
    private int idProgramaEducativo;


    public int getIdTutoria() {
        return idTutoria;
    }

    public void setIdTutoria(int idTutoria) {
        this.idTutoria = idTutoria;
    }

    public String getCuentaUv() {
        return cuentaUv;
    }

    public void setCuentaUv(String cuentaUv) {
        this.cuentaUv = cuentaUv;
    }

    public int getIdProgramaEducativo() {
        return idProgramaEducativo;
    }

    public void setIdProgramaEducativo(int idProgramaEducativo) {
        this.idProgramaEducativo = idProgramaEducativo;
    }

    public String getProgramaeducativo() {
        return programaeducativo;
    }

    public void setProgramaeducativo(String programaeducativo) {
        this.programaeducativo = programaeducativo;
    }
    

    public int getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(int idsesion) {
        this.idsesion = idsesion;
    }
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getNumTutoria() {
        return numTutoria;
    }

    public void setNumTutoria(int numTutoria) {
        this.numTutoria = numTutoria;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }
    
    
    
}
