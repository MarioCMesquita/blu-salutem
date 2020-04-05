<%@page import="dao.FuncionarioDao"%>
<%@page import="beans.FuncionarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	//Obter dados
	String nome = request.getParameter("nome");
	String rg = request.getParameter("rg");
	String cpf = request.getParameter("cpf");
	String email = request.getParameter("email");
	String telefone = request.getParameter("telefone");
	String endereco = request.getParameter("endereco");
	String senha = request.getParameter("senha");
	int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
	int segmento = Integer.parseInt(request.getParameter("segmento"));
	
	//ProdutoBean
	FuncionarioBean fb = new FuncionarioBean();
	fb.setNomeFuncionario(nome);
	fb.setRgFuncionario(rg);
	fb.setCpfFuncionario(cpf);;
	fb.setEmailFuncionario(email);;
	fb.setTelefoneFuncionario(telefone);;
	fb.setEnderecoFuncionario(endereco);
	fb.setSenhaFuncionario(senha);
	fb.setIdFuncionario(idFuncionario);
	fb.setIdSegmentoFuncionario(segmento);
	
	
	//ProdutoDao
	FuncionarioDao fd = new FuncionarioDao();
	boolean valida = fd.alterar(fb);
	
	//Redirecionamento
	if(valida == true) {
		response.sendRedirect("../cadastroFuncionario.jsp?mensagem=alterarOk");
	}else{
		response.sendRedirect("../cadastroFuncionario.jsp?mensagem=alterarFalha");
	}
%>