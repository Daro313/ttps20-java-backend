package com.foodtruckme.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.FoodtruckerDAO;
import com.foodtruckme.modelo.Foodtrucker;

@Repository
public class FoodtruckerDAOHibernateJPA extends GenericDAOHibernateJPA<Foodtrucker> implements FoodtruckerDAO {

	public FoodtruckerDAOHibernateJPA() {
		super(Foodtrucker.class);
	}
		
	public boolean existe(Foodtrucker ft) {
		String hql = "SELECT o FROM Foodtrucker o WHERE o.email ='"+ft.getEmail()+"'";
		@SuppressWarnings("unchecked")
		List<Foodtrucker> ent = this.entityManager.createQuery(hql).getResultList();
		if (ent.isEmpty()) {
			return false;
		}
		return true;
	}
}
