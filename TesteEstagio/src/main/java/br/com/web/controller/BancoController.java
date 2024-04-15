package br.com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.domain.Banco;
import br.com.service.BancoService;

@Controller
public class BancoController {
	
	@Autowired
	private BancoService service;
	
	@GetMapping("/")
	public String pesquisa (Banco banco, RedirectAttributes attr) {
		attr.addFlashAttribute("banco", banco);
		return "/pesquisa";
	}
	
	@GetMapping("/listar")
	public String listarTodos (ModelMap model) {
		if (model.isEmpty()) {
			model.addAttribute("bancos", service.buscarTodos());
		}
		return "/lista";
	}
	
	@PostMapping("/pesquisar")
	public String pesquisar (Banco banco, ModelMap model, RedirectAttributes attr) {
		if (service.buscarPorCodigo(banco.getCodigo()) != null) {
			model.addAttribute("success", "Banco encontrado com sucesso;");
			model.addAttribute("bancos", service.buscarPorCodigo(banco.getCodigo()));
			System.out.println(model.toString());
			return "/lista";
		} else {
			attr.addFlashAttribute("fail", "Não existe banco com o codigo informado;");
			return "redirect:/";
		}
	}
}