package br.ufs.pethotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.pethotel.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
