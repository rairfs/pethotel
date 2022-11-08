package br.ufs.pethotel.dto.pet;

public class ConsultaPetDTO {

	private Long petId;
	private String cracha;
	private String nome;
	private String tipo;
	private String sexo;
	
	public ConsultaPetDTO() {
	}

	public ConsultaPetDTO(Long petId, String cracha, String nome, String tipo, String sexo) {
		this.petId = petId;
		this.cracha = cracha;
		this.nome = nome;
		this.tipo = tipo;
		this.sexo = sexo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
