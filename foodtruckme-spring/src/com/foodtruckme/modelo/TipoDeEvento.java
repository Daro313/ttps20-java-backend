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
@Table(name = "TIPOS_DE_EVENTO")
public class TipoDeEvento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	public enum TipoEvento{
		CELEBRACION_PRIVADA,
		FESTIVAL,
		MARKET_CALLEJERO
	}
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoDeEvento")
	private List<Evento> eventos;
	
	public TipoDeEvento() {
	}

	public Long getId() {
		return id;
	}
	
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}
