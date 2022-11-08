package br.ufs.pethotel.dto.pet;

import br.ufs.pethotel.model.Pet;

public class PetMapper {

	public static Pet fromDTO(RegistroPetDTO dto) {
		return new Pet(dto.getCracha(), dto.getNome(), dto.getSexo(), dto.getTipo());
	}
	
	public static ConsultaPetDTO fromEntity(Pet pet) {
		return new ConsultaPetDTO(pet.getPetId(), pet.getCracha(), pet.getNome(), pet.getTipo(), pet.getSexo());
	}
}
