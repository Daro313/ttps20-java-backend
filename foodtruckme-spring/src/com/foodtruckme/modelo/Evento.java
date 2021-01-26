package com.foodtruckme.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EVENTOS")
public class Evento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "fecha")
	private LocalDate fecha;
	@Column(name = "Hora")
	private LocalTime hora;
	@Column(name = "email")
	private String email;
	@Column(name = "telefono")
	private long telefono;
	@Column(name = "descripcion")
	private String descripcion;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private FormaDePago formaDePago;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private TipoDeEvento tipoDeEvento;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "organizador_id")
	private Organizador organizador;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Reserva> reservas;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ubicacion_id")
	private Ubicacion ubicacion;
	
	
	public Long getId() {
		return id;
	}
	
	public Organizador getOrganizador() {
		return organizador;
	}
	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoDeEvento getTipoDeEvento() {
		return tipoDeEvento;
	}
	public void setTipoDeEvento(TipoDeEvento tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public FormaDePago getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
