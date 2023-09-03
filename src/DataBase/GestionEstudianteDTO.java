package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BusinessLogic.Estudiante;
import BusinessLogic.Curso;
import Framework.AppException;

public class GestionEstudianteDTO {

    public List<Estudiante> cargarEstudiantes() throws AppException {
        List<Estudiante> estudiantes = new ArrayList<>();

        Connection conn = SQLiteDataHelper.openConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT id, nombre, edad FROM Estudiante";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(resultSet.getInt("id"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setEdad(resultSet.getInt("edad"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            throw new AppException(e, "GestionEstudianteDTO", "Fallo al cargar los estudiantes desde la base de datos");
        } finally {
            SQLiteDataHelper.closeResources(resultSet, statement, conn);
        }

        return estudiantes;
    }

    public List<Curso> cargarCursos() throws AppException {
        List<Curso> cursos = new ArrayList<>();
    
        Connection conn = SQLiteDataHelper.openConnection(); // Abre la conexión
    
        PreparedStatement statement = null;
        ResultSet resultSet = null;
    
        try {
            String sql = "SELECT id, nombre, descripcion FROM Curso";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
    
            while (resultSet.next()) {
                Curso curso = new Curso();
                curso.setId(resultSet.getInt("id"));
                curso.setNombre(resultSet.getString("nombre"));
                curso.setDescripcion(resultSet.getString("descripcion"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new AppException(e, "GestionEstudianteDTO", "Fallo al cargar los cursos desde la base de datos");
        } finally {
            SQLiteDataHelper.closeResources(resultSet, statement, conn); // Cierra la conexión
        }
    
        return cursos;
    }
    
}