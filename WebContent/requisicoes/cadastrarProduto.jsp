<%@page import="dao.ProdutoDao"%>
<%@page import="beans.ProdutoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
    	//Obter dados
    	String produto = request.getParameter("produto");
    	String descricao = request.getParameter("descricao");
    	int validade = Integer.parseInt(request.getParameter("validade"));
    	int quantidade = Integer.parseInt(request.getParameter("quantidade"));
    	double valor = Double.parseDouble(request.getParameter("valor"));
    	int idCentro = Integer.parseInt(request.getParameter("idCentro"));
    	
    	//ProdutoBean
    	ProdutoBean pb = new ProdutoBean();
    	pb.setNomeItem(produto);
    	pb.setDescricaoItem(descricao);
    	pb.setValidadeItem(validade);;
    	pb.setQuantidadeItem(quantidade);;
    	pb.setValorItem(valor);;
    	pb.setIdCentroAtendimento(idCentro);
    	
    	//ProdutoDao
    	ProdutoDao fd = new ProdutoDao();
    	boolean valida = fd.cadastrar(pb);
    	
    	//Redirecionamento
    	if(valida == true){
    		response.sendRedirect("../cadastroProduto.jsp?mensagem=cadastroOk");
    	}else{
    		response.sendRedirect("../cadastroProduto.jsp?mensagem=cadastroFalha");
    	}
    %>