package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.bean.EscalaKutcher;
import br.com.jdbc.MySQLConnection;

public class EscalaKutcherDAO {
	
	private static Connection conexao = MySQLConnection.obterConexao();
	
	public void cadastrarKutcher(EscalaKutcher kutcher) {
		
		String query = "INSERT INTO escalakutcher(kutcherum, kutcherdois, kutchertres,"
				+ " kutcherquatro, kutchercinco, kutcherseis, kutchersete, kutcheroito,"
				+ "kutchernove, kutcherdez, kutcheronze) VALUES("
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(query);
			stmt = conexao.prepareStatement(query);
			
			stmt.setInt(1, Integer.parseInt(kutcher.getKutcherUm()));
			stmt.setInt(2, Integer.parseInt(kutcher.getKutcherDois()));
			stmt.setInt(3, Integer.parseInt(kutcher.getKutcherTres()));
			stmt.setInt(4, Integer.parseInt(kutcher.getKutcherQuatro()));
			stmt.setInt(5, Integer.parseInt(kutcher.getKutcherCinco()));
			stmt.setInt(6, Integer.parseInt(kutcher.getKutcherSeis()));
			stmt.setInt(7, Integer.parseInt(kutcher.getKutcherSete()));
			stmt.setInt(8, Integer.parseInt(kutcher.getKutcherOito()));
			stmt.setInt(9, Integer.parseInt(kutcher.getKutcherNove()));
			stmt.setInt(10, Integer.parseInt(kutcher.getKutcherDez()));
			stmt.setInt(11, Integer.parseInt(kutcher.getKutcherOnze()));
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERRO AO CADASTRAR ESCALA KUTCHER");
			System.err.println(e.getMessage());
			
		}
	}

}
