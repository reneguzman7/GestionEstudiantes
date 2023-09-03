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

    public List<Estudiante> cargarEstudiantes(int startIndex, int pageSize) throws AppException {
        List<Estudiante> estudiantes = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
    
        try {
            conn = SQLiteDataHelper.openConnection(); // Abre la conexión aquí
    
            String sql = "SELECT id, nombre, edad FROM Estudiante LIMIT ? OFFSET ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, pageSize);
            statement.setInt(2, startIndex * pageSize);
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
            SQLiteDataHelper.closeResources(resultSet, statement, conn); // Cierra la conexión aquí
        }
    
        return estudiantes;
    }
    
    

    public List<Curso> cargarCursos(int startIndex, int pageSize) throws AppException {
        List<Curso> cursos = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
    
        try {
            conn = SQLiteDataHelper.openConnection(); // Abre la conexión aquí
    
            String sql = "SELECT id, nombre, descripcion FROM Curso LIMIT ? OFFSET ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, pageSize);
            statement.setInt(2, startIndex * pageSize);
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
            SQLiteDataHelper.closeResources(resultSet, statement, conn); // Cierra la conexión aquí
        }
    
        return cursos;
    }
    
    public int countEstudiantes() throws AppException {
        int count = 0;
    
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
    
        try {
            conn = SQLiteDataHelper.openConnection(); // Abre la conexión aquí
    
            String sql = "SELECT COUNT(*) FROM Estudiante";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
    
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new AppException(e, "GestionEstudianteDTO", "Fallo al contar los estudiantes en la base de datos");
        } finally {
            SQLiteDataHelper.closeResources(resultSet, statement, conn); // Cierra la conexión aquí
        }
    
        return count;
    }
    
    public int countCursos() throws AppException {
        int count = 0;
    
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
    
        try {
            conn = SQLiteDataHelper.openConnection(); // Abre la conexión aquí
    
            String sql = "SELECT COUNT(*) FROM Curso";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
    
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new AppException(e, "GestionEstudianteDTO", "Fallo al contar los cursos en la base de datos");
        } finally {
            SQLiteDataHelper.closeResources(resultSet, statement, conn); // Cierra la conexión aquí
        }
    
        return count;
    }
    
    
}