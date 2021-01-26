package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.TipoDeServicioDAO;
import com.foodtruckme.modelo.TipoDeServicio;

@Repository
public class TipoDeServicioDAOHibernateJPA extends GenericDAOHibernateJPA<TipoDeServicio> implements TipoDeServicioDAO {

	public TipoDeServicioDAOHibernateJPA() {
		super(TipoDeServicio.class);
	}

}
