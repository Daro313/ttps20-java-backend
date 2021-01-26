package com.foodtruckme.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Foodtrucker")
public class Foodtrucker extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "foodtrucker",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Foodtruck> foodtrucks;

	public Set<Foodtruck> getFoodtrucks() {
		return foodtrucks;
	}

	public void setFoodtrucks(Set<Foodtruck> foodtrucks) {
		this.foodtrucks = foodtrucks;
	}
	
}
