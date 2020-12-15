package com.projeto.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto.model.models.Porteiro;

public class PorteiroDao extends GenericDao<Porteiro, Integer>{

	public PorteiroDao(EntityManager entityManager) {
		super(entityManager);
	}
	
public List<Porteiro> listUsuarioPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		List<Porteiro> listaUsuario = new ArrayList<Porteiro>();
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Porteiro u");
		query.setFirstResult(numeroPagina);
		query.setMaxResults(defaultPagina);
		
		listaUsuario = query.getResultList();
		return listaUsuario;
	}
}
