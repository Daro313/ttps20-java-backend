package com.foodtruckme.dao;

import com.foodtruckme.modelo.Organizador;

public interface OrganizadorDAO extends GenericDAO<Organizador> {
	
	public boolean existe(Organizador o);
}
