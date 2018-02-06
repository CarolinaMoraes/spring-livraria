package br.senai.sp.info.pweb.livraria.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario {
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", email=" + email + ", senha=" + senha + "]";
	}

	private Long id;
	
	@Size(min = 1, max = 30, message = "{Size}")
	@NotNull(message = "{NotNull}")
	private String nome;
	
	@Size(min = 1, max = 50, message = "{Size}")
	@NotNull(message = "{NotNull}")
	private String sobrenome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "{NotNull}")
	private Date dataNascimento;
	
	@Email(message = "{Email}")
	@Size(min = 5, message = "{Size}")
	@NotNull(message = "{NotNull}")
	private String email;
	
	@Size(min = 6, max = 20, message = "{Size}")
	@NotNull(message = "{NotNull}")
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
