/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.tutorias.domain;

import java.util.Objects;

/**
 *
 * @author Valea
 */
public class TutorTutorado {
    
    private int  idTutorTutoria;
    private String CuentaUv;
    private String Matricula;
  

    public void setIdTutorTutorado(int idTutorTutoria) {
        this.idTutorTutoria = idTutorTutoria;
    }

    public void setCuentaUv(String CuentaUv) {
        this.CuentaUv = CuentaUv;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }
    
    
     public int getIdTutorTutoria() {
        return idTutorTutoria;
    }

    public String getCuentaUv() {
        return CuentaUv;
    }

    public String getMatricula() {
        return Matricula;
    }
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorTutorado that = (TutorTutorado) o;
        return idTutorTutoria == that.idTutorTutoria && Objects.equals(CuentaUv, that.CuentaUv) && Objects.equals(Matricula, that.Matricula);
    }
}
