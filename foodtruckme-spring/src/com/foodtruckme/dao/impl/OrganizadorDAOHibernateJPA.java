package com.foodtruckme.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.OrganizadorDAO;
import com.foodtruckme.modelo.Organizador;

@Repository
public class OrganizadorDAOHibernateJPA extends GenericDAOHibernateJPA<Organizador> implements OrganizadorDAO {

	public OrganizadorDAOHibernateJPA() {
		super(Organizador.class);
	}

	public boolean existe(Organizador org) {
		String hql = "SELECT o FROM Organizador o WHERE o.email ='"+org.getEmail()+"'";
		@SuppressWarnings("unchecked")
		List<Organizador> ent = this.entityManager.createQuery(hql).getResultList();
		if (ent.isEmpty()) {
			return false;
		}
		return true;
	}
}
