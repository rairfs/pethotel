package br.ufs.pethotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ufs.pethotel.model.Servico;
import br.ufs.pethotel.repository.ServicoRepository;

@Service
public class ServicoService {
	
	private ServicoRepository servicoRepository;
	
	public ServicoService(ServicoRepository servicoRepository) {
		this.servicoRepository = servicoRepository;
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
	
	public void limparTabela() {
		this.servicoRepository.deleteAll();
	}
	
	public void removerItem(Long servicoId, Long petId) {
		this.servicoRepository.DeletarByServicoIdAndPetId(servicoId, petId);
	}

}
