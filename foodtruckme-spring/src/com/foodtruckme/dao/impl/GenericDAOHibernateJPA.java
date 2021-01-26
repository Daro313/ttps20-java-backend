package com.foodtruckme.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.foodtruckme.dao.GenericDAO;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T>{
	
	protected EntityManager entityManager;
	protected Class<T> persistentClass;
	
	public GenericDAOHibernateJPA(Class<T> clase) {
		persistentClass = clase;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public T crear(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public T leer(Serializable id) {
		T entity = this.entityManager.find(this.persistentClass, id);
		return entity;		
	}
	
	@Override
	public void actualizar(T entity) {
		this.entityManager.merge(entity);
	}

	@Override
	public void eliminar(Serializable id) {
			//T entity = leer(id); podria usar este? Sabria que clase es la que llama?
			T entity = this.entityManager.find(this.persistentClass, id);
			this.entityManager.remove(entity);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		List<T> listadoEntidad = this.entityManager.createQuery("FROM "+this.persistentClass.getSimpleName()).getResultList();
		return listadoEntidad;	
	}

}