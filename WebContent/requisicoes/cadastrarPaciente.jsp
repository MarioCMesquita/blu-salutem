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
    	
    	
    	//PacienteBean
    	PacienteBean fb = new PacienteBean();
    	fb.setNomePaciente(nome);
    	fb.setRgPaciente(rg);
    	fb.setCpfPaciente(cpf);
    	fb.setEmailPaciente(email);
    	fb.setTelefonePaciente(telefone);
    	fb.setEnderecoPaciente(endereco);
    	fb.setSenhaPaciente(senha);
    	
    	//PacienteDao
    	PacienteDao fd = new PacienteDao();
    	boolean valida = fd.cadastrar(fb);
    	
    	//Redirecionamento
    	if(valida == true){
    		response.sendRedirect("../cadastroPaciente.jsp?mensagem=cadastroOk");
    	}else{
    		response.sendRedirect("../cadastroPaciente.jsp?mensagem=cadastroFalha");
    	}
    %>