package uv.fei.tutorias.bussinesslogic;

import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Docente;

import java.sql.*;
import java.util.ArrayList;

public class DocenteDAO implements IDocentesDAO{


    @Override
    public ArrayList<Docente> recuperarDocentesPorProgramaEducativo(int idPrograma) throws SQLException {
        ArrayList<Docente> docentes = new ArrayList();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String query = ("SELECT d.NumPersonal, concat_ws(' ', d.Nombre, APellidoPaterno, APellidoMaterno) Nombre FROM docentes d " +
                "inner join docenteseeprogramas deep on deep.NumPersonal = d.NumPersonal " +
                "where deep.IdProgramaEducativo = ? " +
                "GROUP BY d.NumPersonal;");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idPrograma);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            int numPersonal;
            String nombre;
            do {
                numPersonal = resultSet.getInt("NumPersonal");
                nombre = resultSet.getString("Nombre");
                Docente docente = new Docente();
                docente.setNumPersonal(numPersonal);
                docente.setNombre(nombre);
                docentes.add(docente);
            }while(resultSet.next());
        }
        return docentes;
    }
}
