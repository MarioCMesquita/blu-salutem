<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    	//Excluir a sessão
    	session.removeAttribute("usuario");
    	
    	//Redirecionar para a página inicial
    	response.sendRedirect("index.jsp");
    
    %>