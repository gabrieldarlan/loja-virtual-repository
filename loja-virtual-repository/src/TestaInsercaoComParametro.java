import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		String nome = "Televisao";
		String descricao = "Televisao Grande";

		PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, nome);
		statement.setString(2, descricao);
		statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}
}
