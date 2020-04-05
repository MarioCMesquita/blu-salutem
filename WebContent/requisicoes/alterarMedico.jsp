<%@page import="dao.MedicoDao"%>
<%@page import="beans.MedicoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	//Obter dados
	String nome = request.getParameter("nome");
	String rg = request.getParameter("rg");
	String cpf = request.getParameter("cpf");
	String crm = request.getParameter("crm");
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	String telefone = request.getParameter("telefone");
	String endereco = request.getParameter("endereco");
	int idMedico = Integer.parseInt(request.getParameter("idMedico"));
	int segmento = Integer.parseInt(request.getParameter("segmento"));
	int centro = Integer.parseInt(request.getParameter("centro"));
	int estado = Integer.parseInt(request.getParameter("estado"));
	
	//ProdutoBean
	MedicoBean fb = new MedicoBean();
	fb.setNomeMedico(nome);
	fb.setRgMedico(rg);
	fb.setCpfMedico(cpf);;
	fb.setCrmMedico(crm);;
	fb.setEmailMedico(email);;
	fb.setTelefoneMedico(telefone);;
	fb.setEnderecoMedico(endereco);
	fb.setSenhaMedico(senha);
	fb.setIdMedico(idMedico);
	fb.setIdSegmentoMedico(segmento);
	fb.setIdCentroAtendimento(centro);
	fb.setIdEstado(estado);
	
	
	//ProdutoDao
	MedicoDao fd = new MedicoDao();
	boolean valida = fd.alterar(fb);
	
	//Redirecionamento
	if(valida == true) {
		response.sendRedirect("../cadastroMedico.jsp?mensagem=alterarOk");
	}else{
		response.sendRedirect("../cadastroMedico.jsp?mensagem=alterarFalha");
	}
%>