package com.projeto.model.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONDOMINIO")
public class Condominio {
	
	
	private Integer id_condominio;
	private String nome_condominio;	
	private String logradouro;
	private String cep;
	private int n_instituicao;
	private String bairro;
	private String complemento;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	private String senha;
	
	private List<Porteiro> porteiro;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_condominio")
	public Integer getId_condominio() {
		return id_condominio;
	}
	public void setId_condominio(Integer id_condominio) {
		this.id_condominio = id_condominio;
	}
	
	@Column(name = "nome_condominio", length = 60, nullable = false)
	public String getNome_condominio() {
		return nome_condominio;
	}
	public void setNome_condominio(String nome_condominio) {
		this.nome_condominio = nome_condominio;
	}
	
	@Column(name="logradouro", length= 60, nullable = false)
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@Column(name="cep", length= 60, nullable = false)
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Column(name="n_instituicao", nullable=false)
	public int getN_instituicao() {
		return n_instituicao;
	}
	public void setN_instituicao(int n_instituicao) {
		this.n_instituicao = n_instituicao;
	}
	
	@Column(name="bairro", length= 60, nullable= false)
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@Column(name="complemento", length= 60)
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@Column(name="cidade", length = 60, nullable = false)
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Column(name="estado", length= 60, nullable = false)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name= "telefone", length = 60, nullable = false)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name="email", length = 60, nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="senha", length = 60, nullable = false)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@OneToMany(mappedBy="id_porteiro")
	public List<Porteiro> getPorteiro() {
		return porteiro;
	}
	public void setPorteiro(List<Porteiro> porteiro) {
		this.porteiro = porteiro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id_condominio == null) ? 0 : id_condominio.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + n_instituicao;
		result = prime * result + ((nome_condominio == null) ? 0 : nome_condominio.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Condominio other = (Condominio) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id_condominio == null) {
			if (other.id_condominio != null)
				return false;
		} else if (!id_condominio.equals(other.id_condominio))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (n_instituicao != other.n_instituicao)
			return false;
		if (nome_condominio == null) {
			if (other.nome_condominio != null)
				return false;
		} else if (!nome_condominio.equals(other.nome_condominio))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Condominio [id_condominio=" + id_condominio + ", nome_condominio=" + nome_condominio + ", logradouro="
				+ logradouro + ", cep=" + cep + ", n_instituicao=" + n_instituicao + ", bairro=" + bairro
				+ ", complemento=" + complemento + ", cidade=" + cidade + ", estado=" + estado + ", telefone="
				+ telefone + ", email=" + email + ", senha=" + senha + "]";
	}
	
	
	
	
}
