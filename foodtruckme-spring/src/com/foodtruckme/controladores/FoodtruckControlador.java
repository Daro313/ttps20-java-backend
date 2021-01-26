package com.foodtruckme.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodtruckme.dao.FoodtruckDAO;
import com.foodtruckme.modelo.Foodtruck;

@RestController
@CrossOrigin
@RequestMapping("/foodtrucks")
public class FoodtruckControlador {
	
	@Autowired
	private FoodtruckDAO ftDAO;
	
	@GetMapping
	public ResponseEntity<List<Foodtruck>> listar(){
		List<Foodtruck> listaFt = ftDAO.listar();
		if (listaFt.isEmpty()) {
			return new ResponseEntity<List<Foodtruck>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Foodtruck>>(listaFt, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Foodtruck> leer(@PathVariable("id") Long id){
		Foodtruck ft = ftDAO.leer(id);
		if (ft == null) {
			return new ResponseEntity<Foodtruck>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Foodtruck>(ft, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Foodtruck> crear(@RequestBody Foodtruck ft){
		ftDAO.crear(ft);
		return new ResponseEntity<Foodtruck>(ft,HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Foodtruck> actualizar(@PathVariable("id") Long id, @RequestBody Foodtruck ft){
		Foodtruck ftBd = ftDAO.leer(id);
		if (ftBd == null) {
			return new ResponseEntity<Foodtruck>(HttpStatus.NOT_FOUND);
		}
		ftBd.setDescripcion(ft.getDescripcion());
		ftBd.setFoodtrucker(ft.getFoodtrucker());
		//ftBd.setImagenes(ft.getImagenes());
		ftBd.setInstagram(ft.getInstagram());
		ftBd.setNombre(ft.getNombre());
		//ftBd.setPuntajes(ft.getPuntajes());
		ftBd.setReservas(ft.getReservas());
		ftBd.setServicios(ft.getServicios());
		ftBd.setTwitter(ft.getTwitter());
		ftBd.setUbicacion(ft.getUbicacion());
		ftBd.setUrl(ft.getUrl());
		ftBd.setWhatsapp(ft.getWhatsapp());
		ftDAO.actualizar(ftBd);
		return new ResponseEntity<Foodtruck>(ftBd, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Foodtruck> eliminar(@PathVariable("id") Long id){
		Foodtruck ft = ftDAO.leer(id);
		if (ft == null) {
			return new ResponseEntity<Foodtruck>(HttpStatus.NOT_FOUND);
		}
		ftDAO.eliminar(id);
		return new ResponseEntity<Foodtruck>(HttpStatus.NO_CONTENT);
	}
}
