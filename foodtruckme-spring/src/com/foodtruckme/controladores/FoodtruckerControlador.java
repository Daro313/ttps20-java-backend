package com.foodtruckme.controladores;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

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

import com.foodtruckme.dao.FoodtruckerDAO;
import com.foodtruckme.modelo.Foodtruck;
import com.foodtruckme.modelo.Foodtrucker;

@RestController
@CrossOrigin
@RequestMapping("/foodtruckers")
public class FoodtruckerControlador {

	@Autowired
	private FoodtruckerDAO ftrDAO;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@PostMapping
	public ResponseEntity<Foodtrucker> crear(@RequestBody Foodtrucker ftr) {
		if (ftrDAO.existe(ftr)) {
			return new ResponseEntity<Foodtrucker>(HttpStatus.CONFLICT);
		}
		ftr.setPassword(encoder.encode(ftr.getPassword()));
		ftrDAO.crear(ftr);
		return new ResponseEntity<Foodtrucker>(ftr, HttpStatus.CREATED);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Foodtrucker> leer(@PathVariable("id") Long id) {
		Foodtrucker ftr = (Foodtrucker) ftrDAO.leer(id);
		if (ftr == null) {
			return new ResponseEntity<Foodtrucker>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Foodtrucker>(ftr, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Foodtrucker> actualizar(@PathVariable("id") Long id, @RequestBody Foodtrucker ftr) {
		
		Foodtrucker ftrBd = ftrDAO.leer(id);
		
		if (ftrBd == null) {
			return new ResponseEntity<Foodtrucker>(HttpStatus.NOT_FOUND);
		}
		
		ftrBd.setApellido(ftr.getApellido());
		ftrBd.setEmail(ftr.getEmail());
		ftrBd.setNombre(ftr.getNombre());
		ftrBd.setPassword(encoder.encode(ftr.getPassword()));
		
		ftrDAO.actualizar(ftrBd);
		return new ResponseEntity<Foodtrucker>(ftrBd, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Foodtrucker> eliminar(@PathVariable("id") Long id) {
		Foodtrucker ftr = ftrDAO.leer(id);
		if (ftr == null) {
			return new ResponseEntity<Foodtrucker>(HttpStatus.NOT_FOUND);
		}
		ftrDAO.eliminar(id);
		return new ResponseEntity<Foodtrucker>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<List<Foodtrucker>> listar(){
		List<Foodtrucker> listaFtr = ftrDAO.listar();
		if (listaFtr.isEmpty()) {
			return new ResponseEntity<List<Foodtrucker>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Foodtrucker>>(listaFtr, HttpStatus.OK);
	}
	
	@Transactional
	@GetMapping("/{id}/foodtrucks")
	public ResponseEntity<Set<Foodtruck>> listarPorPropietario(@PathVariable("id") Long id){
		Foodtrucker ftr = ftrDAO.leer(id);
		if (ftr == null) {
			return new ResponseEntity<Set<Foodtruck>>(HttpStatus.NO_CONTENT);
		}
		Set<Foodtruck> listaFts = ftr.getFoodtrucks();
		return new ResponseEntity<Set<Foodtruck>>(listaFts, HttpStatus.OK);	
	}
	
}
