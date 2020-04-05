<%@page import="dao.PacienteDao"%>
<%

	//IdProduto
	int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

	//Executar método
	PacienteDao pd = new PacienteDao();
	boolean situacao = pd.excluir(idPaciente);
	
	//Redirecionamento
	if(situacao == true){
		response.sendRedirect("../cadastroPaciente.jsp?mensagem=excluirOk");
	}else{
		response.sendRedirect("../cadastroPaciente.jsp?mensagem=excluirFalha");
	}

%>