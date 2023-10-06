package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.bean.EscalaEBIA;
import br.com.jdbc.MySQLConnection;

public class EscalaEBIADAO {

	private static Connection conexao = MySQLConnection.obterConexao();
			
	public void cadastrarEbia(EscalaEBIA ebia) {
		
		String query = "INSERT INTO escalaebia(ebiaum, ebiadois, ebiatres, ebiaquatro, ebiacinco,"
				+ "ebiaseis) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(query);
			
			stmt.setInt(1, Integer.parseInt(ebia.getEbiaUm()));
			stmt.setInt(2, Integer.parseInt(ebia.getEbiaDois()));
			stmt.setInt(3, Integer.parseInt(ebia.getEbiaTres()));
			stmt.setInt(4, Integer.parseInt(ebia.getEbiaQuatro()));
			stmt.setInt(5, Integer.parseInt(ebia.getEbiaCinco()));
			stmt.setInt(6, Integer.parseInt(ebia.getEbiaSeis()));
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERRO AO CADASTRAR ESCALA EBIA NO BANCO DE DADOS");
			System.err.println(e.getMessage());
		}
	}
}
