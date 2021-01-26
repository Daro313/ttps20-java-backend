package com.foodtruckme.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodtruckme.dao.OrganizadorDAO;
import com.foodtruckme.modelo.Organizador;

@RestController
@CrossOrigin
@RequestMapping("/organizadores")
public class OrganizadorControlador {
	
	@Autowired
	private OrganizadorDAO organizadorDAO;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@PostMapping
	public ResponseEntity<Organizador> crear(@RequestBody Organizador org) {
		if (organizadorDAO.existe(org)) {
			return new ResponseEntity<Organizador>(HttpStatus.CONFLICT);
		}
		org.setPassword(encoder.encode(org.getPassword()));
		organizadorDAO.crear(org);
		return new ResponseEntity<Organizador>(org, HttpStatus.CREATED);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Organizador> leer(@PathVariable("id") Long id) {
		Organizador org = organizadorDAO.leer(id);
		if (org == null) {
			return new ResponseEntity<Organizador>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Organizador>(org, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Organizador> actualizar(@PathVariable("id") Long id, @RequestBody Organizador org) {
		
		Organizador actual = organizadorDAO.leer(id);
		
		if (actual == null) {
			return new ResponseEntity<Organizador>(HttpStatus.NOT_FOUND);
		}
		
		actual.setApellido(org.getApellido());
		actual.setEmail(org.getEmail());
		actual.setNombre(org.getNombre());
		actual.setPassword(encoder.encode(org.getPassword()));
		organizadorDAO.actualizar(actual);
		return new ResponseEntity<Organizador>(actual, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Organizador> eliminar(@PathVariable("id") Long id) {
		Organizador ent = organizadorDAO.leer(id);
		if (ent == null) {
			return new ResponseEntity<Organizador>(HttpStatus.NOT_FOUND);
		}
		organizadorDAO.eliminar(id);
		return new ResponseEntity<Organizador>(HttpStatus.NO_CONTENT);
	}
	

	@GetMapping
	public ResponseEntity<List<Organizador>> listar(){
		List<Organizador> lista = organizadorDAO.listar();
		if (lista.isEmpty()) {
			return new ResponseEntity<List<Organizador>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Organizador>>(lista, HttpStatus.OK);
	}
}
