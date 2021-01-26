package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.ReservaDAO;
import com.foodtruckme.modelo.Reserva;

@Repository
public class ReservaDAOHibernateJPA extends GenericDAOHibernateJPA<Reserva> implements ReservaDAO {

	public ReservaDAOHibernateJPA() {
		super(Reserva.class);
	}

}
