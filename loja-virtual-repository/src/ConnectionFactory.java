import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	// construtor criado para gerenciar pool de conexao
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(ConstantesJDBC.URL);
		comboPooledDataSource.setUser(ConstantesJDBC.USER);
		comboPooledDataSource.setPassword(ConstantesJDBC.PASSWORD);
	
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource;
	}

	// abre conexao com banco de dados
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
}
