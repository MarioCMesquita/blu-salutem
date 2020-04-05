<%@include file="topo.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url(imagens/background.png);">
    <!-- Conteúdo -->
    <main>
        <!-- Sessão -->
        <section class="container">
            <!-- Linha -->
            <div class="row">
                <!-- Coluna 01 -->
                <div class="col-md-12">
                    <!-- Formulário -->
                    <section class="formularioLogin">
                        <form class="contain2 box formularioLogin" action="requisicoes/logarPaciente.jsp" method="post">
                            <div>
                                <h1>Login Paciente</h1>
                            </div>
                            <div>
                                <a>E-mail</a>
                            </div>
                            <div>
                                <input type="text" placeholder=" E-mail" name="email">
                            </div>
                            <div>
                                <a>Senha</a>
                            </div>
                            <div>
                                <input type="password" placeholder=" Senha" name="senha">
                            </div>
                            <div>
                                <input type="submit" value="Login">
                            </div>
                       </form>
                    </section>
                </div>
            </div>
        </section>
    </main>
    <footer>
            © 2019 Blusalutem - Todos os diretos reservados
    </footer>
</body>

</html>