<%@page import="java.io.Console"%>
<%@page import="beans.MedicoBean"%>
<%@page import="dao.MedicoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    	//Obter e-mail e senha
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	
    	//Validar o login
    	MedicoDao u = new MedicoDao();
    	int contador = u.verificarLogin(email, senha);
    	
    	//Condicional
    	if(contador == 0){
    		response.sendRedirect("../index.jsp?mensagem=falhaLogin");
    	}if(contador == 1){
    		MedicoBean ub = u.dadosUsuario(email, senha);
    		session.setAttribute("admin", ub);
    		response.sendRedirect("../admin.jsp");
    	}else{
    		MedicoBean ub = u.dadosUsuario(email, senha);
    		session.setAttribute("medico", ub);
    		response.sendRedirect("../medico.jsp");
    	}
    %>