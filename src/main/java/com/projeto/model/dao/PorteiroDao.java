package com.projeto.model.dao;

import javax.persistence.EntityManager;

import com.projeto.model.models.Porteiro;

public class PorteiroDao extends GenericDao<Porteiro, Integer>{

	public PorteiroDao(EntityManager entityManager) {
		super(entityManager);
	}
}
