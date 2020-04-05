package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.FuncionarioBean;
import conexao.Conexao;

public class FuncionarioDao {

	//Verificar login
	public int verificarLogin(String email, String senha) {
		
		
		//Conexao
		Connection conexao = Conexao.obterConexao();
		
		//Contador
		int contador = 0;
		
		//Tentativa
		try {
			
			//SQL
			String sql = "SELECT COUNT(*) FROM cadastrofuncionarios WHERE emailFuncionario = ? AND senhaFuncionario = ?";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			
			//Obter dados
			ResultSet rs = pstmt.executeQuery();
			
			rs.last();
			
			contador = rs.getInt(1);
			
			
		}catch(Exception erro) {
			System.out.println("Falha ao logar"+erro.getMessage());
		}
		
		//Retorno
		return contador;
		
	}

	
	//Obter os dados do usuário
	public FuncionarioBean dadosUsuario(String email, String senha) {
		
		//Objeto UsuarioBean
		FuncionarioBean ub = new FuncionarioBean();
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//SQL
			String sql = "SELECT * FROM cadastrofuncionarios WHERE emailFuncionario = ? AND senhaFuncionario = ?";
					
			//PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			
			//Executar
			ResultSet rs = pstmt.executeQuery();
			
			//Selecionar a última linha
			rs.last();
			
			//Obter dados
			ub.setIdFuncionario(rs.getInt(1));
			ub.setIdSegmentoFuncionario(rs.getInt(2));
			ub.setNomeFuncionario(rs.getString(3));
			ub.setRgFuncionario(rs.getString(4));
			ub.setCpfFuncionario(rs.getString(5));
			ub.setEmailFuncionario(rs.getString(6));
			ub.setTelefoneFuncionario(rs.getString(7));
			ub.setEnderecoFuncionario(rs.getString(8));
			ub.setSenhaFuncionario(rs.getString(9));
		}catch(Exception erro) {
			System.out.println("Falha ao obter dados"+erro.getMessage());
		}
		
		//Retorno
		return ub;
	}
	
	//Cadastrar usuário
	public boolean cadastrar(FuncionarioBean obj) {
		
		//Variável boolean
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//SQL
			String sql = "INSERT INTO cadastrofuncionarios (nomeFuncionario, rgFuncionario, cpfFuncionario, emailFuncionario, senhaFuncionario, telefoneFuncionario, enderecoFuncionario, idSegmentoFuncionario) VALUES (?,?,?,?,?,?,?,?)";
					
			//PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, obj.getNomeFuncionario());
			pstmt.setString(2, obj.getRgFuncionario());
			pstmt.setString(3, obj.getCpfFuncionario());
			pstmt.setString(4, obj.getEmailFuncionario());
			pstmt.setString(5, obj.getSenhaFuncionario());
			pstmt.setString(6, obj.getTelefoneFuncionario());
			pstmt.setString(7, obj.getEnderecoFuncionario());
			pstmt.setInt(8, obj.getIdSegmentoFuncionario());
			
			pstmt.execute();
			
			situacao = true;
			
			pstmt.close();
			conexao.close();
			
		}catch(Exception erro) {
			System.out.println("Falha ao cadastrar"+erro.getMessage());
		}
		
		//Retorno
		return situacao;
	}
	
	//Selecionar Segmentos
	public String selecionarSegmentos() {
		
		//Iniciar estrutura
		String estrutura = "<select name='segmento'>";
				estrutura += "<option>Segmento</option>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM segmentoFuncionarios";
			Statement stmt = conexao.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				estrutura += "<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>";
			}
			
			stmt.close();
			conexao.close();
		}catch(Exception e) {
		}
				
		//Finalizar estrutura
		estrutura += "</select>";
				
		//Retorno
		return estrutura;
	}

	//Selecionar funcionários
	public String selecionar() {
		
		//Iniciar estrutura
		String estrutura = "<table class='tabela'>";
				estrutura += "<tr>";
				estrutura += "<td>Id</td>";
				estrutura += "<td>Nome</td>";
				estrutura += "<td>RG</td>";
				estrutura += "<td>CPF</td>";
				estrutura += "<td>E-mail</td>";
				estrutura += "<td>Senha</td>";
				estrutura += "<td>Telefone</td>";
				estrutura += "<td>Endereço</td>";
				estrutura += "<td>Segmento</td>";
				estrutura += "<td>Alterar</td>";
				estrutura += "<td>Excluir</td>";
				estrutura += "</tr>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM cadastrofuncionarios";
			Statement stmt = conexao.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				estrutura += "<tr>";
				estrutura += "<td>"+rs.getInt(1)+"</td>";
				estrutura += "<td>"+rs.getString(2)+"</td>";
				estrutura += "<td>"+rs.getString(3)+"</td>";
				estrutura += "<td>"+rs.getString(4)+"</td>";
				estrutura += "<td>"+rs.getString(5)+"</td>";
				estrutura += "<td>"+rs.getString(6)+"</td>";
				estrutura += "<td>"+rs.getString(7)+"</td>";
				estrutura += "<td>"+rs.getString(8)+"</td>";
				estrutura += "<td>"+rs.getString(9)+"</td>";
				estrutura += "<td><a href='cadastroFuncionario.jsp?idFuncionario="+rs.getInt(1)+"'>Alterar</a></td>";
				estrutura += "<td><a href='requisicoes/excluirFuncionario.jsp?idFuncionario="+rs.getInt(1)+"'>Excluir</a></td>";
				estrutura += "</tr>";
			}
			
			stmt.close();
			conexao.close();
		}catch(Exception e) {
		}
				
		//Finalizar estrutura
		estrutura += "</table>";
				
		//Retorno
		return estrutura;
	}
	
	//Selecionar dados do funcionário específico
	public FuncionarioBean especificarFuncionario(int idFuncionario) {
		
		//Objeto
		FuncionarioBean fb = new FuncionarioBean();
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM cadastrofuncionarios WHERE idFuncionario = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idFuncionario);
			
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			fb.setIdFuncionario(rs.getInt(1));
			fb.setIdSegmentoFuncionario(rs.getInt(2));
			fb.setNomeFuncionario(rs.getString(3));
			fb.setRgFuncionario(rs.getString(4));
			fb.setCpfFuncionario(rs.getString(5));
			fb.setEmailFuncionario(rs.getString(6));
			fb.setTelefoneFuncionario(rs.getString(7));
			fb.setEnderecoFuncionario(rs.getString(8));
			fb.setSenhaFuncionario(rs.getString(9));
			
			pstmt.close();
			conexao.close();
		}catch(Exception e) {}
		
		//Retorno
		return fb;
	}
	
	//Excluir funcionário
	public boolean excluir(int idFuncionario) {
		
		//Situação
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "DELETE FROM cadastrofuncionarios WHERE idFuncionario = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idFuncionario);
			pstmt.execute();
			pstmt.close();
			conexao.close();
			situacao = true;
		}catch(Exception e){}
		
		//Retorno
		return situacao;
		
	}
	
	//Alterar funcionário
	public boolean alterar(FuncionarioBean pb) {
		
		//Validação
		boolean valida = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "UPDATE cadastrofuncionarios SET nomeFuncionario = ?, rgFuncionario = ?, cpfFuncionario = ?, emailFuncionario = ?, senhaFuncionario = ?, telefoneFuncionario = ?, enderecoFuncionario = ?, idSegmentoFuncionario = ? WHERE idFuncionario = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, pb.getNomeFuncionario());
			pstmt.setString(2, pb.getRgFuncionario());
			pstmt.setString(3, pb.getCpfFuncionario());
			pstmt.setString(4, pb.getEmailFuncionario());
			pstmt.setString(5, pb.getSenhaFuncionario());
			pstmt.setString(6, pb.getTelefoneFuncionario());
			pstmt.setString(7, pb.getEnderecoFuncionario());
			pstmt.setInt(8, pb.getIdSegmentoFuncionario());
			pstmt.setInt(9, pb.getIdFuncionario());
			pstmt.execute();
			pstmt.close();
			conexao.close();
			valida = true;
		}catch(Exception e) {}
		
		//Retorno
		return valida;
	}
	
}
