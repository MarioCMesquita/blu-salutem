<%@page import="dao.ProdutoDao"%>
<%

	//IdProduto
	int idEstoque = Integer.parseInt(request.getParameter("idEstoque"));

	//Executar método
	ProdutoDao pd = new ProdutoDao();
	boolean situacao = pd.excluir(idEstoque);
	
	//Redirecionamento
	if(situacao == true){
		response.sendRedirect("../cadastroProduto.jsp?mensagem=excluirOk");
	}else{
		response.sendRedirect("../cadastroProduto.jsp?mensagem=excluirFalha");
	}

%>