<%@page import="beans.PacienteBean"%>
<%@page import="dao.PacienteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url(imagens/background.png);">
<!-- CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/estilos.css">
</head>

<body class="background">
    <!-- TOPO -->
    <nav class="navbar navbar-expand-lg fundoMenu">
        <!-- Logo -->
        <a class="navbar-brand"><img src="imagens/logoMedicinaa.png"></a>
        <!-- Botão mobile -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30" role="img"
                    focusable="false">
                    <title>Menu</title>
                    <path stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="2"
                        d="M4 7h22M4 15h22M4 23h22"></path>
                </svg>
            </span>
        </button>
        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="cadastroPaciente.jsp">Paciente</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cadastroFuncionario.jsp">Funcionário</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cadastroMedico.jsp">Médico</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cadastroConsultaAdmin.jsp">Consulta</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cadastroProduto.jsp">Estoque</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sair.jsp">Sair</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- Sessão -->
    <section class="container">
        <!-- Linha -->
        <div class="row">
            <!-- Coluna 01 -->
            <div class="col-md-12">
            <section class="cadastroPaciente">
                <!-- Formulário -->
				<%
				
				//idProduto
				int idPaciente = 0;
				
				//Tentar obter o idFuncionario via URL
				try{
					idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
				}catch(Exception e){}
				
				//Condicional
				if(idPaciente == 0){
				%>
				
				<form class="formularioCadastro contain4 box espacamento" action="requisicoes/cadastrarPaciente.jsp" method="post">
		            <div>
                         <h1>Cadastro Paciente</h1>
                     </div>
                     <div>
                         <input type="text" placeholder=" Nome" name="nome">
                     </div>
                     <div>
                         <input type="text" placeholder=" RG" name="rg">
                     </div>
                     <div>
                         <input type="text" placeholder=" CPF" name="cpf">
                     </div>
                     <div>
                         <input type="email" placeholder=" Email" name="email">
                     </div>
                    <div>
                        <input type="password" placeholder=" Senha" name="senha">
                    </div>
                    <div>
                        <input type="text" placeholder=" Telefone" name="telefone">
                    </div>
                    <div>
                        <input type="text" placeholder=" Endereço" name="endereco">
                    </div>
                    <div>
                        <input type="submit" value="Cadastrar">
                    </div>
                </form>
				
				<% }else{ 
				
					//Obter dados do funcionário
					PacienteDao fd = new PacienteDao();
					PacienteBean fb = fd.especificarPaciente(idPaciente);
				
				%>
				
				<form class="formularioCadastro contain4 box espacamento" action="requisicoes/alterarPaciente.jsp" method="post">
					<div class="titulo">
		                <h1>Alterar Paciente</h1>
		            </div>
					<div>
					<input type="hidden" name="idPaciente" value="<% out.print(idPaciente); %>">
					</div>
                    <div>
					<input type="text" placeholder=" Nome" name="nome" value="<% out.print(fb.getNomePaciente()); %>">
					</div>
					<div>
					<input type="text" placeholder=" RG" name="rg" value="<% out.print(fb.getRgPaciente()); %>">
					</div>
					<div>
					<input type="text" placeholder=" CPF" name="cpf" value="<% out.print(fb.getCpfPaciente()); %>">
					</div>
					<div>
					<input type="text" placeholder=" Email" name="email" value="<% out.print(fb.getEmailPaciente()); %>">
					</div>
					<div>
					<input type="password" placeholder=" Senha" name="senha" value="<% out.print(fb.getSenhaPaciente()); %>">
					</div>
					<div>
					<input type="text" placeholder=" Telefone" name="telefone" value="<% out.print(fb.getTelefonePaciente()); %>">
					</div>
					<div>
					<input type="text" placeholder=" Endereço" name="endereco" value="<% out.print(fb.getEnderecoPaciente()); %>">
					</div>
					<div>
					<input type="submit" value="Alterar">
					</div>
					<div>
					<a href="cadastroPaciente.jsp">Cancelar</a>
					</div>
				</form>
				
				<% } %>
				<form class="formularioCadastro contain7 espacamento3" action="requisicoes/alterarPaciente.jsp" method="post">
				<!-- Tabela -->
				<% 
					PacienteDao fd = new PacienteDao();
					out.print(fd.selecionar());
				%>
				</form>
              </section>
            </div>
        </div>
    </section>
    </main>
    <footer class="footerIndex">
        © 2019 Blusalutem - Todos os diretos reservados
    </footer>
</body>

</html>