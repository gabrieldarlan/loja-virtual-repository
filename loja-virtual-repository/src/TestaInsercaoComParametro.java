import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.getConnection()){
			connection.setAutoCommit(false);
	
			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);) {
				adicionarVariavel("SmarTv", "45 polegadas", statement);
				adicionarVariavel("Radio", "Radio de bateria", statement);
				connection.commit();
	
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
			System.out.println("FECHANDO CONEXAO");
			connection.close();
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement)
			throws SQLException {
		statement.setString(1, nome);
		statement.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("N�o foi possivel adicionar o produto");
		}

		statement.execute();

		try (ResultSet resultSet = statement.getGeneratedKeys()) {
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}

	}
}
