package br.edu.ifpe.ate.gestaofuncionario.model;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class Funcionario {
	
	private int codigo;
	@NotBlank
	@NotNull
	private String nome;
	private String email;
	private String cargo;
	private String endereco;
	private String cidade;
	
	public Funcionario(int codigo, String nome, String email, String cargo, String endereco, String cidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.endereco = endereco;
		this.cidade = cidade;
	}
	
	public Funcionario() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
