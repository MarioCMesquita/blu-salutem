<%@page import="beans.FuncionarioBean"%>
<%@page import="dao.FuncionarioDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    	//Obter e-mail e senha
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	
    	//Validar o login
    	FuncionarioDao u = new FuncionarioDao();
    	int contador = u.verificarLogin(email, senha);
    	
    	//Condicional
    	if(contador == 0){
    		response.sendRedirect("../index.jsp?mensagem=falhaLogin");
    	}else{
    		FuncionarioBean ub = u.dadosUsuario(email, senha);
    		session.setAttribute("funcionario", ub);
    		response.sendRedirect("../funcionario.jsp");
    	}
    %>