<%@page import="dao.ProdutoDao"%>
<%@page import="beans.ProdutoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	//Obter dados
	String nome = request.getParameter("nome");
	String descricao = request.getParameter("descricao");
	int validade = Integer.parseInt(request.getParameter("validade"));
	int quantidade = Integer.parseInt(request.getParameter("quantidade"));
	double valor = Double.parseDouble(request.getParameter("valor"));
	int idCentro = Integer.parseInt(request.getParameter("idCentro"));
	int idEstoque = Integer.parseInt(request.getParameter("idEstoque"));
	
	//ProdutoBean
	ProdutoBean pb = new ProdutoBean();
	pb.setNomeItem(nome);
	pb.setDescricaoItem(descricao);
	pb.setValidadeItem(validade);;
	pb.setQuantidadeItem(quantidade);;
	pb.setValorItem(valor);;
	pb.setIdCentroAtendimento(idCentro);
	pb.setIdEstoque(idEstoque);
	
	
	//ProdutoDao
	ProdutoDao pd = new ProdutoDao();
	boolean valida = pd.alterar(pb);
	
	//Redirecionamento
	if(valida == true) {
		response.sendRedirect("../cadastroProduto.jsp?mensagem=alterarOk");
	}else{
		response.sendRedirect("../cadastroProduto.jsp?mensagem=alterarFalha");
	}
%>