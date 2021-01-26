package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.FoodtruckDAO;
import com.foodtruckme.modelo.Foodtruck;

@Repository
public class FoodtruckDAOHibernateJPA extends GenericDAOHibernateJPA<Foodtruck> implements FoodtruckDAO {

	public FoodtruckDAOHibernateJPA() {
		super(Foodtruck.class);
	}

}
