package br.ufs.pethotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.pethotel.model.Estadia;
import br.ufs.pethotel.model.EstadiaId;

public interface EstadiaRepository extends JpaRepository<Estadia, EstadiaId> {

}
