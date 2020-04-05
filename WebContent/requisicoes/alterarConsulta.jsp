<%@page import="dao.ConsultaDao"%>
<%@page import="beans.ConsultaBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	//Obter dados
	int segmento = Integer.parseInt(request.getParameter("segmento"));
   	int medico = Integer.parseInt(request.getParameter("medico"));
   	int paciente = Integer.parseInt(request.getParameter("paciente"));
   	String data = request.getParameter("data");
   	String descricao = request.getParameter("descricao");
	
	//ConsultaBean
	ConsultaBean fb = new ConsultaBean();
   	fb.setIdSegmentoMedico(segmento);
   	fb.setIdMedico(medico);
   	fb.setIdPaciente(paciente);
   	fb.setDataConsulta(data);
   	fb.setDescricaoConsulta(descricao);
	
	
	//ProdutoDao
	ConsultaDao fd = new ConsultaDao();
	boolean valida = fd.alterar(fb);
	
	//Redirecionamento
	if(valida == true) {
		response.sendRedirect("../cadastroConsulta.jsp?mensagem=alterarOk");
	}else{
		response.sendRedirect("../cadastroConsulta.jsp?mensagem=alterarFalha");
	}
%>