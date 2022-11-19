package br.ufs.pethotel.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "servicos")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long servicoId;
	
	@NotEmpty(message = "O Tipo de Serviço não pode ser vazio!")
	@Column(nullable = false, length = 50)
	@Size(min = 1, max = 50)
	private String tipoServico;
	
	@Column(nullable = false)
	@DecimalMin(value = "0.1", message = "Valor não pode ser menor que zero")
	private Double valorServico;
	
	@OneToMany(mappedBy = "servico", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Estadia> estadia = new HashSet<>();

	public Servico() {
	}

	public Servico(String tipoServico, Double valorServico) {
		this.tipoServico = tipoServico;
		this.valorServico = valorServico;
	}

	public Servico(String tipoServico, Double valorServico, Set<Estadia> estadia) {
		this.tipoServico = tipoServico;
		this.valorServico = valorServico;
		this.estadia = estadia;
	}

	public Servico(Long servicoId, String tipoServico, Double valorServico,
			Set<Estadia> estadia) {
		this.servicoId = servicoId;
		this.tipoServico = tipoServico;
		this.valorServico = valorServico;
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
