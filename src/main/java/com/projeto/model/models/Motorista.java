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
@Table(name="motorista")
public class Motorista {
	
	private Integer id_motorista;
	
	private String nome_motorista;
	private Integer cpf_Motorista;
	private String rg_Motorista;
	private String sexo_motorista;
	private String data_nascimento_Motorista;
	private String bloco_residencial;
	private String numero_residencia;
	private String n_bloco;
	private String complemento;
	private byte[] foto_motorista;
	private String telefone_motorista;
	private String email_motorista;
	
	//private Porteiro porteiro;
	private Condominio condominio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_motorista")
	public Integer getId_motorista() {
		return id_motorista;
	}
	public void setId_motorista(Integer id_motorista) {
		this.id_motorista = id_motorista;
	}
	
	@Column(name="cpf_motorista", nullable = false)
	public Integer getCpf_Motorista() {
		return cpf_Motorista;
	}
	public void setCpf_Motorista(Integer cpf_Motorista) {
		this.cpf_Motorista = cpf_Motorista;
	}
	
	@Column(name="nome_motorista", nullable = false, length = 50)
	public String getNome_motorista() {
		return nome_motorista;
	}
	public void setNome_motorista(String nome_motorista) {
		this.nome_motorista = nome_motorista;
	}
	
	@Column(name="sexo_motorista", nullable = false, length = 50)
	public String getSexo_motorista() {
		return sexo_motorista;
	}
	public void setSexo_motorista(String sexo_motorista) {
		this.sexo_motorista = sexo_motorista;
	}
	
	@Column(name="data_nascimento_motorista", nullable = false, length = 50)
	public String getData_nascimento_Motorista() {
		return data_nascimento_Motorista;
	}
	public void setData_nascimento_Motorista(String data_nascimento_Motorista) {
		this.data_nascimento_Motorista = data_nascimento_Motorista;
	}
	
	@Column(name="bloco_residencial", length = 50)
	public String getBloco_residencial() {
		return bloco_residencial;
	}
	public void setBloco_residencial(String bloco_residencial) {
		this.bloco_residencial = bloco_residencial;
	}
	
	@Column(name="numero_residencia", nullable = false, length = 50)
	public String getNumero_residencia() {
		return numero_residencia;
	}
	public void setNumero_residencia(String numero_residencia) {
		this.numero_residencia = numero_residencia;
	}
	
	@Column(name="numero_bloco", length = 50)
	public String getN_bloco() {
		return n_bloco;
	}
	public void setN_bloco(String n_bloco) {
		this.n_bloco = n_bloco;
	}
	
	@Column(name="complemento", length = 50)
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@Lob
	@Column(name="foto_motorista", nullable = false)
	public byte[] getFoto_motorista() {
		return foto_motorista;
	}
	public void setFoto_motorista(byte[] foto_motorista) {
		this.foto_motorista = foto_motorista;
	}
	
	@Column(name="telefone_motorista", nullable = false, length = 50)
	public String getTelefone_motorista() {
		return telefone_motorista;
	}
	public void setTelefone_motorista(String telefone_motorista) {
		this.telefone_motorista = telefone_motorista;
	}
	
	@Column(name="email_motorista", nullable = false, length = 50)
	public String getEmail_motorista() {
		return email_motorista;
	}
	public void setEmail_motorista(String email_motorista) {
		this.email_motorista = email_motorista;
	}
	
	@Column(name="rg_motorista", nullable = false, length = 50)
	public String getRg_Motorista() {
		return rg_Motorista;
	}
	public void setRg_Motorista(String rg_Motorista) {
		this.rg_Motorista = rg_Motorista;
	}
	
	/*@ManyToOne
	@JoinColumn(name = "id_porteiro")
	public Porteiro getPorteiro() {
		return porteiro;
	}
	public void setPorteiro(Porteiro porteiro) {
		this.porteiro = porteiro;
	}*/
	
	@ManyToOne
	@JoinColumn(name = "id_condominio")
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
		result = prime * result + ((bloco_residencial == null) ? 0 : bloco_residencial.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((condominio == null) ? 0 : condominio.hashCode());
		result = prime * result + ((cpf_Motorista == null) ? 0 : cpf_Motorista.hashCode());
		result = prime * result + ((data_nascimento_Motorista == null) ? 0 : data_nascimento_Motorista.hashCode());
		result = prime * result + ((email_motorista == null) ? 0 : email_motorista.hashCode());
		result = prime * result + Arrays.hashCode(foto_motorista);
		result = prime * result + ((id_motorista == null) ? 0 : id_motorista.hashCode());
		result = prime * result + ((n_bloco == null) ? 0 : n_bloco.hashCode());
		result = prime * result + ((nome_motorista == null) ? 0 : nome_motorista.hashCode());
		result = prime * result + ((numero_residencia == null) ? 0 : numero_residencia.hashCode());
		result = prime * result + ((rg_Motorista == null) ? 0 : rg_Motorista.hashCode());
		result = prime * result + ((sexo_motorista == null) ? 0 : sexo_motorista.hashCode());
		result = prime * result + ((telefone_motorista == null) ? 0 : telefone_motorista.hashCode());
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
		Motorista other = (Motorista) obj;
		if (bloco_residencial == null) {
			if (other.bloco_residencial != null)
				return false;
		} else if (!bloco_residencial.equals(other.bloco_residencial))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (condominio == null) {
			if (other.condominio != null)
				return false;
		} else if (!condominio.equals(other.condominio))
			return false;
		if (cpf_Motorista == null) {
			if (other.cpf_Motorista != null)
				return false;
		} else if (!cpf_Motorista.equals(other.cpf_Motorista))
			return false;
		if (data_nascimento_Motorista == null) {
			if (other.data_nascimento_Motorista != null)
				return false;
		} else if (!data_nascimento_Motorista.equals(other.data_nascimento_Motorista))
			return false;
		if (email_motorista == null) {
			if (other.email_motorista != null)
				return false;
		} else if (!email_motorista.equals(other.email_motorista))
			return false;
		if (!Arrays.equals(foto_motorista, other.foto_motorista))
			return false;
		if (id_motorista == null) {
			if (other.id_motorista != null)
				return false;
		} else if (!id_motorista.equals(other.id_motorista))
			return false;
		if (n_bloco == null) {
			if (other.n_bloco != null)
				return false;
		} else if (!n_bloco.equals(other.n_bloco))
			return false;
		if (nome_motorista == null) {
			if (other.nome_motorista != null)
				return false;
		} else if (!nome_motorista.equals(other.nome_motorista))
			return false;
		if (numero_residencia == null) {
			if (other.numero_residencia != null)
				return false;
		} else if (!numero_residencia.equals(other.numero_residencia))
			return false;
		if (rg_Motorista == null) {
			if (other.rg_Motorista != null)
				return false;
		} else if (!rg_Motorista.equals(other.rg_Motorista))
			return false;
		if (sexo_motorista == null) {
			if (other.sexo_motorista != null)
				return false;
		} else if (!sexo_motorista.equals(other.sexo_motorista))
			return false;
		if (telefone_motorista == null) {
			if (other.telefone_motorista != null)
				return false;
		} else if (!telefone_motorista.equals(other.telefone_motorista))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Motorista [id_motorista=" + id_motorista + ", nome_motorista=" + nome_motorista + ", cpf_Motorista="
				+ cpf_Motorista + ", rg_Motorista=" + rg_Motorista + ", sexo_motorista=" + sexo_motorista
				+ ", data_nascimento_Motorista=" + data_nascimento_Motorista + ", bloco_residencial="
				+ bloco_residencial + ", numero_residencia=" + numero_residencia + ", n_bloco=" + n_bloco
				+ ", complemento=" + complemento + ", foto_motorista=" + Arrays.toString(foto_motorista)
				+ ", telefone_motorista=" + telefone_motorista + ", email_motorista=" + email_motorista
				+ ", condominio=" + condominio + "]";
	}
	
	
}
