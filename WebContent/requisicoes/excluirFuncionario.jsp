<%@page import="dao.FuncionarioDao"%>
<%

	//IdProduto
	int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));

	//Executar método
	FuncionarioDao pd = new FuncionarioDao();
	boolean situacao = pd.excluir(idFuncionario);
	
	//Redirecionamento
	if(situacao == true){
		response.sendRedirect("../cadastroFuncionario.jsp?mensagem=excluirOk");
	}else{
		response.sendRedirect("../cadastroFuncionario.jsp?mensagem=excluirFalha");
	}

%>