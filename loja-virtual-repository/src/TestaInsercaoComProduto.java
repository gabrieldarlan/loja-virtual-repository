import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.dao.ProdutoDao;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			ProdutoDao persistenciaProduto = new ProdutoDao(connection);
			persistenciaProduto.salvar(comoda);
			
			//List
		}

	}
}
