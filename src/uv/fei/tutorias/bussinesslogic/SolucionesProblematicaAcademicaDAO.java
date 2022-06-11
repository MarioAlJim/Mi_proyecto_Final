
package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.ProblematicaAcademica;
import org.apache.log4j.Logger;


/**
 *
 * @author Valea
 */
public class SolucionesProblematicaAcademicaDAO implements ISolucionesProblematicaAcademicaDAO{
    
    final static Logger log = Logger.getLogger( SolucionesProblematicaAcademicaDAO.class);
    
    
    @Override
    public List<ProblematicaAcademica> consultarTodasLasSoluciones() {
        ArrayList<ProblematicaAcademica> problematicasAcademicas= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutoriasproblematicasacademicas WHERE NOT solucion=' ' ;" ;
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron problematicas");
            }else{
                int idProblematicaAcademica;
                String descripcion;
                String solucion;
                int idDocentesEeProgramas;
                do {
                    idProblematicaAcademica = resultSet.getInt("IdProblemaAcademica");
                    descripcion = resultSet.getString("Descripcion");
                    solucion = resultSet.getString("Solucion");
                    idDocentesEeProgramas = resultSet.getInt("IdDocentesEEProgramas");
                    ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
                    problematicaAcademica.setIdProblematicaAcademica(idProblematicaAcademica);
                    problematicaAcademica.setDescripcion(descripcion);
                    problematicaAcademica.setSolucion(solucion);
                    problematicaAcademica.setIdDocenteEePrograma(idDocentesEeProgramas);
                    problematicasAcademicas.add(problematicaAcademica);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
              log.fatal(ex);
        }
        return problematicasAcademicas;
    }
    
    @Override
    public List<ProblematicaAcademica> consultarProblematicaPorId(int idProblematicaAcademicaBuscada) {
         ArrayList<ProblematicaAcademica> problematicasAcademicas= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutoriasproblematicasacademicas WHERE IdProblemaAcademica = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idProblematicaAcademicaBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron problematicas");
            }else{
                int idProblematicaAcademica;
                String descripcion;
                String solucion;
                int idDocentesEeProgramas;
                do {
                    idProblematicaAcademica = resultSet.getInt("IdProblemaAcademica");
                    descripcion = resultSet.getString("Descripcion");
                    solucion = resultSet.getString("Solucion");
                    idDocentesEeProgramas = resultSet.getInt("IdDocentesEEProgramas");
                    ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
                    problematicaAcademica.setIdProblematicaAcademica(idProblematicaAcademica);
                    problematicaAcademica.setDescripcion(descripcion);
                    problematicaAcademica.setSolucion(solucion);
                    problematicaAcademica.setIdDocenteEePrograma(idDocentesEeProgramas);
                    problematicasAcademicas.add(problematicaAcademica);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return problematicasAcademicas;
    }
     @Override
    public ProblematicaAcademica consultarProblematica(int idProblematicaAcademicaBuscada) {
       ProblematicaAcademica problematicaAcademica = new ProblematicaAcademica();
       DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutoriasproblematicasacademicas WHERE IdProblemaAcademica = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idProblematicaAcademicaBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron problematicas");
            }else{
                int idProblematicaAcademica;
                String descripcion;
                String solucion;
                int idDocentesEeProgramas;
                int idHorario;
                do {
                    idProblematicaAcademica = resultSet.getInt("IdProblemaAcademica");
                    descripcion = resultSet.getString("Descripcion");
                    solucion = resultSet.getString("Solucion");
                    idDocentesEeProgramas = resultSet.getInt("IdDocentesEEProgramas");
                    idHorario = resultSet.getInt("IdHorario");
                   
                    problematicaAcademica.setIdProblematicaAcademica(idProblematicaAcademica);
                    problematicaAcademica.setDescripcion(descripcion);
                    problematicaAcademica.setSolucion(solucion);
                    problematicaAcademica.setIdDocenteEePrograma(idDocentesEeProgramas);
                    
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
             log.fatal(ex);
        }
        return problematicaAcademica;
    }
    
    
     @Override
    public int registrarSolucionProblematicaAcademica(ProblematicaAcademica problematicaAcademica) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            int idProblematicaAcademica = problematicaAcademica.getIdProblematicaAcademica();
            String solucion = problematicaAcademica.getSolucion();
            String query =
               
                   ("UPDATE tutoriasproblematicasacademicas SET solucion= ?  WHERE IdProblemaAcademica = ?"  );
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,solucion);
            statement.setInt(2,idProblematicaAcademica);
            
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
             log.fatal(ex);
        }
        return filasInsertadas;
    }
    
    @Override 
    public int actualizarSolucionProblematica(ProblematicaAcademica problematicaAcademica) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasActualizadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            int idProblematicaAcademica = problematicaAcademica.getIdProblematicaAcademica();
            
            String solucion = problematicaAcademica.getSolucion();
            
            String query;
            query = 
                    ("UPDATE tutoriasproblematicasacademicas SET solucion = '" + solucion +
                     " WHERE IdProblemaAcademica = " + idProblematicaAcademica);
            PreparedStatement statement = connection.prepareStatement(query);
            filasActualizadas = statement.executeUpdate();
            System.out.println(filasActualizadas + " filas modificadas");
        } catch (SQLException ex) {
                log.fatal(ex);
                
        }
        return filasActualizadas;
    }

    @Override
    public int registrarSolucion(String solucion, int idProblematicaA) {
         DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            int idProblematicaAcademica = idProblematicaA;
            //String Solucion = solucion;
            String query =
               
                   ("UPDATE tutoriasproblematicasacademicas SET solucion= ?  WHERE IdProblemaAcademica = ?"  );
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,solucion);
            statement.setInt(2,idProblematicaAcademica);
            
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
             log.fatal(ex);
        }
        return filasInsertadas;
    }

   

    
}
