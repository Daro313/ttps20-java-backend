package com.foodtruckme.dao;

import com.foodtruckme.modelo.Foodtrucker;

public interface FoodtruckerDAO extends GenericDAO<Foodtrucker> {

	public boolean existe(Foodtrucker f);

}
