package br.ufs.pethotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.pethotel.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

	@Modifying
	@Transactional
	@Query("delete from Estadia e where e.servico.servicoId=?1 and e.pet.petId=?2")
	public void DeletarByServicoIdAndPetId(Long servicoId, Long petId);
}
