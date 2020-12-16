package com.projeto.model.models;

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
	
	private Integer cpf_Motorista;
	private String nome_motorista;
	private String sexo_motorista;
	private String data_nascimento_Motorista;
	private String bloco_residencial;
	private String numero_residencia;
	private String n_bloco;
	private String complemento;
	private byte[] foto_motorista;
	private String telefone_motorista;
	private String email_motorista;
	
	private Porteiro porteiro;
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
	
	@ManyToOne
	@JoinColumn(name = "id_porteiro")
	public Porteiro getPorteiro() {
		return porteiro;
	}
	public void setPorteiro(Porteiro porteiro) {
		this.porteiro = porteiro;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_condominio")
	public Condominio getCondominio() {
		return condominio;
	}
	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

}
