package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.FormaDePagoDAO;
import com.foodtruckme.modelo.FormaDePago;

@Repository
public class FormaDePagoDAOHibernateJPA extends GenericDAOHibernateJPA<FormaDePago> implements FormaDePagoDAO {

	public FormaDePagoDAOHibernateJPA() {
		super(FormaDePago.class);
	}

}
