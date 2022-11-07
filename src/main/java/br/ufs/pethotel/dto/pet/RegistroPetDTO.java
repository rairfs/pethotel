package br.ufs.pethotel.dto.pet;

public class RegistroPetDTO {
	
	private String cracha;
	private String nome;
	private String sexo;
	
	public RegistroPetDTO() {
	}

	public RegistroPetDTO(String cracha, String nome, String sexo) {
		this.cracha = cracha;
		this.nome = nome;
		this.sexo = sexo;
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
	
	

}
