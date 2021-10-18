package aplicacaoEscala.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMUNIDADES")
public class Comunidade implements Serializable {

	private static final long serialVersionUID = 8633525031601154015L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_Comunidade")
	private Integer id;
	@Column(name = "Nome_Comunidade", nullable = false, unique = true)
	private String nomeComunidade;
	@Column(name = "Endereco_Comunidade", nullable = false, unique = true)
	private String endereco;

	@Column(name = "Telefone_Comunidade", nullable = false, unique = true)
	private String telefone;

	public Integer getId() {
		return id;
	}

	public String getNomeComunidade() {
		return nomeComunidade;
	}

	public void setNomeComunidade(String nomeComunidade) {
		this.nomeComunidade = nomeComunidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	 @Override public String toString() { return String.format("%s[%s]",
	 getClass().getSimpleName(), getNomeComunidade()); }
	  
	 
}
