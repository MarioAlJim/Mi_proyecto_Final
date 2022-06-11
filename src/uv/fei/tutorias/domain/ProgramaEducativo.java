package uv.fei.tutorias.domain;

/**
 *
 * @author SILVERWOLF
 */
public class ProgramaEducativo {
    private int idProgramaEducativo;
    private String nombre;


    public int getIdProgramaEducativo() {
        return idProgramaEducativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdProgramaEducativo(int idProgramaEducativo) {
        this.idProgramaEducativo = idProgramaEducativo;
    }
}
