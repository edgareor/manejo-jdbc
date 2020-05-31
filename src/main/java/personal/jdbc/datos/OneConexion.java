package personal.jdbc.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class OneConexion {

	// Configurar Pool de Conexiones
	public static DataSource getDataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("admin");

		ds.setInitialSize(10); // Definimos el tama�o del pool de conexiones

		return ds;
	}

	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void close(PreparedStatement smtp) {
		try {
			smtp.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
