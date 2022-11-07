package br.ufs.pethotel.dto.servico;

import br.ufs.pethotel.model.Servico;

public class ServicoMapper {
	
	public static Servico fromDTO(RegistroServicoDTO dto) {
		return new Servico(dto.getTipoServico(), dto.getValorServico(), dto.getDiasUtilizados());
	}
	
	public static ConsultaServicoDTO fromEntity(Servico servico) {
		return new ConsultaServicoDTO(servico.getServicoId(), servico.getTipoServico(), servico.getValorServico(), servico.getDiasUtilizados());
	}

}
