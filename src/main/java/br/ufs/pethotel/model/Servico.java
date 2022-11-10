package br.ufs.pethotel.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "servicos")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long servicoId;
	
	@NotEmpty(message = "O Tipo de Serviço não pode ser vazio!")
	@Column(nullable = false, length = 50)
	private String tipoServico;
	
	@Column(nullable = false)
	private Double valorServico;
	
	private Integer diasUtilizados;
	
	@OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
	private Set<Estadia> estadia = new HashSet<>();

	public Servico() {
	}

	public Servico(String tipoServico, Double valorServico, Integer diasUtilizados) {
		this.tipoServico = tipoServico;
		this.valorServico = valorServico;
		this.diasUtilizados = diasUtilizados;
	}

	public Servico(String tipoServico, Double valorServico, Integer diasUtilizados, Set<Estadia> estadia) {
		this.tipoServico = tipoServico;
		this.valorServico = valorServico;
		this.diasUtilizados = diasUtilizados;
		this.estadia = estadia;
	}

	public Servico(Long servicoId, String tipoServico, Double valorServico, Integer diasUtilizados,
			Set<Estadia> estadia) {
		this.servicoId = servicoId;
		this.tipoServico = tipoServico;
		this.valorServico = valorServico;
		this.diasUtilizados = diasUtilizados;
		this.estadia = estadia;
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

	public Set<Estadia> getEstadia() {
		return estadia;
	}

	public void setEstadia(Set<Estadia> estadia) {
		this.estadia = estadia;
	}
	
	public void addEstadia(Estadia estadia) {
		this.estadia.add(estadia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(servicoId, tipoServico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(servicoId, other.servicoId) && Objects.equals(tipoServico, other.tipoServico);
	}
	
	
}
