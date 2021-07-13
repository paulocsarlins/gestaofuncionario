package br.edu.ifpe.ate.gestaofuncionario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL{
	
	public static Connection getConexaoMySQL() throws SQLException, ClassNotFoundException{
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/bd_empresa","root","");
		return connection;
		
	}
}
