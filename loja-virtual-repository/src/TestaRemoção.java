import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemoção {

	public static void main(String[] args) throws SQLException {
		
	ConnectionFactory connectionFactory = new ConnectionFactory();
	Connection connection = connectionFactory.getConnection();
	
	Statement statement = connection.createStatement();
	statement.execute("DELETE FROM PRODUTO WHERE ID > 2");
	
	int linhasModificadas = statement.getUpdateCount();
	
	System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
	
	}
}
