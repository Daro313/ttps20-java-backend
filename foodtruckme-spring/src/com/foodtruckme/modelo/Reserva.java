package com.foodtruckme.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value={"evento","foodtruck","puntaje"})
@Entity
@Table(name = "RESERVAS")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private EstadoReserva estadoReserva;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "evento_id")
	private Evento evento;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "foodtruck_id")
	private Foodtruck foodtruck;
	
	@OneToOne
	@JoinColumn(name = "PUNTAJE_ID")
	private Puntaje puntaje;
	
	public Long getId() {
		return id;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public EstadoReserva getEstadoReserva() {
		return estadoReserva;
	}
	public void setEstadoReserva(EstadoReserva estadoReserva) {
		this.estadoReserva = estadoReserva;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Foodtruck getFoodtruck() {
		return foodtruck;
	}
	public void setFoodtruck(Foodtruck foodtruck) {
		this.foodtruck = foodtruck;
	}
	
	public Puntaje getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Puntaje puntaje) {
		this.puntaje = puntaje;
	}
	
}
