package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bean.Aluno;
import br.com.jdbc.MySQLConnection;

public class AlunoDAO {

	private static Connection conexao = MySQLConnection.obterConexao();
	
	public void cadastrarAluno(Aluno aluno) {
		String dataNasc = null;
		String query = "INSERT INTO aluno(nome, dataNascimento, escola, contato) "
				+ "VALUES(?, ?, ?, ?) ";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(query);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date formatarData;
			try {
				formatarData = sdf.parse(aluno.getDataNasc());
				dataNasc = sdf.format(formatarData);
			} catch (ParseException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, dataNasc);
			stmt.setString(3, aluno.getEscola());
			stmt.setString(4, aluno.getContato());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERRO AO CADASTRAR ALUNO NO BANCO DE DADOS");
			System.err.println(e.getMessage());
		}
	}
}
