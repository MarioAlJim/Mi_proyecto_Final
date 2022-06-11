/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.domain.DocenteEEPrograma;

import java.util.List;

public interface IDocenteEEProgramasDAO {
     public int asignarEEProfesor(int nrc, int numpersonal);

     public List<DocenteEEPrograma> obtenerOfertaAcademicaGeneral();

     public List<DocenteEEPrograma> consultarOfertaAcademicaPorProgramaEducativo(String programaEducativo);
}
