<%@page import="beans.FuncionarioBean"%>
<%@page import="dao.FuncionarioDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    	//Obter dados
    	String nome = request.getParameter("nome");
    	String rg = request.getParameter("rg");
    	String cpf = request.getParameter("cpf");
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	String telefone = request.getParameter("telefone");
    	String endereco = request.getParameter("endereco");
    	int segmento = Integer.parseInt(request.getParameter("segmento"));
    	
    	//FuncionarioBean
    	FuncionarioBean fb = new FuncionarioBean();
    	fb.setNomeFuncionario(nome);
    	fb.setRgFuncionario(rg);
    	fb.setCpfFuncionario(cpf);
    	fb.setEmailFuncionario(email);
    	fb.setSenhaFuncionario(senha);
    	fb.setTelefoneFuncionario(telefone);
    	fb.setEnderecoFuncionario(endereco);
    	fb.setIdSegmentoFuncionario(segmento);
    	
    	//FuncionarioDao
    	FuncionarioDao fd = new FuncionarioDao();
    	boolean valida = fd.cadastrar(fb);
    	
    	//Redirecionamento
    	if(valida == true){
    		response.sendRedirect("../cadastroFuncionario.jsp?mensagem=cadastroOk");
    	}else{
    		response.sendRedirect("../cadastroFuncionario.jsp?mensagem=cadastroFalha");
    	}
    %>