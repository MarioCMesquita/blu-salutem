package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.FuncionarioBean;
import beans.MedicoBean;
import conexao.Conexao;

public class MedicoDao {

	//Verificar login
	public int verificarLogin(String email, String senha) {
		
		
		//Conexao
		Connection conexao = Conexao.obterConexao();
		
		//Contador
		int contador = 0;
		
		//Tentativa
		try {
			
			//SQL
			String sql = "SELECT * FROM cadastromedicos WHERE emailMedico = ? AND senhaMedico = ?";
			
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

	
	//Obter os dados do médico
	public MedicoBean dadosUsuario(String email, String senha) {
		
		//Objeto UsuarioBean
		MedicoBean ub = new MedicoBean();
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//SQL
			String sql = "SELECT * FROM cadastromedicos WHERE emailMedico = ? AND senhaMedico = ?";
					
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
			ub.setIdMedico(rs.getInt(1));
			ub.setIdEstado(rs.getInt(2));
			ub.setIdCentroAtendimento(rs.getInt(3));
			ub.setIdSegmentoMedico(rs.getInt(4));
			ub.setNomeMedico(rs.getString(5));
			ub.setRgMedico(rs.getString(6));
			ub.setCpfMedico(rs.getString(7));
			ub.setCrmMedico(rs.getString(8));
			ub.setEmailMedico(rs.getString(9));
			ub.setTelefoneMedico(rs.getString(10));
			ub.setEnderecoMedico(rs.getString(11));
			ub.setSenhaMedico(rs.getString(12));
		}catch(Exception erro) {
			System.out.println("Falha ao obter dados"+erro.getMessage());
		}
		
		//Retorno
		return ub;
	}
	
	//Cadastrar médico
	public boolean cadastrar(MedicoBean obj) {
		
		//Variável boolean
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//SQL
			String sql = "INSERT INTO cadastromedicos (nomeMedico, rgMedico, cpfMedico, crmMedico, emailMedico, senhaMedico, telefoneMedico, enderecoMedico, idSegmentoMedico, idCentroAtendimento, idEstado) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
					
			//PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, obj.getNomeMedico());
			pstmt.setString(2, obj.getRgMedico());
			pstmt.setString(3, obj.getCpfMedico());
			pstmt.setString(4, obj.getCrmMedico());
			pstmt.setString(5, obj.getEmailMedico());
			pstmt.setString(6, obj.getSenhaMedico());
			pstmt.setString(7, obj.getTelefoneMedico());
			pstmt.setString(8, obj.getEnderecoMedico());
			pstmt.setInt(9, obj.getIdSegmentoMedico());
			pstmt.setInt(10, obj.getIdCentroAtendimento());
			pstmt.setInt(11, obj.getIdEstado());
			
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
			String sql = "SELECT * FROM segmentoMedicos";
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
	
	//Selecionar Estados
	public String selecionarEstados() {
		
		//Iniciar estrutura
		String estrutura = "<select name='estado'>";
				estrutura += "<option>Estado</option>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM estados";
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
	
	//Selecionar Centro de Atendimento
	public String selecionarCentros() {
		
		//Iniciar estrutura
		String estrutura = "<select name='centro'>";
				estrutura += "<option>Centro de Atendimento</option>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM centros";
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
	
	//Selecionar médicos
	public String selecionar() {
		
		//Iniciar estrutura
		String estrutura = "<table class='tabela'>";
				estrutura += "<tr>";
				estrutura += "<td>Id</td>";
				estrutura += "<td>Nome</td>";
				estrutura += "<td>RG</td>";
				estrutura += "<td>CPF</td>";
				estrutura += "<td>CRM</td>";
				estrutura += "<td>E-mail</td>";
				estrutura += "<td>Senha</td>";
				estrutura += "<td>Telefone</td>";
				estrutura += "<td>Endereço</td>";
				estrutura += "<td>Segmento</td>";
				estrutura += "<td>Centro de Atendimento</td>";
				estrutura += "<td>Alterar</td>";
				estrutura += "<td>Excluir</td>";
				estrutura += "</tr>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM cadastromedicos";
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
				estrutura += "<td>"+rs.getString(11)+"</td>";
				estrutura += "<td>"+rs.getString(12)+"</td>";
				estrutura += "<td><a href='cadastroMedico.jsp?idMedico="+rs.getInt(1)+"'>Alterar</a></td>";
				estrutura += "<td><a href='requisicoes/excluirMedico.jsp?idMedico="+rs.getInt(1)+"'>Excluir</a></td>";
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
	
	//Selecionar dados do médico específico
	public MedicoBean especificarMedico(int idMedico) {
		
		//Objeto
		MedicoBean fb = new MedicoBean();
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM cadastromedicos WHERE idMedico = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idMedico);
			
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			fb.setIdMedico(rs.getInt(1));
			fb.setNomeMedico(rs.getString(2));
			fb.setRgMedico(rs.getString(3));
			fb.setCpfMedico(rs.getString(4));
			fb.setCrmMedico(rs.getString(5));
			fb.setEmailMedico(rs.getString(6));
			fb.setSenhaMedico(rs.getString(7));
			fb.setTelefoneMedico(rs.getString(8));
			fb.setEnderecoMedico(rs.getString(9));
			fb.setIdSegmentoMedico(rs.getInt(10));
			fb.setIdCentroAtendimento(rs.getInt(11));
			
			pstmt.close();
			conexao.close();
		}catch(Exception e) {}
		
		//Retorno
		return fb;
	}
	
	//Excluir médico
	public boolean excluir(int idMedico) {
		
		//Situação
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "DELETE FROM cadastromedicos WHERE idMedico = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idMedico);
			pstmt.execute();
			pstmt.close();
			conexao.close();
			situacao = true;
		}catch(Exception e){}
		
		//Retorno
		return situacao;
		
	}
	
	//Alterar médico
	public boolean alterar(MedicoBean pb) {
		
		//Validação
		boolean valida = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "UPDATE cadastromedicos SET nomeMedico = ?, rgMedico = ?, cpfMedico = ?, crmMedico = ?, emailMedico = ?, senhaMedico = ?, telefoneMedico = ?, enderecoMedico = ?, idSegmentoMedico = ?, idCentroAtendimento = ? WHERE idMedico = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, pb.getNomeMedico());
			pstmt.setString(2, pb.getRgMedico());
			pstmt.setString(3, pb.getCpfMedico());
			pstmt.setString(4, pb.getCrmMedico());
			pstmt.setString(5, pb.getEmailMedico());
			pstmt.setString(6, pb.getSenhaMedico());
			pstmt.setString(7, pb.getTelefoneMedico());
			pstmt.setString(8, pb.getEnderecoMedico());
			pstmt.setInt(9, pb.getIdSegmentoMedico());
			pstmt.setInt(10, pb.getIdCentroAtendimento());
			pstmt.setInt(11, pb.getIdMedico());
			pstmt.execute();
			pstmt.close();
			conexao.close();
			valida = true;
		}catch(Exception e) {}
		
		//Retorno
		return valida;
	}
	
}
