package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppException;

public abstract class SQLiteDataHelper {

    private static String DBPathConnection = "jdbc:sqlite:database\\gestion_estudiantes.db"; // null;
    private static Connection conn = null;

    public SQLiteDataHelper() {

    }

    public static synchronized Connection openConnection() throws AppException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DBPathConnection);
            }
        } catch (SQLException e) {
            throw new AppException(e, "SQLiteDataHelper", "Fallo la coneccion a la base de datos");
        }
        return conn;
    }

    protected static void closeConnection() throws AppException {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw new AppException(e, "SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }

    protected static void closeResources(ResultSet resultSet, PreparedStatement statement, Connection connection) throws AppException {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new AppException(e, "SQLiteDataHelper", "Error al cerrar el ResultSet");
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new AppException(e, "SQLiteDataHelper", "Error al cerrar el PreparedStatement");
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new AppException(e, "SQLiteDataHelper", "Error al cerrar la Connection");
            }
        }
    }
}