package com.projeto.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.projeto.model.models.Veiculo;

public class VeiculoDao extends GenericDao<Veiculo, Integer>{

	public VeiculoDao(EntityManager entityManager) {
		super(entityManager);
	}
	
public List<Veiculo> listVeiculoPaginacao(Integer numeroPagina, Integer defaultPagina) {
		
		List<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Veiculo u");
		query.setFirstResult(numeroPagina);
		query.setMaxResults(defaultPagina);
		
		listaVeiculo = query.getResultList();
		return listaVeiculo;
	}
}

