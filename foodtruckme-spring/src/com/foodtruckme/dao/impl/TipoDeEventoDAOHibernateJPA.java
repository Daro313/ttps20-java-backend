package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.TipoDeEventoDAO;
import com.foodtruckme.modelo.TipoDeEvento;

@Repository
public class TipoDeEventoDAOHibernateJPA extends GenericDAOHibernateJPA<TipoDeEvento> implements TipoDeEventoDAO {

	public TipoDeEventoDAOHibernateJPA() {
		super(TipoDeEvento.class);
	}

}
