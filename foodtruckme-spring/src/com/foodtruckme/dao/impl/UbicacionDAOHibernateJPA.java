package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.UbicacionDAO;
import com.foodtruckme.modelo.Ubicacion;

@Repository
public class UbicacionDAOHibernateJPA extends GenericDAOHibernateJPA<Ubicacion> implements UbicacionDAO {

	public UbicacionDAOHibernateJPA() {
		super(Ubicacion.class);
	}

}
