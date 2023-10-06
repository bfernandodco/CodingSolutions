package br.com.bean;

public class Aluno {

	private int idAluno;
	private String nome;
	private String escola;
	private String dataNasc;
	private String contato;
	
	public Aluno() {
		
	}

	public Aluno(int idAluno, String nome, String escola, String dataNasc, String contato) {
		this.idAluno = idAluno;
		this.nome = nome;
		this.escola = escola;
		this.dataNasc = dataNasc;
		this.contato = contato;
		
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}
	
}
