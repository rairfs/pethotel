package br.ufs.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView cadastrar(Pet pet) {
		ModelAndView mv = new ModelAndView("pet/formulario.html");
		
		if (pet.getPetId() != null) {
			mv.addObject("pet", pet);
		} else {
			mv.addObject("pet", new Pet());
		}
		
		petService.cadastrar(pet);

		mv.addObject("mensagem", "Pet salvo com sucesso!");
		
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
		
		try {
			this.petService.excluir(id);
			redirect.addFlashAttribute("mensagem", "Pet excluído com sucesso!");
		} catch (Exception e) {
			redirect.addAttribute("mensagem", e.getMessage());
		}
		
		return mv;
	}
	
}
