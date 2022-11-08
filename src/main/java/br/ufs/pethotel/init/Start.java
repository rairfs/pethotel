package br.ufs.pethotel.init;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
		
		this.petService.limparTabela();
		this.servicoService.limparTabela();
			
		Pet pet = new Pet("C0001", "Bolota", "Cachorro", "Puddle", "Masculino");
		petService.cadastrar(pet);
		pet = new Pet("G0002", "Flocos", "Gato", "Vira-lata", "Masculino");
		petService.cadastrar(pet);
		pet = new Pet("P0003", "Jonas", "Papagaio", "Papagaio-galego", "Feminino");
		petService.cadastrar(pet);
		pet = new Pet("C0004", "Pegasus", "Cavalo", "Poitevin", "Masculino");
		petService.cadastrar(pet);
		
		Servico servico = new Servico("Estadia", 100.0, 2);
		servicoService.cadastrar(servico);
		servico = new Servico("Estadia + Banho", 150.0, 1);
		servicoService.cadastrar(servico);
		servico = new Servico("Tosa", 30.0, 0);
		servicoService.cadastrar(servico);
		
	}

}
