package br.ufs.pethotel.init;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.ufs.pethotel.model.Estadia;
import br.ufs.pethotel.model.Pet;
import br.ufs.pethotel.model.Servico;
import br.ufs.pethotel.service.PetService;
import br.ufs.pethotel.service.ServicoService;

@Component
public class Start implements CommandLineRunner {
	
	private PetService petService;
	private ServicoService servicoService;
	
	public Start(PetService petService, ServicoService servicoService) {
		this.petService = petService;
		this.servicoService = servicoService;
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		List<Pet> petsSalvos = petService.listarTodos();
		List<Servico> servicosSalvos = servicoService.listarTodos();
		
		if (petsSalvos.size() == 0 && servicosSalvos.size() == 0) {
			Pet pet1 = new Pet("C0001", "Bolota", "Cachorro", "Puddle", "Masculino");
			petService.cadastrar(pet1);
			Pet pet2 = new Pet("G0002", "Flocos", "Gato", "Vira-lata", "Masculino");
			petService.cadastrar(pet2);
			Pet pet3 = new Pet("P0003", "Jonas", "Papagaio", "Papagaio-galego", "Feminino");
			petService.cadastrar(pet3);
			Pet pet4 = new Pet("C0004", "Pegasus", "Cavalo", "Poitevin", "Masculino");
			petService.cadastrar(pet4);
			
			Servico servico1 = new Servico("Estadia", 100.0, 2);
			Servico servico2 = new Servico("Estadia + Banho", 150.0, 1);
			Servico servico3 = new Servico("Tosa", 30.0, 0);
			
			Estadia estadia1 = new Estadia(pet1, servico1, "10-11-2022", "12-11-2022");
			Estadia estadia2 = new Estadia(pet2, servico1, "10-11-2022", "12-11-2022");
			
			servico1.addEstadia(estadia1);
			servico1.addEstadia(estadia2);
			
			servicoService.cadastrar(servico1);
			servicoService.cadastrar(servico2);
			servicoService.cadastrar(servico3);
			
			
		}
			
	}

}
