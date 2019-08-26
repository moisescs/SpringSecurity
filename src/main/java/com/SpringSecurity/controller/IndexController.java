package com.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SpringSecurity.model.Usuario;
import com.SpringSecurity.repository.UsuarioRepository;

@Controller
public class IndexController {
	@Autowired
	private UsuarioRepository ur;
	
	@RequestMapping("/")
	public ModelAndView index() {
		Iterable<Usuario> usuarios =  ur.findAll();	
		ModelAndView mv = new ModelAndView("index");			
		mv.addObject("usuarios", usuarios);
		return mv;

	}
	
	@RequestMapping("/teste")
	public ModelAndView teste() {
		Iterable<Usuario> usuarios =  ur.findAll();	
		ModelAndView mv = new ModelAndView("index");			
		mv.addObject("usuarios", usuarios);
		return mv;

	}
}
