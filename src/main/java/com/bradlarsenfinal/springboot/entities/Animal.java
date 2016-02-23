package com.bradlarsenfinal.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity for the animal table including
 * animalId, name, scientificName, favFood, infoLink
 * @author blarsen
 *
 */

@Entity(name="animals")

public class Animal {
	
	private Integer animalId;
	private String name;
	private String scientificName;
	private String favFood;
	private String infoLink;
	/**
	 * @return the animalId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAnimalId() {
		return animalId;
	}
	/**
	 * @param animalId the animalId to set
	 */
	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the scientificName
	 */
	public String getScientificName() {
		return scientificName;
	}
	/**
	 * @param scientificName the scientificName to set
	 */
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	/**
	 * @return the infoLink
	 */
	public String getInfoLink() {
		return infoLink;
	}
	/**
	 * @param infoLink the infoLink to set
	 */
	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;
	}
	/**
	 * @return the favFood
	 */
	public String getFavFood() {
		return favFood;
	}
	/**
	 * @param favFood the favFood to set
	 */
	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}

}
