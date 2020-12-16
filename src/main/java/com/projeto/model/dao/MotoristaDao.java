package com.projeto.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto.model.models.Motorista;

public class MotoristaDao extends GenericDao<Motorista, Integer>{

	public MotoristaDao(EntityManager entityManager) {
		super(entityManager);
	}
	
public List<Motorista> listMotoristaPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		List<Motorista> listaMotorista = new ArrayList<Motorista>();
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Motorista u");
		query.setFirstResult(numeroPagina);
		query.setMaxResults(defaultPagina);
		
		listaMotorista = query.getResultList();
		return listaMotorista;
	}
}

