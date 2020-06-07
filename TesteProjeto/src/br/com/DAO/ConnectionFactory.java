package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection(){
		String url = "jdbc:mysql://127.0.0.1:3306/dbprojeto";
		String user = "root";
		String password = "v74859674";
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão" + e);
		}
		
	}

}
