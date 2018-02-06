package br.senai.sp.info.pweb.livraria.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.senai.sp.info.pweb.livraria.dao.jdbc.UsuarioDAO;
import br.senai.sp.info.pweb.livraria.models.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@GetMapping("/usuario/novo")
	public String abreForm(Model model) {
		System.out.println(messageSource.getMessage("Size", null, Locale.getDefault()));
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
	}
	
	@GetMapping("/entrar")
	public String abreLogin() {
		return "usuario/login";
	}
	
	@PostMapping("/usuario/salvar")
	public String salvar(	@Valid Usuario usuario, BindingResult bindingResult,
							Model model) {
		
		//Se houverem erros....
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult);
			return "usuario/form";
		}
		
		//Se não houver persiste no banco de dados
		usuarioDao.persistir(usuario);
		
		//Redireciona para página de login
		return "redirect: /login";
	}

}
