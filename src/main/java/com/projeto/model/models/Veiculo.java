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
@Table(name="veiculo")
public class Veiculo {
	
	private Integer id_veiculo;
	
	private String placa;
	private byte[] foto_veiculo;
	private String documento;
	private String cor;
	private String marca;
	private String modelo;
	private String ano;
	
	private Motorista motorista;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_veiculo")
	public Integer getId_veiculo() {
		return id_veiculo;
	}
	public void setId_veiculo(Integer id_veiculo) {
		this.id_veiculo = id_veiculo;
	}
	
	@Column(name="ano", nullable = false, length = 50)
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	@Lob
	@Column(name="foto_veiculo", nullable = false)
	public byte[] getFoto_veiculo() {
		return foto_veiculo;
	}
	public void setFoto_veiculo(byte[] foto_veiculo) {
		this.foto_veiculo = foto_veiculo;
	}
	
	
	@Column(name="placa", nullable = false, length = 50)
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	@Column(name="documento", nullable = false, length = 50)
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	@Column(name="cor", nullable = false, length = 50)
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Column(name="marca", nullable = false, length = 50)
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Column(name="modelo", nullable = false, length = 50)
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_motorista")
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + Arrays.hashCode(foto_veiculo);
		result = prime * result + ((id_veiculo == null) ? 0 : id_veiculo.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((motorista == null) ? 0 : motorista.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (!Arrays.equals(foto_veiculo, other.foto_veiculo))
			return false;
		if (id_veiculo == null) {
			if (other.id_veiculo != null)
				return false;
		} else if (!id_veiculo.equals(other.id_veiculo))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (motorista == null) {
			if (other.motorista != null)
				return false;
		} else if (!motorista.equals(other.motorista))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Veiculo [id_veiculo=" + id_veiculo + ", placa=" + placa + ", foto_veiculo="
				+ Arrays.toString(foto_veiculo) + ", documento=" + documento + ", cor=" + cor + ", marca=" + marca
				+ ", modelo=" + modelo + ", ano=" + ano + ", motorista=" + motorista + "]";
	}

	
	
	
	
	
}
