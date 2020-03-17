import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemoção {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		prepareStatement.setInt(1, 2);
		prepareStatement.execute();
		
		Integer linhasModificadas = prepareStatement.getUpdateCount();

		System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);

	}
}
