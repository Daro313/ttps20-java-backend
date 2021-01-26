package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.PuntajeDAO;
import com.foodtruckme.modelo.Puntaje;

@Repository
public class PuntajeDAOHibernateJPA extends GenericDAOHibernateJPA<Puntaje> implements PuntajeDAO {

	public PuntajeDAOHibernateJPA() {
		super(Puntaje.class);
	}

}
