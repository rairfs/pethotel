package br.ufs.pethotel.dto.servico;

public class RegistroServicoDTO {

	private String tipoServico;
	private String valorServico;
	private Integer diasUtilizados;
	
	public RegistroServicoDTO() {
	}

	public RegistroServicoDTO(String tipoServico, String valorServico, Integer diasUtilizados) {
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

	public String getValorServico() {
		return valorServico;
	}

	public void setValorServico(String valorServico) {
		this.valorServico = valorServico;
	}

	public Integer getDiasUtilizados() {
		return diasUtilizados;
	}

	public void setDiasUtilizados(Integer diasUtilizados) {
		this.diasUtilizados = diasUtilizados;
	}
	
}
