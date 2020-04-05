<%@page import="dao.PacienteDao"%>
<%@page import="beans.PacienteBean"%>
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
	int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
	
	//ProdutoBean
	PacienteBean fb = new PacienteBean();
	fb.setNomePaciente(nome);
	fb.setRgPaciente(rg);
	fb.setCpfPaciente(cpf);;
	fb.setEmailPaciente(email);;
	fb.setTelefonePaciente(telefone);;
	fb.setEnderecoPaciente(endereco);
	fb.setSenhaPaciente(senha);
	fb.setIdPaciente(idPaciente);
	
	
	//ProdutoDao
	PacienteDao fd = new PacienteDao();
	boolean valida = fd.alterar(fb);
	
	//Redirecionamento
	if(valida == true) {
		response.sendRedirect("../cadastroPaciente.jsp?mensagem=alterarOk");
	}else{
		response.sendRedirect("../cadastroPaciente.jsp?mensagem=alterarFalha");
	}
%>