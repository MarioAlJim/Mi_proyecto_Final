
package uv.fei.tutorias.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Docente;
import uv.fei.tutorias.domain.ExperienciaEducativa;
import uv.fei.tutorias.domain.TutorTutorado;


/**
 *
 * @author Valea
 */
public class TutorTutoradoDAO implements ITutorTutoradoDAO {
    
     @Override
    public int asignarTutorTutorado(String cuentauv, String Matricula) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int filasInsertadas = 0;
        try(Connection connection=dataBaseConnection.getConnection()){
            String CuentaUV=cuentauv;
            String matricula =Matricula;
            
            String query =
                 
                   //  ("UPDATE tutoriasproblematicasacademicas SET solucion= ?  WHERE IdProblemaAcademica = ?"  );
                    ("INSERT INTO tutores_tutorados (CuentaUV, Matricula) VALUES (?,?) " );
           
            PreparedStatement statement = connection.prepareStatement(query);
             
            statement.setString(1,CuentaUV);
            statement.setString(2,matricula);
            
            
            filasInsertadas = statement.executeUpdate();
            System.out.println(filasInsertadas + " Fila insertada ");
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasInsertadas;
    }
    @Override
       public List<TutorTutorado> consultarTutoresTutoradosporId(int idTutorTutoradoBuscada) {
        ArrayList<TutorTutorado> tutoresTutorados= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query="SELECT * FROM tutores_tutorados WHERE IdTutorTutorado = ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, idTutorTutoradoBuscada);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron problematicas");
            }else{
                int idTutorTutorado;
                String matricula;
                String cuentauv;
               
                do {
                    idTutorTutorado = resultSet.getInt("IdProblemaAcademica");
                    matricula = resultSet.getString("Descripcion");
                    cuentauv= resultSet.getString("Solucion");
                    TutorTutorado tutorTutorado= new TutorTutorado ();
                   
                    tutorTutorado.setIdTutorTutorado(idTutorTutorado);
                    tutorTutorado.setCuentaUv(cuentauv);
                    tutorTutorado.setMatricula(matricula);
                   
                    tutoresTutorados.add(tutorTutorado);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tutoresTutorados;
    }

    @Override
    public ArrayList<Docente> consultarTodosDocentes() {
        ArrayList<Docente> docentes= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
           /* String query="SELECT * FROM docentes;"; */
            String query= "SELECT concat (nombre, ' ',apellidopaterno, ' ', apellidomaterno)as nombre, numpersonal, correo FROM docentes;";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron docentes");
            }else{
                 int numpersonal;
                 String nombre;
                 String correo;
                
                do {
                   
                  
                    numpersonal=resultSet.getInt("NumPersonal");
                    
                    nombre = resultSet.getString("Nombre");
                  
                    correo=resultSet.getString("Correo");
                    
                    
                    
                    
                    Docente docente = new Docente();
                    docente.setNumPersonal(numpersonal);
                    docente.setNombre(nombre);
                   
                    docente.setNombre(nombre);
                 
                    docente.setCorreo(correo);
                    
                    
                    
                    docentes.add(docente);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docentes;
    }

}
