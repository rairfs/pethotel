package br.ufs.pethotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufs.pethotel.model.Estadia;
import br.ufs.pethotel.model.Servico;
import br.ufs.pethotel.service.ServicoService;

@Controller
@RequestMapping("servico")
public class ServicoController {

	private ServicoService servicoService;

	public ServicoController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	
	@GetMapping("/formulario")
	public ModelAndView telaCadastro() {
		ModelAndView mv = new ModelAndView("servico/formulario.html");
		mv.addObject("servico", new Servico());
		return mv;
	}
	
	@PostMapping("/formulario")
	public ModelAndView cadastrar(@Valid Servico servico, BindingResult result) {
		ModelAndView mv = new ModelAndView("servico/formulario.html");
		
		if (result.hasErrors()) {
			mv.addObject("servico", servico);
			return mv;
		}

		if (servico.getServicoId() != null) {
			mv.addObject("servico", servico);
		} else {
			mv.addObject("servico", new Servico());
		}
		
		try {
			servicoService.cadastrar(servico);			
			mv.addObject("mensagem", "Servico salvo com sucesso!");
		} catch (Exception e) {
			mv.addObject("mensagem", e.getMessage());
		}
		
		return mv;
	}
	
	@GetMapping()
	public ModelAndView telaLista() {
		ModelAndView mv = new ModelAndView("servico/paginaLista.html");
		
		List<Servico> servicos = servicoService.listarTodos();
		
		mv.addObject("listaServicos", servicos);
		
		return mv;
	}
	
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("servico/formulario.html");
		
		Servico servico;
		
		try {
			servico = servicoService.buscar(id);
		} catch (Exception e) {
			servico = new Servico();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("servico", servico);
		
		return mv;
	}
	
	@GetMapping("/excluir")
	public ModelAndView excluir(@RequestParam Long id, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView("redirect:/servico");
		
		List<Servico> servicoBefore = servicoService.listarTodos();
		
		try {
			servicoService.excluir(id);			
		} catch (Exception e) {
			redirect.addFlashAttribute("mensagem", e.getMessage());
		}
		
		List<Servico> servicoAfter = servicoService.listarTodos();
		
		Servico servico;
		
		try {
			servico = servicoService.buscar(id);
		} catch (Exception e) {
			servico = new Servico();
			redirect.addFlashAttribute("mensagem", e.getMessage());
		}
		String pets = "";
		
		for (Estadia estadia : servico.getEstadia()) {
			pets = pets + estadia.getPet().getCracha() + "; ";
		}
		
		if (servicoBefore.size() == servicoAfter.size()) {
			redirect.addFlashAttribute("mensagem", "Erro ao excluir! Serviço vinculado aos Pets: " + pets);
		} else {
			redirect.addFlashAttribute("mensagem", "Servico excluído com sucesso!");
		}
		return mv;
	}
	

}
