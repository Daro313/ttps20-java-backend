package com.foodtruckme.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UBICACIONES")
public class Ubicacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "provincia")
	private String provincia;
	@Column(name = "ciudad")
	private String ciudad;
	@Column(name = "latitud")
	private double latitud;
	@Column(name = "longitud")
	private double longitud;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ubicacion")
	private List<Foodtruck> foodtrucks;
	
	public Long getId() {
		return id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	public List<Foodtruck> getFoodtrucks() {
		return foodtrucks;
	}
	public void setFoodtrucks(List<Foodtruck> foodtrucks) {
		this.foodtrucks = foodtrucks;
	}
	
}
