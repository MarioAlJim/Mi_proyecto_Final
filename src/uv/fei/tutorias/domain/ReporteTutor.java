package uv.fei.tutorias.domain;

public class ReporteTutor {
    private int idsesion;
    private String periodo;
    private int  numTutoria; 
    private String nombreTutor;
    private String fecha;
    private String programaeducativo;

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
