package br.edu.ifpe.ate.gestaofuncionario.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.ate.gestaofuncionario.dao.FuncionarioDAO;
import br.edu.ifpe.ate.gestaofuncionario.model.Funcionario;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioDAO funcionarioDAO;
	
	
	@PostMapping("/{id}/delete")
	public ModelAndView deleteFucnionario(@PathVariable Long id) {
		int codigo = (int) id.intValue();
		  try {
			funcionarioDAO.deletarFuncionarioDAO(codigo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/funcionarios");
	}
	
	
	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable Long id,@Valid Funcionario funcionario, BindingResult bindingResults){

		if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("funcionarios/edit");
			return mv;
		}else {
			int codigo = (int) id.intValue();

			try {
				funcionario.setCodigo(codigo);
				funcionarioDAO.alterarFuncionarioDAO(funcionario);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/funcionarios");
		}
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id, Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("funcionarios/edit");
		int codigo = (int) id.intValue();
		
		try {
			
			funcionario = funcionarioDAO.consultarFuncionario(codigo);
			
			if(funcionario != null) {
				mv.addObject("funcionario", funcionario);
				mv.addObject("funcionarioID", id);
				return mv;
			}else {
				return new ModelAndView("redirect:/funionarios");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@GetMapping("/new")
	public ModelAndView novoFuncionario() {
		
		ModelAndView mv = new ModelAndView("funcionarios/new");
		mv.addObject("funcionario", new Funcionario());		
		
		return mv;
	}
	
	@PostMapping("")
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
	
	
	@GetMapping("")
	public ModelAndView index() {
		
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
