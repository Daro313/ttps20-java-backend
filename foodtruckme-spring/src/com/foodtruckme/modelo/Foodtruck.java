package com.foodtruckme.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value={"servicios", "imagenes", "reservas"})
@Entity
@Table(name = "FOODTRUCKS")
public class Foodtruck implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "url")
	private String url;
	@Column(name = "whatsapp")
	private long whatsapp;
	@Column(name = "instagram")
	private String instagram;
	@Column(name = "twitter")
	private String twitter;
		
	//Por cuestiones de performance se hace una navegabilidad bidireccional
	@ManyToOne
	@JoinColumn(name = "foodtrucker_id")
	private Foodtrucker foodtrucker;
	
	@ManyToMany
	@JoinTable(name = "FOODTRUCK_SERVICIO",
			joinColumns = @JoinColumn(name = "foodtruck_id"),
			inverseJoinColumns = @JoinColumn(name = "servicio_id"))
	private List<TipoDeServicio> servicios;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "foodtruck_id")
	private List<ImagenFoodtruck> imagenes;
	
	@ManyToOne
	@JoinColumn(name = "ubicacion_id")
	private Ubicacion ubicacion;
	
	@OneToMany(mappedBy = "foodtruck")
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy = "foodtruck", fetch = FetchType.EAGER)
	private List<Puntaje> puntajes;
	
	public Long getId() {
		return id;
	}
	
	public Foodtrucker getFoodtrucker() {
		return foodtrucker;
	}
	public void setFoodtrucker(Foodtrucker foodtrucker) {
		this.foodtrucker = foodtrucker;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(long wahtsapp) {
		this.whatsapp = wahtsapp;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public List<ImagenFoodtruck> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<ImagenFoodtruck> imagenes) {
		this.imagenes = imagenes;
	}
	public List<TipoDeServicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<TipoDeServicio> servicios) {
		this.servicios = servicios;
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
	
	public List<Puntaje> getPuntajes() {
		return puntajes;
	}
	public void setPuntajes(List<Puntaje> puntajes) {
		this.puntajes = puntajes;
	}
	
}
