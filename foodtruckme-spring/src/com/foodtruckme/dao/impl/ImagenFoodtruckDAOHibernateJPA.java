package com.foodtruckme.dao.impl;

import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.ImagenFoodtruckDAO;
import com.foodtruckme.modelo.ImagenFoodtruck;

@Repository
public class ImagenFoodtruckDAOHibernateJPA extends GenericDAOHibernateJPA<ImagenFoodtruck> implements ImagenFoodtruckDAO {

	public ImagenFoodtruckDAOHibernateJPA() {
		super(ImagenFoodtruck.class);
	}

}
