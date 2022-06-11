/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.tutorias.bussinesslogic;
import uv.fei.tutorias.domain.ProblematicaAcademica;
import java.util.List;
/**
 *
 * @author Valea
 */
public interface ISolucionesProblematicaAcademicaDAO {
    
    public List<ProblematicaAcademica> consultarTodasLasSoluciones();
    public List<ProblematicaAcademica> consultarProblematicaPorId(int idProblematicaAcademicaBuscada);
    public ProblematicaAcademica consultarProblematica(int idProblematicaAcademicaBuscada);
    public int registrarSolucionProblematicaAcademica(ProblematicaAcademica problematicaAcademica);
    public int registrarSolucion(String solucion, int idProblematicaA);
    public int actualizarSolucionProblematica(ProblematicaAcademica problematicaAcademica);
    
}
