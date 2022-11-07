package br.ufs.pethotel.service;

import java.util.List;
import java.util.Optional;

import br.ufs.pethotel.model.Servico;
import br.ufs.pethotel.repository.EstadiaRepository;
import br.ufs.pethotel.repository.ServicoRepository;

public class ServicoService {
	
	private ServicoRepository servicoRepository;
	private EstadiaRepository estadiaRepository;
	
	public ServicoService(ServicoRepository servicoRepository, EstadiaRepository estadiaRepository) {
		this.servicoRepository = servicoRepository;
		this.estadiaRepository = estadiaRepository;
	}
	
	public List<Servico> listarTodos(){
		return this.servicoRepository.findAll();	
	}
	
	public Servico cadastrar(Servico servico) {
		return this.servicoRepository.save(servico);
	}
	
	public Servico buscar(Long id) throws Exception {
		Optional<Servico> optional = this.servicoRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new Exception("Serviço não encontrado!");
		}
		
		return optional.get();
	}
	
	public void excluir(Long id) {
		this.servicoRepository.deleteById(id);
	}

}
