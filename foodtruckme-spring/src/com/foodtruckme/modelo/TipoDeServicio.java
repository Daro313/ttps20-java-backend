package com.foodtruckme.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOS_DE_SERVICIO")
public class TipoDeServicio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "SERVICIO")
	@Enumerated(EnumType.STRING)
	private Servicio servicio;
	public enum Servicio{
		HELADOS,
		HAMBURGUESAS,
		GASEOSAS,
		CERVEZAS,
		PAPAS_FRITAS,
		CREPES,
		SUSHI,
		PARRILLA,
		PIZZAS,
		EMPANADAS
	}
	
	@ManyToMany(mappedBy = "servicios")
	private List<Foodtruck> foodtrucks;
	
	
	public TipoDeServicio() {
	}

	public Long getId() {
		return id;
	}
	
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Foodtruck> getFoodtrucks() {
		return foodtrucks;
	}

	public void setFoodtrucks(List<Foodtruck> foodtrucks) {
		this.foodtrucks = foodtrucks;
	}
	
}
