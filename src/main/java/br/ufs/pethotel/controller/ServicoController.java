package br.ufs.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufs.pethotel.model.Estadia;
import br.ufs.pethotel.model.Servico;
import br.ufs.pethotel.service.PetService;
import br.ufs.pethotel.service.ServicoService;

@Controller
@RequestMapping("servico")
public class ServicoController {

	private ServicoService servicoService;
	private PetService petService;

	public ServicoController(ServicoService servicoService, PetService petService) {
		this.servicoService = servicoService;
		this.petService = petService;
	}
	
	@GetMapping("/formulario")
	public ModelAndView telaCadastro() {
		ModelAndView mv = new ModelAndView("servico/formulario.html");
		mv.addObject("servico", new Servico());
		return mv;
	}
	
	@PostMapping("/formulario")
	public ModelAndView cadastrar(Servico servico) {
		ModelAndView mv = new ModelAndView("servico/formulario.html");

		if (servico.getServicoId() != null) {
			mv.addObject("servico", servico);
		} else {
			mv.addObject("servico", new Servico());
		}
				
		servicoService.cadastrar(servico);
		
		mv.addObject("mensagem", "Servico salvo com sucesso!");
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
		
		try {
			servicoService.excluir(id);
			redirect.addFlashAttribute("mensagem", "Serviço excluído com sucesso!");
		} catch (Exception e) {
			redirect.addAttribute("mensagem", e.getMessage());
		}
		
		return mv;
	}
	

}
