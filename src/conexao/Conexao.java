package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	//Método de conexão
		public static Connection obterConexao() {
			
			//Objeto Connection
			Connection con = null;
			
			//Tentativa
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/blusalutem","root","");
				System.out.println("Conexão ok");
			}catch(Exception erro) {
				System.out.println("Falha ao conectar"+erro.getMessage());
			}
			
			//Retorno
			return con;
			
		}
		
	}
