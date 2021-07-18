package br.edu.ifpe.ate.gestaofuncionario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.ate.gestaofuncionario.model.Funcionario;

@Repository
public class FuncionarioDAO {
	
	public void adiciona(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `funcionarios`"
				+ "(`nome`, `email`, `cargo`, `endereco`, `cidade`)" 
				+ "VALUES (? , ? , ? , ?, ? )";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
//		stmt.setInt(1, funcionario.getCodigo());
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getEmail());
		stmt.setString(3, funcionario.getCargo());
		stmt.setString(4, funcionario.getEndereco());
		stmt.setString(5, funcionario.getCidade());
				
		stmt.execute();
		stmt.close();
		connection.close();
		
	}
	
public List<Funcionario> consultarTodosFuncionarios() throws ClassNotFoundException, SQLException{
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `codigo`, `nome`, `email`, `cargo`, `endereco`, `cidade` FROM `funcionarios`";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet resultSet = stmt.executeQuery();
		
		List<Funcionario> listaTodosFuncionarios = new ArrayList<Funcionario>();
		while(resultSet.next()) {
			
			Funcionario funcionario = new Funcionario();
			funcionario.setCodigo(resultSet.getInt(1));
			funcionario.setNome(resultSet.getString(2));
			funcionario.setEmail(resultSet.getString(3));
			funcionario.setCargo(resultSet.getString(4));
			funcionario.setEndereco(resultSet.getString(5));
			funcionario.setCidade(resultSet.getString(6));
						
			listaTodosFuncionarios.add(funcionario);
		}
		return listaTodosFuncionarios;
		
	}
	
	public Funcionario consultarFuncionario(int codigo) throws ClassNotFoundException, SQLException {
		
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT * FROM `funcionarios` WHERE codigo = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, codigo);
		ResultSet resultSet = stmt.executeQuery();
		
		Funcionario funcionario = new Funcionario();
		
		if(resultSet.next()) {
			
			funcionario.setCodigo(resultSet.getInt(1));
			funcionario.setNome(resultSet.getString(2));
			funcionario.setEmail(resultSet.getString(3));
			funcionario.setCargo(resultSet.getString(4));
			funcionario.setEndereco(resultSet.getString(5));
			funcionario.setCidade(resultSet.getString(6));
		
		}
		
		return funcionario;
		
	}

	public void alterarFuncionarioDAO(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "UPDATE `funcionarios` SET `nome`= ?, `email`= ?, `cargo`= ?,`endereco`= ?,"
		 		+ "`cidade`= ? WHERE codigo = ?";

		 PreparedStatement stmt = connection.prepareStatement(sql);
	        
	        stmt.setString(1, funcionario.getNome());
	        stmt.setString(2, funcionario.getEmail());
	        stmt.setString(3, funcionario.getCargo());
	        stmt.setString(4, funcionario.getEndereco());
	        stmt.setString(5, funcionario.getCidade());
	        stmt.setInt(6, funcionario.getCodigo());
	        
	        stmt.executeUpdate();
	        stmt.close();
	        connection.close();
	 
	 }
	
	public void deletarFuncionarioDAO(int codigo) throws ClassNotFoundException, SQLException {
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "DELETE FROM `funcionarios` WHERE codigo = ?";

		 PreparedStatement stmt = connection.prepareStatement(sql);

		 stmt.setInt(1, codigo);

		 stmt.execute();
		 stmt.close();
		 connection.close();

	 }
}

