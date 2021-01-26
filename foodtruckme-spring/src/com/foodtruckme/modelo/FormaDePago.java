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
@Table(name = "FORMAS_DE_PAGO")
public class FormaDePago implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PAGO")
	@Enumerated(EnumType.STRING)
	private Pago pago;
	public enum Pago{
		ASISTENTES_PAGAN,
		ORGANIZADORES_PAGAN
	}

	@JsonIgnore
	@OneToMany(mappedBy = "formaDePago")
	private List<Evento> eventos;
	
	public FormaDePago() {
	}

	public Long getId() {
		return id;
	}
	
	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago nombre) {
		this.pago = nombre;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
}
