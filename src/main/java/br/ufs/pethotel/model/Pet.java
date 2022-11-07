package br.ufs.pethotel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petId;
	
	@NotEmpty(message = "O Crachá não pode ser vazio!")
	@Column(unique = true, nullable = false, length = 10)
	private String cracha;
	
	@NotEmpty(message = "O Nome não pode ser vazio!")
	@Column(nullable = false, length = 45)
	private String nome;
	
	@NotEmpty(message = "O Sexo não pode ser vazio!")
	@Column(nullable = false, length = 9)
	private String sexo;
	
	@OneToMany(mappedBy = "pet")
	private List<Estadia> estadia = new ArrayList<>();

	public Pet() {
	}

	public Pet(String cracha, String nome, String sexo) {
		this.cracha = cracha;
		this.nome = nome;
		this.sexo = sexo;
	}

	public Pet(String cracha, String nome, String sexo, List<Estadia> estadia) {
		this.cracha = cracha;
		this.nome = nome;
		this.sexo = sexo;
		this.estadia = estadia;
	}
	
	public Pet(Long petId, String cracha, String nome, String sexo, List<Estadia> estadia) {
		this.petId = petId;
		this.cracha = cracha;
		this.nome = nome;
		this.sexo = sexo;
		this.estadia = estadia;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public String getCracha() {
		return cracha;
	}

	public void setCracha(String cracha) {
		this.cracha = cracha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

	public List<Estadia> getEstadia() {
		return estadia;
	}

	public void setEstadia(List<Estadia> estadia) {
		this.estadia = estadia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cracha, petId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return Objects.equals(cracha, other.cracha) && Objects.equals(petId, other.petId);
	}
	
	
}
