package br.ufs.pethotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufs.pethotel.service.ServicoService;

@Controller
@RequestMapping("servicos")
public class ServicoController {

	private ServicoService servicoService;

	public ServicoController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	
	
}
