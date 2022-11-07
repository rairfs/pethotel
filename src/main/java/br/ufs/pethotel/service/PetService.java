package br.ufs.pethotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ufs.pethotel.model.Pet;
import br.ufs.pethotel.repository.EstadiaRepository;
import br.ufs.pethotel.repository.PetRepository;

@Service
public class PetService {

	private PetRepository petRepository;
	private EstadiaRepository estadiaRepository;
	
	public PetService(PetRepository petRepository, EstadiaRepository estadiaRepository) {
		this.petRepository = petRepository;
		this.estadiaRepository = estadiaRepository;
	}
	
	public List<Pet> listarTodos(){
		return this.petRepository.findAll();
	}
	
	public Pet cadastrar(Pet pet) {
		return this.petRepository.save(pet);
	}
	
	public Pet buscar(Long id) throws Exception {
		Optional<Pet> optional = this.petRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new Exception("Pet não encontrado!");
		}
		
		return optional.get();
	}
	
	public void excluir(Long id) {
		this.petRepository.deleteById(id);
	}
	
}
