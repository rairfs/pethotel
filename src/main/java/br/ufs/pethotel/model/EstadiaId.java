package br.ufs.pethotel.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class EstadiaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2534133001842290563L;

	private Long petId;
	private Long servicoId;
	
	public EstadiaId() {
	}

	public EstadiaId(Long petId, Long servicoId) {
		this.petId = petId;
		this.servicoId = servicoId;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(petId, servicoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadiaId other = (EstadiaId) obj;
		return Objects.equals(petId, other.petId) && Objects.equals(servicoId, other.servicoId);
	}

	
}
