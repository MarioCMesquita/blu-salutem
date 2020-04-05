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
    	int segmento = Integer.parseInt(request.getParameter("segmento"));
    	int centro = Integer.parseInt(request.getParameter("centro"));
    	int estado = Integer.parseInt(request.getParameter("estado"));
    	
    	//MedicoBean
    	MedicoBean fb = new MedicoBean();
    	fb.setNomeMedico(nome);
    	fb.setRgMedico(rg);
    	fb.setCpfMedico(cpf);
    	fb.setCrmMedico(crm);
    	fb.setEmailMedico(email);
    	fb.setSenhaMedico(senha);
    	fb.setTelefoneMedico(telefone);
    	fb.setEnderecoMedico(endereco);
    	fb.setIdSegmentoMedico(segmento);
    	fb.setIdCentroAtendimento(centro);
    	fb.setIdEstado(estado);
    	
    	//MedicoDao
    	MedicoDao fd = new MedicoDao();
    	boolean valida = fd.cadastrar(fb);
    	
    	//Redirecionamento
    	if(valida == true){
    		response.sendRedirect("../cadastroMedico.jsp?mensagem=cadastroOk");
    	}else{
    		response.sendRedirect("../cadastroMedico.jsp?mensagem=cadastroFalha");
    	}
    %>