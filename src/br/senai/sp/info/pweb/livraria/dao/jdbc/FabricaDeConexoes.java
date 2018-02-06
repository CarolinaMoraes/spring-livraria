package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	
	private Connection conexao;
	
	public void abrir() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		final String USUARIO = "root";
		final String SENHA = "root";
		
		String sql = "jdbc:mysql://localhost:3306/livraria?serverTimezone=UTC";
		
		conexao = DriverManager.getConnection(sql, USUARIO, SENHA);	
	}
	
	public void fechar() {
		if(conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {}
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}

}
