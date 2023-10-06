package br.com.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.Aluno;
import br.com.bean.EscalaEBIA;
import br.com.bean.EscalaKutcher;
import br.com.dao.AlunoDAO;
import br.com.dao.EscalaEBIADAO;
import br.com.dao.EscalaKutcherDAO;


@WebServlet("/cadastrarFormulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {
		Aluno aluno = new Aluno();
		EscalaKutcher kutcher = new EscalaKutcher();
		EscalaEBIA ebia = new EscalaEBIA();
		
		aluno.setNome(request.getParameter("name"));
		aluno.setDataNasc(request.getParameter("age"));
		aluno.setEscola(request.getParameter("school"));
		aluno.setContato(request.getParameter("phone"));
		
		kutcher.setKutcherUm(request.getParameter("question1"));
		kutcher.setKutcherDois(request.getParameter("question2"));
		kutcher.setKutcherTres(request.getParameter("question3"));
		kutcher.setKutcherQuatro(request.getParameter("question4"));
		kutcher.setKutcherCinco(request.getParameter("question5"));
		kutcher.setKutcherSeis(request.getParameter("question6"));
		kutcher.setKutcherSete(request.getParameter("question7"));
		kutcher.setKutcherOito(request.getParameter("question8"));
		kutcher.setKutcherNove(request.getParameter("question9"));
		kutcher.setKutcherDez(request.getParameter("question10"));
		kutcher.setKutcherOnze(request.getParameter("question11"));
		
		ebia.setEbiaUm(request.getParameter("question12"));
		ebia.setEbiaDois(request.getParameter("question13"));
		ebia.setEbiaTres(request.getParameter("question14"));
		ebia.setEbiaQuatro(request.getParameter("question15"));
		ebia.setEbiaCinco(request.getParameter("question16"));
		ebia.setEbiaSeis(request.getParameter("question17"));
		
		AlunoDAO alunoDAO = new AlunoDAO();
		EscalaEBIADAO ebiaDAO = new EscalaEBIADAO();
		EscalaKutcherDAO kutcherDAO = new EscalaKutcherDAO();
		
		alunoDAO.cadastrarAluno(aluno);
		ebiaDAO.cadastrarEbia(ebia);
		kutcherDAO.cadastrarKutcher(kutcher);
		
	}

}
