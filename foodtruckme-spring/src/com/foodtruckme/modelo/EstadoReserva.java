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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ESTADOS_RESERVA")
public class EstadoReserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ESTADO")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	public enum Estado{
		PENDIENTE,
		ACEPTADA,
		RECHAZADA,
		CANCELADA,
		FINALIZADA
	}

	@JsonIgnore
	@OneToMany(mappedBy = "estadoReserva")
	private List<Reserva> reservas;
	
	public EstadoReserva() {
	}
	
	public Long getId() {
		return id;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}
