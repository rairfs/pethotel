package br.ufs.pethotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		
		petService.cadastrar(pet);
		
		mv.addObject("pet", new Pet());
		mv.addObject("mensagem", "Pet cadastrado com sucesso!");
		
		return mv;
	}
	
}
