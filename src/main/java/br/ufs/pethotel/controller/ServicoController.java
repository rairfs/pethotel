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
	public ModelAndView excluir(Long id, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView("redirect:/servico");
		
		try {
			servicoService.excluir(id);
			redirect.addFlashAttribute("mensagem", "Serviço excluído com sucesso!");
		} catch (Exception e) {
			redirect.addAttribute("mensagem", e.getMessage());
		}
		
		return mv;
	}
	
	@GetMapping("/adicionarPet")
	public ModelAndView adicionarPet(String id) {
		ModelAndView mv = new ModelAndView("servico/adicionarPet.html");
		
		Long idConvertido;
		
		try {
			idConvertido = Long.parseLong(id);
		} catch (Exception e) {
			idConvertido = 1L;
			mv.addObject("mensagem", "Não é um número");
		}
		
		
		mv.addObject("estadia", new Estadia());
		mv.addObject("servicoId", idConvertido);
		mv.addObject("pets", petService.listarTodos());
		mv.addObject("servicos", servicoService.listarTodos());
		
		return mv;
	}
	
	@PostMapping(path = "/adicionarPet")
	public ModelAndView adicionarPet(Long id, Estadia estadia) {
		ModelAndView mv = new ModelAndView("servico/adicionarPet.html");
		
		Servico servico;
		
		try {
			servico = servicoService.buscar(estadia.getServico().getServicoId());
		} catch (Exception e) {
			servico = new Servico();
			mv.addObject("mensagem", e.getMessage());
		}
		
		Estadia estadiaConfigurada = new Estadia(estadia.getPet(), servico, estadia.getData_entrada(), estadia.getData_entrada());
		servico.addEstadia(estadiaConfigurada);
		
		try {
			servicoService.cadastrar(servico);
		} catch (Exception e) {
			mv.addObject("mensagem", "Erro ao salvar no banco de dados! Erro: " + e.getMessage());
		}
		
		mv.addObject("estadia", new Estadia());
		mv.addObject("mensagem", "Serviço atualizado com sucesso!");
		mv.addObject("pets", petService.listarTodos());
		
		return mv;
	}
	
	@GetMapping("/removerPet")
	public ModelAndView removerPet(Long id) {
		ModelAndView mv = new ModelAndView("servico/removerPet.html");
		
		Servico servico;
		
		try {
			servico = servicoService.buscar(id);
		} catch (Exception e) {
			servico = new Servico();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("servico", servico);
		mv.addObject("estadiaServico", servico.getEstadia());
		return mv;
	}
	
	@GetMapping("/removerPet/removerPetSucesso")
	public ModelAndView removerItemSucesso(Long servicoId, Long petId) {
		ModelAndView mv = new ModelAndView("redirect:/servico/removerPet?id=" + servicoId);
		
		try {
			servicoService.removerItem(servicoId, petId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return mv;
		
	}
}
