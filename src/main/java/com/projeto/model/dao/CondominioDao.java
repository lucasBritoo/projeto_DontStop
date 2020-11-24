package com.projeto.model.dao;

import javax.persistence.EntityManager;

import com.projeto.model.models.Condominio;

public class CondominioDao extends GenericDao<Condominio, Integer>{
	
	public CondominioDao(EntityManager entityManager) {
		super(entityManager);
	}
}
