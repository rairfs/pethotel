package br.ufs.pethotel.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "estadias")
public class Estadia {

	@EmbeddedId
	private EstadiaId estadiaId = new EstadiaId();
	
	@ManyToOne
	@MapsId("petId")
	private Pet pet;
	
	@MapsId("servicoId")
	@ManyToOne
	private Servico servico;
	
	private Date data_entrada;
	
	private Date data_saida;

	public Estadia() {
	}

	public Estadia(EstadiaId estadiaId, Pet pet, Servico servico, Date data_entrada, Date data_saida) {
		this.estadiaId = estadiaId;
		this.pet = pet;
		this.servico = servico;
		this.data_entrada = data_entrada;
		this.data_saida = data_saida;
	}

	public EstadiaId getEstadiaId() {
		return estadiaId;
	}

	public void setEstadiaId(EstadiaId estadiaId) {
		this.estadiaId = estadiaId;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pet, servico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadia other = (Estadia) obj;
		return Objects.equals(pet, other.pet) && Objects.equals(servico, other.servico);
	}
	
}
