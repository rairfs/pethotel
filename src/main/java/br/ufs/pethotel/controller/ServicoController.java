package br.ufs.pethotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufs.pethotel.dto.servico.RegistroServicoDTO;
import br.ufs.pethotel.dto.servico.ServicoMapper;
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
	public ModelAndView cadastrar(RegistroServicoDTO dto) {
		ModelAndView mv = new ModelAndView("servico/formulario.html");

		mv.addObject("servico", new Servico());
		
		Servico servico = ServicoMapper.fromDTO(dto);
		servicoService.cadastrar(servico);
		return mv;
	}
	
	@GetMapping()
	public ModelAndView telaLista() {
		ModelAndView mv = new ModelAndView("servico/paginaLista.html");
		
		List<Servico> servicos = servicoService.listarTodos();
		
		mv.addObject("listaServicos", servicos);
		
		return mv;
	}
	
}
