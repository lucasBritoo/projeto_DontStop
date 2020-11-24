package com.projeto.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.dao.CondominioDao;
import com.projeto.model.models.Condominio;

public class CondominioService extends ConexaoBancoService{

	
	private CondominioDao condominioDao;
	
	public CondominioService() {
		this.condominioDao = new CondominioDao(this.getEntityManager());
	}
	
	public Integer save(Condominio condominio) {
		
		Integer toReturn =0;
		
		EntityTransaction trx = this.getTransaction();
		
		if(validarDigitacao(condominio) == VariaveisProjeto.DIGITACAO_OK) {
			
			try {
				trx.begin();
				this.getCondominioDao().save(condominio);
				trx.commit();
			}catch(Exception ex) {
				ex.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;
			}finally {
				this.close();
			}
		}else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		
		return toReturn;
	}
	
	public Integer update(Condominio condominio) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		
		if(validarDigitacao(condominio)== VariaveisProjeto.DIGITACAO_OK) {
			
			try {
				trx.begin();
				this.getCondominioDao().update(condominio);
				trx.commit();
			}catch(Exception ex) {
				ex.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;
			}finally {
				this.close();
			}
		}else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn;
	}
	
	public Integer delete(Condominio condominio) {
		Integer toReturn =0;
		
		EntityTransaction trx = this.getTransaction();
		
		try {
			trx.begin();
			Condominio condominioEncontrado = this.getCondominioDao().findById(condominio.getId_condominio());
			this.getCondominioDao().remove(condominioEncontrado);
			trx.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
			toReturn = VariaveisProjeto.ERRO_ALTERACAO;
		}finally {
			this.close();
		}
		return toReturn;
	}
	
	public Condominio findById(Integer id) {
		return this.getCondominioDao().findById(id);
	}
	
	public List<Condominio> findAll(){
		return this.getCondominioDao().findAll(Condominio.class);
	}
	
	public Integer validarDigitacao(Condominio condominio) {
		if(VariaveisProjeto.digitacaoCampo(condominio.getNome_condominio())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		}
		return VariaveisProjeto.DIGITACAO_OK;
	}
	
	public CondominioDao getCondominioDao() {
		return condominioDao;
	}
}
