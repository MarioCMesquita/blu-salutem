<%@page import="dao.MedicoDao"%>
<%@page import="beans.ProdutoBean"%>
<%@page import="dao.ProdutoDao"%>
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
    <!-- Conteúdo -->
    <main>
        <!-- Sessão -->
        <section class="container">
            <!-- Linha -->
            <div class="row">
                <!-- Coluna 01 -->
                <div class="col-md-12">
                    <!-- FORMULÁRIO -->
                    <section class="cadastroProduto">
                            <!-- Formulário -->
							<%
							
							//idProduto
							int idEstoque = 0;
							
							//Tentar obter o idProduto via URL
							try{
								idEstoque = Integer.parseInt(request.getParameter("idEstoque"));
							}catch(Exception e){}
							
							//Condicional
							if(idEstoque == 0){
							%>
							
							<form class="formularioCadastro contain5 box espacamento" action="requisicoes/cadastrarProduto.jsp" method="post">
					            <div class="titulo">
					                <h1>Cadastrar Produtos</h1>
					            </div>
								<div>
                                <%
	                                ProdutoDao pdCentros = new ProdutoDao();
	                                out.print(pdCentros.selecionarCentros());
	                            %>
	                           </div>
								<div>
								<input type="text" placeholder=" Produto" name="produto">
								</div>
								<div>
								<input type="text" placeholder=" Quantidade" name="quantidade">
								</div>
								<div>
								<input type="text" placeholder=" Validade" name="validade">
								</div>
								<div>
								<input type="text" placeholder=" Valor" name="valor">
								</div>
								<div>
								<textarea placeholder=" Descição" name="descricao"></textarea>
								</div>
								<div>
								<input type="submit" value="Cadastrar">
								</div>
							</form>
							
							<% }else{ 
							
								//Obter dados do produto
								ProdutoDao pd = new ProdutoDao();
								ProdutoBean pb = pd.especificarProduto(idEstoque);
							
							%>
							
							<form class="formularioCadastro contain5 box espacamento" action="requisicoes/alterarProduto.jsp" method="post">
								<div class="titulo">
					                <h1>Alterar Produtos</h1>
					            </div>
								<div>
								<input type="hidden" name="idEstoque" value="<% out.print(idEstoque); %>">
								</div>
								<div>
                                <%
	                                ProdutoDao pdCentros = new ProdutoDao();
	                                out.print(pdCentros.selecionarCentros());
	                            %>
	                           </div>
	                           <div>
								<input type="text" placeholder=" Produto" name="nome" value="<% out.print(pb.getNomeItem()); %>">
								</div>
								<div>
								<input type="text" placeholder=" Quantidade" name="quantidade" value="<% out.print(pb.getQuantidadeItem()); %>">
								</div>
								<div>
								<input type="text" placeholder=" Validade" name="validade" value="<% out.print(pb.getValidadeItem()); %>">
								</div>
								<div>
								<input type="text" placeholder=" Valor" name="valor" value="<% out.print(pb.getValorItem()); %>">
								</div>
								<div>
								<textarea placeholder=" Descição" name="descricao" value="<% out.print(pb.getDescricaoItem()); %>"></textarea>
								</div>
								<div>
								<input type="submit" value="Alterar">
								</div>
								<div>
								<a href="cadastroProduto.jsp">Cancelar</a>
								</div>
							</form>
							
							<% } %>
							<form class="formularioCadastro espacamento3" action="requisicoes/alterarProduto.jsp" method="post">
							<!-- Tabela -->
							<% 
								ProdutoDao pd = new ProdutoDao();
								out.print(pd.selecionar());
							%>
							</form>
                    </section>
                </div>
        </section>
    </main>
    <footer class="footerIndex">
        © 2019 Blusalutem - Todos os diretos reservados
    </footer>
</body>

</html>