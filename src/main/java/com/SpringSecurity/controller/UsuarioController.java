package com.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SpringSecurity.model.Usuario;
import com.SpringSecurity.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@GetMapping("/cadastrar")
	public String cadastrar() {	
		return "usuarioForm";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		System.out.println(usuario.getNomeCompleto() + " " + usuario.getLogin() + " " + usuario.getSenha());
		
		ur.save(usuario);
		return "redirect:/";
	}
	
	@RequestMapping("/alterar")
	public ModelAndView alterar(String login) {
		Usuario usuario = ur.findByLogin(login);
		ModelAndView mv = new ModelAndView("usuarioFormAltera");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletar(String login) {
		Usuario usuario = ur.findByLogin(login);
		ur.delete(usuario);
		return "redirect:/";
	}

}
