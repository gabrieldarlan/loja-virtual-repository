import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection(ConstantesJDBC.URL, ConstantesJDBC.USER,
				ConstantesJDBC.PASSWORD);

		System.out.println("fechando conexao");

		connection.close();
	}
}
