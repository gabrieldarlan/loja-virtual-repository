package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());

			preparedStatement.execute();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				while (resultSet.next()) {
					produto.setId(resultSet.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";

		try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
			prepareStatement.execute();

			try (ResultSet resultSet = prepareStatement.getResultSet()) {
				while (resultSet.next()) {
					Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

}
