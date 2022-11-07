package br.ufs.pethotel.dto.servico;

public class RegistroServicoDTO {

	private String tipoServico;
	private Double valorServico;
	private Integer diasUtilizados;
	
	public RegistroServicoDTO() {
	}

	public RegistroServicoDTO(String tipoServico, Double valorServico, Integer diasUtilizados) {
		this.tipoServico = tipoServico;
		this.valorServico = valorServico;
		this.diasUtilizados = diasUtilizados;
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
