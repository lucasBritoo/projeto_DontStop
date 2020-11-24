package com.projeto.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.projeto.estrutura.persistencia.ConexaoBancoDados;
import com.projeto.estrutura.util.VariaveisProjeto;

public abstract class ConexaoBancoService {
	
	@PersistenceContext(unitName = VariaveisProjeto.PERSISTENCE_UNIT_NAME)
	private final EntityManager entityManager;
	
	public ConexaoBancoService() {
		this.entityManager = ConexaoBancoDados.getConexaoBancoDados().getEntityManager();
	}
	
	public void close() {
		if(this.getEntityManager().isOpen()) {
			this.getEntityManager().close();
		}
		
	}
	
	public EntityTransaction getTransaction() {
		return this.getEntityManager().getTransaction();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
