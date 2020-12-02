package com.projeto.model.models;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="porteiro")
public class Porteiro {
	
	private Integer id_porteiro;
	private long cpf_Porteiro;
	private String nome_Porteiro;
	private String rg_Porteiro;
	private String telefone;
	private String email;
	private String senha;
	private byte[] foto_porteiro;
	
	private Condominio condominio;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_porteiro")
	public Integer getId_porteiro() {
		return id_porteiro;
	}
	public void setId_porteiro(Integer id_porteiro) {
		this.id_porteiro = id_porteiro;
	}
	
	@Column(name="cpf_porteiro", nullable = false)
	public long getCpf_Porteiro() {
		return cpf_Porteiro;
	}
	public void setCpf_Porteiro(long cpf_Porteiro) {
		this.cpf_Porteiro = cpf_Porteiro;
	}
	
	
	@Column(name="nome_porteiro", nullable = false, length = 50)
	public String getNome_Porteiro() {
		return nome_Porteiro;
	}
	public void setNome_Porteiro(String nome_Porteiro) {
		this.nome_Porteiro = nome_Porteiro;
	}
	
	
	@Column(name="rg_porteiro", nullable = false, length = 50)
	public String getRg_Porteiro() {
		return rg_Porteiro;
	}
	public void setRg_Porteiro(String rg_Porteiro) {
		this.rg_Porteiro = rg_Porteiro;
	}
	
	@Column(name="telefone", nullable = false, length = 50)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name= "email", nullable = false, length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="senha", nullable = false, length = 50)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Lob
	@Column(name="foto_porteiro", nullable = false)
	public byte[] getFoto_porteiro() {
		return foto_porteiro;
	}
	public void setFoto_porteiro(byte[] foto_porteiro) {
		this.foto_porteiro = foto_porteiro;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "id_condominio", nullable = false)
	public Condominio getCondominio() {
		return condominio;
	}
	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condominio == null) ? 0 : condominio.hashCode());
		result = prime * result + (int) (cpf_Porteiro ^ (cpf_Porteiro >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + Arrays.hashCode(foto_porteiro);
		result = prime * result + ((id_porteiro == null) ? 0 : id_porteiro.hashCode());
		result = prime * result + ((nome_Porteiro == null) ? 0 : nome_Porteiro.hashCode());
		result = prime * result + ((rg_Porteiro == null) ? 0 : rg_Porteiro.hashCode());
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
		Porteiro other = (Porteiro) obj;
		if (condominio == null) {
			if (other.condominio != null)
				return false;
		} else if (!condominio.equals(other.condominio))
			return false;
		if (cpf_Porteiro != other.cpf_Porteiro)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (!Arrays.equals(foto_porteiro, other.foto_porteiro))
			return false;
		if (id_porteiro == null) {
			if (other.id_porteiro != null)
				return false;
		} else if (!id_porteiro.equals(other.id_porteiro))
			return false;
		if (nome_Porteiro == null) {
			if (other.nome_Porteiro != null)
				return false;
		} else if (!nome_Porteiro.equals(other.nome_Porteiro))
			return false;
		if (rg_Porteiro == null) {
			if (other.rg_Porteiro != null)
				return false;
		} else if (!rg_Porteiro.equals(other.rg_Porteiro))
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
		return "Porteiro [id_porteiro=" + id_porteiro + ", cpf_Porteiro=" + cpf_Porteiro + ", nome_Porteiro="
				+ nome_Porteiro + ", rg_Porteiro=" + rg_Porteiro + ", telefone=" + telefone + ", email=" + email
				+ ", senha=" + senha + ", foto_porteiro=" + Arrays.toString(foto_porteiro) + ", condominio="
				+ condominio + "]";
	}
	
	
}
