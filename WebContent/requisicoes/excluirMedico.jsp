<%@page import="dao.MedicoDao"%>
<%

	//IdProduto
	int idMedico = Integer.parseInt(request.getParameter("idMedico"));

	//Executar método
	MedicoDao pd = new MedicoDao();
	boolean situacao = pd.excluir(idMedico);
	
	//Redirecionamento
	if(situacao == true){
		response.sendRedirect("../cadastroMedico.jsp?mensagem=excluirOk");
	}else{
		response.sendRedirect("../cadastroMedico.jsp?mensagem=excluirFalha");
	}

%>