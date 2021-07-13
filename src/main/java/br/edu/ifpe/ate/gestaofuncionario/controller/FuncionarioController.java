package br.edu.ifpe.ate.gestaofuncionario.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.ate.gestaofuncionario.dao.FuncionarioDAO;
import br.edu.ifpe.ate.gestaofuncionario.model.Funcionario;

@Controller
public class FuncionarioController {
	
	@Autowired
	FuncionarioDAO funcionarioDAO;
	
	@GetMapping("funcionario/new")
	public String novoFuncionario(){
		return "funcionarios/new";
	}
	
	@PostMapping("/funcionarios")
	public ModelAndView creatFuncionario(@Validated Funcionario funcionario, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("funcionarios/new");
			return mv;
		}
		
		try {
			funcionarioDAO.adiciona(funcionario);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("######" + funcionario + "######");
		return new ModelAndView("redirect:/funcionarios");
	}
	
	
	@GetMapping("/funcionarios")
	public ModelAndView index() {
		
//		Funcionario funcionario1 = new Funcionario(1, "Maria Silva", "maria@gmail.com", "Rua A", "Palmares");
//		Funcionario funcionario2 = new Funcionario(2, "João Lima", "joao@gmail.com", "Rua B", "Água Preta");
//		Funcionario funcionario3 = new Funcionario(3, "José Pereira", "jose@gmail.com", "Rua C", "Catende");
		
//		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
//		funcionarios.add(funcionario1);
//		funcionarios.add(funcionario2);
//		funcionarios.add(funcionario3);
		
		
		
		List<Funcionario> funcionarios = null;
		try {
			funcionarios = funcionarioDAO.consultarTodosFuncionarios();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("funcionarios/index");
		mv.addObject("funcionarios", funcionarios);
		
		return mv;
	}

}
