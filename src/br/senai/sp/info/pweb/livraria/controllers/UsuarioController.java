package br.senai.sp.info.pweb.livraria.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
	}
	
	@GetMapping("/entrar")
	public String abreLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/login";
	}
	
	@PostMapping("/autenticar")
	public String autenticar(@Valid Usuario usuario, BindingResult bindingResult,
							Model model, HttpSession session) {
		
		//Se houverem erros nos campos email e senha
		if(	bindingResult.hasFieldErrors("email") || 
			bindingResult.hasFieldErrors("senha")) {
			System.out.println("Autenticando!");
			return "usuario/login";
		}
		
		//Verifica a autenticação
		usuario.hashearSenha();
		Usuario usuarioAutenticado = usuarioDao.autenticar(usuario);
		if(usuarioAutenticado == null) {
			bindingResult.addError(new FieldError("usuario", "email", "Email ou senha incorretos"));
			
			return "usuario/login";
		}
		
		//Aplica o usuário na sessão
		session.setAttribute("usuario", usuarioAutenticado);
		
		//Redireciona para a página inicial
		return "redirect:app";
	}
	
	@PostMapping("/usuario/salvar")
	public String salvar(	@Valid Usuario usuario, BindingResult bindingResult,
							Model model) {
		
		//Se houverem erros....
		if(bindingResult.hasErrors()) {
			return "usuario/form";
		}
		
		if(usuario.getId() == null) {
			
			//Verifica se o email já existe
			if(usuarioDao.emailJaExiste(usuario.getEmail())) {
				bindingResult.addError(new FieldError("usuario", "email", "O email inserido já existe"));
				
				return "usuario/form";
			}
			
			usuario.hashearSenha();
			usuarioDao.persistir(usuario);
			//Redireciona para página de login
			return "redirect:/entrar?cadastrado=1";
		}else {
			usuarioDao.alterar(usuario);
			return "redirect:/app/";
		}
	}

}