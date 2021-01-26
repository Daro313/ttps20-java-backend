package com.foodtruckme.dao;

import com.foodtruckme.modelo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	//public boolean autenticar(String email, String pass);
	public Usuario autenticar(String email, String pass);
	
}
