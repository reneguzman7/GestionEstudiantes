package DataBase;

import BusinessLogic.Inscripcion;
import Framework.AppException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionInscripcionDTO {
    public List<Inscripcion> cargarInscripciones(int startIndex, int pageSize) throws AppException {
        List<Inscripcion> inscripciones = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = SQLiteDataHelper.openConnection(); // Open the connection here

            String sql = "SELECT C.nombre AS curso_nombre, E.nombre AS estudiante_nombre " +
                    "FROM Curso AS C " +
                    "INNER JOIN Inscripcion AS I ON C.id = I.idCurso " +
                    "INNER JOIN Estudiante AS E ON E.id = I.idEstudiante " +
                    "LIMIT ? OFFSET ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, pageSize);
            statement.setInt(2, startIndex * pageSize);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdCurso(Integer.parseInt(resultSet.getString("curso_nombre")));
                inscripcion.setIdEstudiante(Integer.parseInt(resultSet.getString("estudiante_nombre")));
                inscripciones.add(inscripcion);
            }
        } catch (SQLException e) {
            throw new AppException(e, "GestionInscripcionDTO", "Fallo al cargar las inscripciones desde la base de datos");
        } catch (AppException e) {
            throw new RuntimeException(e);
        } finally {
            SQLiteDataHelper.closeResources(resultSet, statement, conn); // Close the connection here
        }

        return inscripciones;
    }

    public void agregarInscripcion(Inscripcion inscripcion) throws AppException {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = SQLiteDataHelper.openConnection(); // Open the connection here

            String sql = "INSERT INTO Inscripcion (idCurso, idEstudiante) VALUES (?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, inscripcion.getIdCurso());
            statement.setInt(2, inscripcion.getIdEstudiante());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new AppException(e, "GestionInscripcionDTO", "Fallo al agregar la inscripción en la base de datos");
        } finally {
            SQLiteDataHelper.closeResources(null, statement, conn); // Close the connection here
        }
    }

    public void eliminarInscripcion(int inscripcionId) throws AppException {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = SQLiteDataHelper.openConnection(); // Open the connection here

            String sql = "DELETE FROM Inscripcion WHERE id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, inscripcionId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new AppException(e, "GestionInscripcionDTO", "Fallo al eliminar la inscripción de la base de datos");
        } finally {
            SQLiteDataHelper.closeResources(null, statement, conn); // Close the connection here
        }
    }




        public int countInscripciones() throws AppException {
            int count = 0;

            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                conn = SQLiteDataHelper.openConnection(); // Open the connection here

                String sql = "SELECT COUNT(*) FROM Inscripcion";
                statement = conn.prepareStatement(sql);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                throw new AppException(e, "GestionInscripcionDTO", "Fallo al contar las inscripciones en la base de datos");
            } finally {
                SQLiteDataHelper.closeResources(resultSet, statement, conn); // Close the connection here
            }

            return count;
        }


}
