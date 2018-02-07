package br.senai.sp.info.pweb.livraria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.info.pweb.livraria.models.Categoria;

@Controller
@RequestMapping("/app/categoria")
public class CategoriaController {
	
	@GetMapping("/novo")
	public String abreForm(Model model) {
		model.addAttribute("categoria", new Categoria());
		
		return "categoria/form";
	}

}
