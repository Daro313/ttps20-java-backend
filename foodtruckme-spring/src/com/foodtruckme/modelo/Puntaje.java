package com.foodtruckme.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"foodtruck", "reserva"})
@Entity
@Table(name = "PUNTAJES")
public class Puntaje implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PTS_CALIDAD_PRECIO")
	private int puntosCalidadPrecio;
	@Column(name = "PTS_LIMPIEZA")
	private int puntosLimpieza;
	@Column(name = "PTS_DISENIO")
	private int puntosDisenio;
	@Column(name = "PTS_SIMPATIA")
	private int puntosSimpatia;
	@Column(name = "PTS_SABOR")
	private int puntosSabor;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "FOODTRUCK_ID")
	private Foodtruck foodtruck;
	
	@OneToOne(mappedBy = "puntaje")
	private Reserva reserva;
	
	public Puntaje() {
	}

	public Long getId() {
		return id;
	}
	
	public int getPuntosCalidadPrecio() {
		return puntosCalidadPrecio;
	}

	public void setPuntosCalidadPrecio(int puntosCalidadPrecio) {
		this.puntosCalidadPrecio = puntosCalidadPrecio;
	}

	public int getPuntosLimpieza() {
		return puntosLimpieza;
	}

	public void setPuntosLimpieza(int puntosLimpieza) {
		this.puntosLimpieza = puntosLimpieza;
	}

	public int getPuntosDisenio() {
		return puntosDisenio;
	}

	public void setPuntosDisenio(int puntosDisenio) {
		this.puntosDisenio = puntosDisenio;
	}

	public int getPuntosSimpatia() {
		return puntosSimpatia;
	}

	public void setPuntosSimpatia(int puntosSimpatia) {
		this.puntosSimpatia = puntosSimpatia;
	}

	public int getPuntosSabor() {
		return puntosSabor;
	}

	public void setPuntosSabor(int puntosSabor) {
		this.puntosSabor = puntosSabor;
	}

	public Foodtruck getFoodtruck() {
		return foodtruck;
	}

	public void setFoodtruck(Foodtruck foodtruck) {
		this.foodtruck = foodtruck;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
}
