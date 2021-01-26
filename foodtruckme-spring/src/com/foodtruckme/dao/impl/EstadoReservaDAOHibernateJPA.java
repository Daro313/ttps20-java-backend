package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.EstadoReservaDAO;
import com.foodtruckme.modelo.EstadoReserva;

@Repository
public class EstadoReservaDAOHibernateJPA extends GenericDAOHibernateJPA<EstadoReserva> implements EstadoReservaDAO {

	public EstadoReservaDAOHibernateJPA() {
		super(EstadoReserva.class);
	}

}
