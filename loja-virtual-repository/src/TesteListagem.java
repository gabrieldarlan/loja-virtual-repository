import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		PreparedStatement prepareStatement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		prepareStatement.execute();

		ResultSet rst = prepareStatement.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
		
		prepareStatement.close();
		connection.close();
	}
}
