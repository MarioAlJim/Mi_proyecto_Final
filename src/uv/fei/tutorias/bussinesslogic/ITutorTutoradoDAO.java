/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.domain.ExperienciaEducativa;
import uv.fei.tutorias.domain.TutorTutorado;
import uv.fei.tutorias.domain.Docente;


/**
 *
 * @author Valea
 */
public interface ITutorTutoradoDAO {
 
    public int asignarTutorTutorado(String cuentauv, String Matricula);
    public List<TutorTutorado> consultarTutoresTutoradosporId (int idTutorTutorado);
    public ArrayList<Docente> consultarTodosDocentes();

    
}
