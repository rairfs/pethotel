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
import br.ufs.pethotel.model.Pet;
import br.ufs.pethotel.service.PetService;

@Controller
@RequestMapping("pet")
public class PetController {

	private PetService petService;

	public PetController(PetService petService) {
		this.petService = petService;
	}
	
	@GetMapping("/formulario")
	public ModelAndView telaCadastro() {
		ModelAndView mv = new ModelAndView("pet/formulario.html");
		mv.addObject("pet", new Pet());
		return mv;
	}
	
	@PostMapping("/formulario")
	public ModelAndView cadastrar(@Valid Pet pet, BindingResult result) {
		ModelAndView mv = new ModelAndView("pet/formulario.html");
		
		if (result.hasErrors()) {
			mv.addObject("pet", pet);
			return mv;
		}
		
		if (pet.getPetId() != null) {
			mv.addObject("pet", pet);
		} else {
			mv.addObject("pet", new Pet());
		}
		
		try {
			petService.cadastrar(pet);			
			mv.addObject("mensagem", "Pet salvo com sucesso!");
		} catch (Exception e) {
			mv.addObject("mensagem", e.getMessage());
		}
		
		return mv;
	}
	
	@GetMapping()
	public ModelAndView telaLista() {
		ModelAndView mv = new ModelAndView("pet/paginaLista.html");
		
		List<Pet> pets = petService.listarTodos();

		mv.addObject("listaPets", pets);
		return mv;
	}
	
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("pet/formulario.html");
		
		Pet pet;
		
		try {
			pet = petService.buscar(id);
		} catch (Exception e) {
			pet = new Pet();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("pet", pet);
		
		return mv;
	}
	
	@GetMapping("/excluir")
	public ModelAndView excluir(@RequestParam Long id, RedirectAttributes redirect) {
		ModelAndView mv = new ModelAndView("redirect:/pet");

		List<Pet> petsBefore = petService.listarTodos();

		try {
			this.petService.excluir(id);			
		} catch (Exception e) {
			redirect.addFlashAttribute("mensagem", e.getMessage());
		}
		
		List<Pet> petsAfter = petService.listarTodos();
		
		Pet pet;
		
		try {
			pet = petService.buscar(id);
		} catch (Exception e) {
			pet = new Pet();
			mv.addObject("mensagem", e.getMessage());
		}
		
		String servicos = "";
		
		for (Estadia estadia : pet.getEstadia()) {
			servicos = servicos + estadia.getServico().getTipoServico() + "; ";
		}
		
		if (petsBefore.size() == petsAfter.size()) {
			redirect.addFlashAttribute("mensagem", "Erro ao excluir! Pet vinculado aos Serviços: " + servicos);
		} else {
			redirect.addFlashAttribute("mensagem", "Serviço Excluído com sucesso!");
		}
		
		
		return mv;
	}
	
}
