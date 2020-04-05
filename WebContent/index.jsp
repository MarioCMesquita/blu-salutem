<%@include file="topo.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BluSalutem</title>
</head>
<body>
    <!-- CAROSEL -->
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="banners/01.jpg" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="banners/02.jpeg" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="banners/03.jpg" class="d-block w-100">
            </div>
        </div>
    </div>
    <!-- Conteúdo -->
    <main>
        <!-- Sessão -->
        <section class="container">
            <!-- Linha -->
            <div class="row">

                <!-- Coluna 01 -->
                <div class="col-md-6 espacamento">
                    <h1>CONHEÇA O HOSPITAL</h1>
                    <p>O Lorem Ipsum é um texto modelo da indústria tipográfica e de impressão. O Lorem Ipsum tem
                        vindo
                        a ser o
                        texto
                        padrão usado por estas indústrias desde o ano de 1500, quando uma misturou os caracteres de
                        um
                        texto
                        para
                        criar um espécime de livro. Este texto não só sobreviveu 5 séculos, mas também o salto para
                        a
                        tipografia
                        electrónica, mantendo-se essencialmente inalterada. Foi popularizada nos anos 60 com a
                        disponibilização
                        das folhas de Letraset, que continham passagens com Lorem Ipsum, e mais recentemente com os
                        programas
                        de publicação como o Aldus PageMaker que incluem versões do Lorem Ipsum.
                    </p>
                    <div class="link">
                        <a href="sobre.jsp" class="link">Saiba mais</a>
                    </div>
                </div>
                <!-- Coluna 02 -->
                <div class="col-md-6 espacamento"><img class="img1" src="imagens/ConhecaHospital.jpg"></div>


                <!-- Coluna 03 -->
                <div class="col-md-6 espacamento2">
                    <h1>QUALIDADE</h1>
                    <p>Ampliações, aquisições de novos equipamentos, treinamentos. Tudo isso faz parte do DNA do HSC
                        Blumenau e
                        tem como
                        objetivo garantir o bem-estar e a segurança dos pacientes. Conheça as certificações e
                        acreditações que
                        atestam a
                        qualidade dos serviços prestados e aumentam o compromisso do Hospital com a melhoria
                        contínua.
                    </p>
                    <div class="link">
                        <a href="sobre.jsp">Saiba mais</a>
                    </div>
                </div>
                <!-- Coluna 04 -->
                <div class="col-md-6 espacamento2"><img class="img2" src="imagens/selo.png"></div>

            </div>
        </section>
    </main>
    <footer class="footerIndex">
        © 2019 Blusalutem - Todos os diretos reservados
    </footer>
</body>

</html>