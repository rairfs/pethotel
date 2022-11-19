package br.ufs.pethotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufs.pethotel.model.Estadia;
import br.ufs.pethotel.model.Pet;
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
	public ModelAndView telaCadastro() {
		ModelAndView mv = new ModelAndView("estadia/formulario.html");
		
		mv.addObject("estadia", new Estadia());
		mv.addObject("pets", petService.listarTodos());
		mv.addObject("servicos", servicoService.listarTodos());
		
		return mv;
	}
	
	@PostMapping(path = "/adicionar")
	public ModelAndView cadastrar(Estadia estadia) {
		ModelAndView mv = new ModelAndView("estadia/formulario.html");
		
		if (estadia.getEstadiaId() != null) {
			mv.addObject("estadia", estadia);
		} else {
			mv.addObject("estadia", new Estadia());
		}
		
		try {
			estadiaRepository.save(estadia);			
		} catch (Exception e) {
			mv.addObject("mensagem", e.getMessage());
		}
		
		return mv;
	}
	
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Long petId, @RequestParam Long servicoId) {
		ModelAndView mv = new ModelAndView("estadia/formulario.html");
		
		Estadia estadia;
		
		try {
			estadia = estadiaRepository.findByPetPetIdAndServicoServicoId(petId, servicoId);
			System.out.println(estadia);
		} catch (Exception e) {
			estadia = new Estadia();
			mv.addObject("mensagem", e.getMessage());
		}
		
		//TODO Terminar de ajustar
		mv.addObject("estadia", estadia);
		mv.addObject("pets", petService.listarTodos());
		mv.addObject("servicos", servicoService.listarTodos());
		
		return mv;
	}
	
	@GetMapping("/excluir")
	public ModelAndView excluir(@RequestParam Long petId, @RequestParam Long servicoId) {
		ModelAndView mv = new ModelAndView("redirect:/pedido");
		
		System.out.println(servicoId);
		System.out.println(petId);
		this.servicoService.removerItem(servicoId, petId);
		
		return mv;
	}
	
}
