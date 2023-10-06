package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	private static final String url = "jdbc:mysql://localhost:3306/hackathlon";
	private static final String user = "root";
	private static final String password = "fiapalura";
	
	public static Connection obterConexao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DRIVER ENCONTRADO");
		} catch(ClassNotFoundException e) {
			System.out.println("DRIVER NÃO ENCONTRADO");
			System.err.println(e.getMessage());
		}
		
		try {
			Connection conexao = DriverManager.getConnection(url, user, password);
			System.out.println("CONEXÃO ESTABELECIDA");
			return conexao;
		} catch (SQLException e) {
			System.out.println("CONEXÃO NÃO ESTABELECIDA");
			System.err.println(e.getMessage());
			return null;
		}
		
	}
}
