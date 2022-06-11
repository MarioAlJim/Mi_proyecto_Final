package uv.fei.tutorias.bussinesslogic;

import org.apache.log4j.Logger;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.ProgramaEducativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramaEducativoDAO implements IProgramaEducativoDAO{

    final static Logger log = Logger.getLogger(ProgramaEducativoDAO.class);

    @Override
    public ArrayList<ProgramaEducativo> consultarTodosLosProgramasEducativos() {
        ArrayList<ProgramaEducativo> programasEducativos= new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            String query= ("SELECT * FROM sistematutoriasfei.programaseducativos");
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (!resultSet.next()){
                throw new SQLException("No se encontraron datos");
            }else{
                int idProgramaEducativo;
                String nombre;
                do {
                    idProgramaEducativo = resultSet.getInt("IdProgramaEducativo");
                    nombre = resultSet.getString("Nombre");
                    ProgramaEducativo programaEducativo = new ProgramaEducativo();
                    programaEducativo.setIdProgramaEducativo(idProgramaEducativo);
                    programaEducativo.setNombre(nombre);
                    programasEducativos.add(programaEducativo);
                }while (resultSet.next());
            }
        }catch (SQLException ex) {
            log.fatal(ex);
        }
        return programasEducativos;
    }
}
