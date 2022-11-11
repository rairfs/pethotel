package br.ufs.pethotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufs.pethotel.model.Estadia;
import br.ufs.pethotel.model.Servico;
import br.ufs.pethotel.repository.EstadiaRepository;
import br.ufs.pethotel.service.PetService;
import br.ufs.pethotel.service.ServicoService;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	private PetService petService;
	private ServicoService servicoService;
	private EstadiaRepository estadiaRepository;
	
	public PedidoController(PetService petService, ServicoService servicoService, EstadiaRepository estadiaRepository) {
		this.petService = petService;
		this.servicoService = servicoService;
		this.estadiaRepository = estadiaRepository;
	}

	@GetMapping()
	public ModelAndView paginaLista() {
		ModelAndView mv = new ModelAndView("estadia/paginaLista.html");
		mv.addObject("estadias", estadiaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView adicionarPet(String id) {
		ModelAndView mv = new ModelAndView("estadia/formulario.html");
		
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
	
	@PostMapping(path = "/adicionar")
	public ModelAndView adicionarPet(Long id, Estadia estadia) {
		ModelAndView mv = new ModelAndView("estadia/formulario.html");
		
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
}
