package br.ufs.pethotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.pethotel.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
