package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.FuncionarioBean;
import beans.PacienteBean;
import conexao.Conexao;

public class PacienteDao {

	//Verificar login
	public int verificarLogin(String email, String senha) {
		
		
		//Conexao
		Connection conexao = Conexao.obterConexao();
		
		//Contador
		int contador = 0;
		
		//Tentativa
		try {
			
			//SQL
			String sql = "SELECT COUNT(*) FROM cadastropacientes WHERE emailPaciente = ? AND senhaPaciente = ?";
			
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

	
	//Obter os dados do paciente
	public PacienteBean dadosUsuario(String email, String senha) {
		
		//Objeto UsuarioBean
		PacienteBean ub = new PacienteBean();
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//SQL
			String sql = "SELECT * FROM cadastropacientes WHERE emailPaciente = ? AND senhaPaciente = ?";
					
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
			ub.setIdPaciente(rs.getInt(1));
			ub.setNomePaciente(rs.getString(2));
			ub.setRgPaciente(rs.getString(3));
			ub.setCpfPaciente(rs.getString(4));
			ub.setEmailPaciente(rs.getString(5));
			ub.setSenhaPaciente(rs.getString(6));
			ub.setTelefonePaciente(rs.getString(7));
			ub.setEnderecoPaciente(rs.getString(8));
		}catch(Exception erro) {
			System.out.println("Falha ao obter dados"+erro.getMessage());
		}
		
		//Retorno
		return ub;
	}
	
	//Cadastrar paciente
	public boolean cadastrar(PacienteBean obj) {
		
		//Variável boolean
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//SQL
			String sql = "INSERT INTO cadastropacientes (nomePaciente, rgPaciente, cpfPaciente, emailPaciente, senhaPaciente, telefonePaciente, enderecoPaciente) VALUES (?,?,?,?,?,?,?)";
					
			//PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, obj.getNomePaciente());
			pstmt.setString(2, obj.getRgPaciente());
			pstmt.setString(3, obj.getCpfPaciente());
			pstmt.setString(4, obj.getEmailPaciente());
			pstmt.setString(6, obj.getTelefonePaciente());
			pstmt.setString(7, obj.getEnderecoPaciente());
			pstmt.setString(5, obj.getSenhaPaciente());
			
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
	
	//Selecionar pacientes
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
				estrutura += "<td>Alterar</td>";
				estrutura += "<td>Excluir</td>";
				estrutura += "</tr>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM cadastropacientes";
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
				estrutura += "<td><a href='cadastroPaciente.jsp?idPaciente="+rs.getInt(1)+"'>Alterar</a></td>";
				estrutura += "<td><a href='requisicoes/excluirPaciente.jsp?idPaciente="+rs.getInt(1)+"'>Excluir</a></td>";
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
	
	//Selecionar dados do paciente específico
	public PacienteBean especificarPaciente(int idPaciente) {
		
		//Objeto
		PacienteBean fb = new PacienteBean();
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM cadastropacientes WHERE idPaciente = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idPaciente);
			
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			fb.setIdPaciente(rs.getInt(1));
			fb.setNomePaciente(rs.getString(2));
			fb.setRgPaciente(rs.getString(3));
			fb.setCpfPaciente(rs.getString(4));
			fb.setEmailPaciente(rs.getString(5));
			fb.setSenhaPaciente(rs.getString(6));
			fb.setTelefonePaciente(rs.getString(7));
			fb.setEnderecoPaciente(rs.getString(8));
			
			pstmt.close();
			conexao.close();
		}catch(Exception e) {}
		
		//Retorno
		return fb;
	}
	
	//Excluir paciente
	public boolean excluir(int idPaciente) {
		
		//Situação
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "DELETE FROM cadastropacientes WHERE idPaciente = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idPaciente);
			pstmt.execute();
			pstmt.close();
			conexao.close();
			situacao = true;
		}catch(Exception e){}
		
		//Retorno
		return situacao;
		
	}
	
	//Alterar Paciente
	public boolean alterar(PacienteBean pb) {
		
		//Validação
		boolean valida = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "UPDATE cadastropacientes SET nomePaciente = ?, rgPaciente = ?, cpfPaciente = ?, emailPaciente = ?, senhaPaciente = ?, telefonePaciente = ?, enderecoPaciente = ? WHERE idPaciente = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, pb.getNomePaciente());
			pstmt.setString(2, pb.getRgPaciente());
			pstmt.setString(3, pb.getCpfPaciente());
			pstmt.setString(4, pb.getEmailPaciente());
			pstmt.setString(5, pb.getSenhaPaciente());
			pstmt.setString(6, pb.getTelefonePaciente());
			pstmt.setString(7, pb.getEnderecoPaciente());
			pstmt.setInt(8, pb.getIdPaciente());
			pstmt.execute();
			pstmt.close();
			conexao.close();
			valida = true;
		}catch(Exception e) {}
		
		//Retorno
		return valida;
	}
	
}
