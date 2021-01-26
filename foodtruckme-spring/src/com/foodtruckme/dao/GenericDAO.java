package com.foodtruckme.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
	
	public T crear(T entity);
	public T leer (Serializable id);
	public void actualizar (T entity);
	public void eliminar(Serializable id);
	public List<T> listar();
	
}
