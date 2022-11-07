package br.ufs.pethotel.dto.servico;

public class ConsultaServicoDTO {
	
	private Long servicoId;
	private String tipoServico;
	private Double valorServico;
	private Integer diasUtilizados;
	
	public ConsultaServicoDTO() {
	}

	public ConsultaServicoDTO(Long servicoId, String tipoServico, Double valorServico, Integer diasUtilizados) {
		this.servicoId = servicoId;
		this.tipoServico = tipoServico;
		this.valorServico = valorServico;
		this.diasUtilizados = diasUtilizados;
	}

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}

	public Integer getDiasUtilizados() {
		return diasUtilizados;
	}

	public void setDiasUtilizados(Integer diasUtilizados) {
		this.diasUtilizados = diasUtilizados;
	}
	
	

}
