package com.foodtruckme.pruebapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodtruckme.dao.UsuarioDAO;

public class TestSpringSimple {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(com.foodtruckme.config.PersistenceConfig.class);
		ctx.scan("com.foodtruckme");
		ctx.refresh();
		
		UsuarioDAO fDAO = ctx.getBean("usuarioDAOHibernateJPA", UsuarioDAO.class);
		
		System.out.println(fDAO.listar());
		
		ctx.close();
	}

}
