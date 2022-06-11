
package uv.fei.tutorias.domain;

/**
 *
 * @author Valea
 */
public class ExperienciaEducativa {
    private int nrc; 
    private String nombre;

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNrc() {
        return nrc;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nrc + " - " + nombre;
    }
}
