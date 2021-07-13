package br.edu.ifpe.ate.gestaofuncionario.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@GetMapping("/hello-servlet")
	public String hello(HttpServletRequest request){
		request.setAttribute("ifpe", "Paulo César");
		return "hello";
	}
	
	@GetMapping("/hello-view")
	public ModelAndView hello1() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("ifpe", "Alunos");
		return mv;
	}
	
	@GetMapping("/hello-model")
		public String hello(Model model) {
		model.addAttribute("ifpe", "Palmares");
		return "hello";
	}
	

}
