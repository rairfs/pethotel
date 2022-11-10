package br.ufs.pethotel.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
	
	@NotEmpty(message = "O Tipo não pode ser vazio!")
	@Column(nullable = false, length = 45)
	private String tipo;
	
	@NotEmpty(message = "A raça não pode ser vazio!")
	@Column(nullable = false, length = 45)
	private String raca;
	
	@NotEmpty(message = "O Sexo não pode ser vazio!")
	@Column(nullable = false, length = 9)
	private String sexo;
	
	@OneToMany(mappedBy = "pet")
	private Set<Estadia> estadia = new HashSet<>();

	public Pet() {
	}

	public Pet(String cracha, String nome, String tipo, String raca, String sexo) {
		this.cracha = cracha;
		this.nome = nome;
		this.tipo = tipo;
		this.raca = raca;
		this.sexo = sexo;
	}

	public Pet(String cracha, String nome, String tipo, String raca, String sexo,  Set<Estadia> estadia) {
		this.cracha = cracha;
		this.nome = nome;
		this.tipo = tipo;
		this.raca = raca;
		this.sexo = sexo;
		this.estadia = estadia;
	}
	
	public Pet(Long petId, String cracha, String nome, String tipo, String raca, String sexo,  Set<Estadia> estadia) {
		this.petId = petId;
		this.cracha = cracha;
		this.nome = nome;
		this.tipo = tipo;
		this.raca = raca;
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
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

	public  Set<Estadia> getEstadia() {
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
