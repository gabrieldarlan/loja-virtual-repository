import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recuperarConexao() throws SQLException {
		Connection connection = DriverManager.getConnection(ConstantesJDBC.URL, ConstantesJDBC.USER,
				ConstantesJDBC.PASSWORD);
		return connection;
	}
}
