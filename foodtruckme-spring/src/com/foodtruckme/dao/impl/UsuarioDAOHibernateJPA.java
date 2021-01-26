package com.foodtruckme.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.foodtruckme.dao.UsuarioDAO;
import com.foodtruckme.modelo.Usuario;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}
	
	/*public boolean autenticar(String email, String pass) {
		String hql = "SELECT u FROM Usuario u WHERE u.email ='"+email+"'";
		Usuario u = (Usuario) this.entityManager.createQuery(hql).getSingleResult();
			return encoder.matches(pass, u.getPassword());
	}*/
	
	public Usuario autenticar(String email, String pass) {
		String hql = "SELECT u FROM Usuario u WHERE u.email ='"+email+"'";
		Usuario u = (Usuario) this.entityManager.createQuery(hql).getSingleResult();
		if (encoder.matches(pass, u.getPassword())) {
			return u;
		}
		return null;
	}
}
