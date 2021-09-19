package aplicacaoEscala.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7259291110393446799L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO")
	private Integer id;

	@Column(name = "NOME_USUARIO", unique = true, length = 25, nullable = false)
	private String nome;

	@Column(name = "NASCIMENTO_USUARIO")
	@Temporal(TemporalType.DATE)
	private java.util.Date dataNascimento;

	@Column(name = "COMUNIDADE_USUARIO", nullable = false)
	private String Comunidade;

	@Column(name = "EMAIL_USUARIO", unique = true, nullable = false)
	private String email;

	@Column(name = "TELEFONE_USUARIO", unique = true, nullable = false)
	private Integer telefone;

	@Column(name = "LOGIN", unique = true, nullable = false)
	private String login;

	@Column(name = "SENHA", nullable = false)
	private String senha;

	public Usuario() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public java.util.Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getComunidade() {
		return Comunidade;
	}

	public void setComunidade(String comunidade) {
		Comunidade = comunidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
