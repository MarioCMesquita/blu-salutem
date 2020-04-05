package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.ProdutoBean;
import conexao.Conexao;

public class ProdutoDao {

	//Cadastrar produto
	public boolean cadastrar(ProdutoBean obj) {
		
		//Variável boolean
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			//SQL
			String sql = "INSERT INTO estoques (nomeItem, descricaoItem, validadeItem, quantidadeItem, valorItem, idCentroAtendimento) VALUES (?,?,?,?,?,?)";
					
			//PreparedStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, obj.getNomeItem());
			pstmt.setString(2, obj.getDescricaoItem());
			pstmt.setInt(3, obj.getValidadeItem());
			pstmt.setInt(4, obj.getQuantidadeItem());
			pstmt.setDouble(5, obj.getValorItem());
			pstmt.setInt(6, obj.getIdCentroAtendimento());
			
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
	
	//Selecionar produtos
	public String selecionar() {
		
		//Iniciar estrutura
		String estrutura = "<table class='tabela'>";
				estrutura += "<tr>";
				estrutura += "<td>Código</td>";
				estrutura += "<td>Produto</td>";
				estrutura += "<td>Quantidade</td>";
				estrutura += "<td>Validade</td>";
				estrutura += "<td>Valor</td>";
				estrutura += "<td>Descricao</td>";
				estrutura += "<td>Centro de Atendimento</td>";
				estrutura += "<td>Alterar</td>";
				estrutura += "<td>Excluir</td>";
				estrutura += "</tr>";
				
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM estoques";
			Statement stmt = conexao.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				estrutura += "<tr>";
				estrutura += "<td>"+rs.getInt(1)+"</td>";
				estrutura += "<td>"+rs.getString(2)+"</td>";
				estrutura += "<td>"+rs.getInt(3)+"</td>";
				estrutura += "<td>"+rs.getInt(4)+"</td>";
				estrutura += "<td>"+rs.getDouble(5)+"</td>";
				estrutura += "<td>"+rs.getString(6)+"</td>";
				estrutura += "<td>"+rs.getInt(7)+"</td>";
				estrutura += "<td><a href='cadastroProduto.jsp?idEstoque="+rs.getInt(1)+"'>Alterar</a></td>";
				estrutura += "<td><a href='requisicoes/excluirProduto.jsp?idEstoque="+rs.getInt(1)+"'>Excluir</a></td>";
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
	
	//Selecionar dados do produto específico
	public ProdutoBean especificarProduto(int idEstoque) {
		
		//Objeto
		ProdutoBean pb = new ProdutoBean();
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "SELECT * FROM estoques WHERE idEstoque = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idEstoque);
			
			ResultSet rs = pstmt.executeQuery();
			rs.last();
			pb.setIdEstoque(rs.getInt(1));
			pb.setNomeItem(rs.getString(2));
			pb.setQuantidadeItem(rs.getInt(1));
			pb.setValidadeItem(rs.getInt(1));
			pb.setValorItem(rs.getDouble(3));
			pb.setDescricaoItem(rs.getString(2));
			pb.setIdCentroAtendimento(rs.getInt(1));
			
			pstmt.close();
			conexao.close();
		}catch(Exception e) {}
		
		//Retorno
		return pb;
	}
	
	//Excluir produto
	public boolean excluir(int idEstoque) {
		
		//Situação
		boolean situacao = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "DELETE FROM estoques WHERE idEstoque = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idEstoque);
			pstmt.execute();
			pstmt.close();
			conexao.close();
			situacao = true;
		}catch(Exception e){}
		
		//Retorno
		return situacao;
		
	}
	
	//Alterar produto
	public boolean alterar(ProdutoBean pb) {
		
		//Validação
		boolean valida = false;
		
		//Conexão
		Connection conexao = Conexao.obterConexao();
		
		//Tentativa
		try {
			String sql = "UPDATE estoques SET nomeItem = ?, descricaoItem = ?, validadeItem = ?, quantidadeItem = ?, valorItem = ?, idCentroAtendimento = ? WHERE idEstoque = ?";
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, pb.getNomeItem());
			pstmt.setString(2, pb.getDescricaoItem());
			pstmt.setInt(3, pb.getValidadeItem());
			pstmt.setInt(4, pb.getQuantidadeItem());
			pstmt.setDouble(5, pb.getValorItem());
			pstmt.setInt(6, pb.getIdCentroAtendimento());
			pstmt.setInt(7, pb.getIdEstoque());
			pstmt.execute();
			pstmt.close();
			conexao.close();
			valida = true;
		}catch(Exception e) {}
		
		//Retorno
		return valida;
	}
	
	//Selecionar Centro de Atendimento
	public String selecionarCentros() {
		
		//Iniciar estrutura
		String estrutura = "<select name='idCentro'>";
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
	
}
