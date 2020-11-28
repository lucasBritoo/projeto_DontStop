package com.projeto.model.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T, ID extends Serializable>{
	
	private EntityManager entityManager;
	private final Class<T> classePersistencia;
	
	@SuppressWarnings("unchecked")
	public GenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.classePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	
	 public void save(T entity) {
		 this.getEntityManager().persist(entity);
	 }
	 
	 public void update(T entity) {
		 this.getEntityManager().merge(entity);
	 }
	 
	 public void remove(T entity) {
		 this.getEntityManager().remove(entity);
	 }
	 
	 public T findById(ID id) {
		 return this.getEntityManager().find(getClassePersistencia(), id);
	 }
	 
	 
	 @SuppressWarnings("unchecked")
	 public List<T> findAll(Class<T> classe){
		 List<T> lista = new ArrayList<>();
		 Query query = this.getEntityManager().createQuery("SELECT o FROM "+classe.getSimpleName()+" o");
		 
		 lista = query.getResultList();
		 
		 return lista;
		 
	 }
	 
	 public List<T> findEmail(Class<T> classe, String email){
		 
		 List<T> resultados = new ArrayList<>();

		 Query query = this.getEntityManager().createQuery("SELECT x FROM "+classe.getSimpleName()+" x WHERE x.email LIKE :nome");
		 query.setParameter("nome", email);
		 
		 resultados = query.getResultList();
		 
		 return resultados;
	 }

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getClassePersistencia() {
		return classePersistencia;
	}

}
