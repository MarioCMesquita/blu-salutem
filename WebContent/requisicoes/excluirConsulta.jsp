<%@page import="dao.ConsultaDao"%>
<%

	//IdProduto
	int idConsulta = Integer.parseInt(request.getParameter("idConsulta"));

	//Executar m�todo
	ConsultaDao pd = new ConsultaDao();
	boolean situacao = pd.excluir(idConsulta);
	
	//Redirecionamento
	if(situacao == true){
		response.sendRedirect("../cadastroConsulta.jsp?mensagem=excluirOk");
	}else{
		response.sendRedirect("../cadastroConsulta.jsp?mensagem=excluirFalha");
	}

%>