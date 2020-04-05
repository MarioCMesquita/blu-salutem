package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.ConsultaBean;
import conexao.Conexao;

public class ConsultaDao {
	
	//Cadastrar Consulta
	public boolean cadastrar(ConsultaBean obj) {
		
		//Variável boolean
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//SQL
			String sql = "INSERT INTO consultas (idSegmento, idMedico, idPaciente, dataConsulta, descricaoConsulta) VALUES (?,?,?,?,?)";
					
			//PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setInt(1, obj.getIdSegmentoMedico());
			pstmt.setInt(2, obj.getIdMedico());
			pstmt.setInt(3, obj.getIdPaciente());
			pstmt.setString(4, obj.getDataConsulta());
			pstmt.setString(5, obj.getDescricaoConsulta());
			
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
	
	//Select Segmentos
	public String selecionarSegmentos() {
		
		//Iniciar estrutura
		String estrutura = "<select name='segmento'>";
				estrutura += "<option>Segmentos</option>";
				
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
	
	//Select Médicos
	public String selecionarMedicos() {
		
		//Iniciar estrutura
		String estrutura = "<select name='medico'>";
				estrutura += "<option>Medico</option>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM cadastroMedicos";
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
	
	//Select Pacientes
	public String selecionarPacientes() {
		
		//Iniciar estrutura
		String estrutura = "<select name='paciente'>";
				estrutura += "<option>Paciente</option>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM cadastroPacientes";
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
				estrutura += "<td>Segmento</td>";
				estrutura += "<td>Médico</td>";
				estrutura += "<td>Paciente</td>";
				estrutura += "<td>Data</td>";
				estrutura += "<td>Descrição</td>";
				estrutura += "<td>Alterar</td>";
				estrutura += "<td>Excluir</td>";
				estrutura += "</tr>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM consultas";
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
				estrutura += "<td><a href='cadastroConsulta.jsp?idConsulta="+rs.getInt(1)+"'>Alterar</a></td>";
				estrutura += "<td><a href='requisicoes/excluirConsulta.jsp?idConsulta="+rs.getInt(1)+"'>Excluir</a></td>";
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
	public ConsultaBean especificarConsulta(int idConsulta) {
		
		//Objeto
		ConsultaBean fb = new ConsultaBean();
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM consultas WHERE idConsulta = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idConsulta);
			
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			fb.setIdConsulta(rs.getInt(1));
			fb.setIdSegmentoMedico(rs.getInt(2));
			fb.setIdMedico(rs.getInt(3));
			fb.setIdPaciente(rs.getInt(4));
			fb.setDataConsulta(rs.getString(5));
			fb.setDescricaoConsulta(rs.getString(6));
			
			pstmt.close();
			conexao.close();
		}catch(Exception e) {}
		
		//Retorno
		return fb;
	}
	
	//Excluir Consulta
	public boolean excluir(int idConsulta) {
		
		//Situação
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "DELETE FROM consultas WHERE idConsulta = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idConsulta);
			pstmt.execute();
			pstmt.close();
			conexao.close();
			situacao = true;
		}catch(Exception e){}
		
		//Retorno
		return situacao;
		
	}
	
	//Alterar Consulta
	public boolean alterar(ConsultaBean pb) {
		
		//Validação
		boolean valida = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "UPDATE consultas SET idSegmentoMedico = ?, idMedico = ?, idPaciente = ?, dataConsulta = ?, descricaoConsulta = ? WHERE idConsulta = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, pb.getIdSegmentoMedico());
			pstmt.setInt(2, pb.getIdMedico());
			pstmt.setInt(3, pb.getIdPaciente());
			pstmt.setString(4, pb.getDataConsulta());
			pstmt.setString(5, pb.getDescricaoConsulta());
			pstmt.setInt(1, pb.getIdConsulta());
			
			pstmt.execute();
			pstmt.close();
			conexao.close();
			valida = true;
		}catch(Exception e) {}
		
		//Retorno
		return valida;
	}
	
}
