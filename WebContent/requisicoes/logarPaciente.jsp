<%@page import="beans.PacienteBean"%>
<%@page import="dao.PacienteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    	//Obter e-mail e senha
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	
    	//Validar o login
    	PacienteDao u = new PacienteDao();
    	int contador = u.verificarLogin(email, senha);
    	
    	//Condicional
    	if(contador == 0){
    		response.sendRedirect("../index.jsp?mensagem=falhaLogin");
    	}else{
    		PacienteBean ub = u.dadosUsuario(email, senha);
    		session.setAttribute("paciente", ub);
    		response.sendRedirect("../paciente.jsp");
    	}
    %>