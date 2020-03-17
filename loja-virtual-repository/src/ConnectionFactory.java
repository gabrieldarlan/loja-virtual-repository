import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(ConstantesJDBC.URL, ConstantesJDBC.USER,
				ConstantesJDBC.PASSWORD);
		return connection;
	}
}
