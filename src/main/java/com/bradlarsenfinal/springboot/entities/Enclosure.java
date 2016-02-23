package com.bradlarsenfinal.springboot.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Enclosure entity containing:
 * name, animal, # of animals, feeding time, condition
 * 
 * @author blarsen
 *
 */

@Entity(name="enclosure")

public class Enclosure {
	
	private Integer enclosureId;
	private String enclosureName;
	private String animal;
	private Integer numberOfAnimals;
	private Timestamp feedingTime;
	private String condition;
	
	/**
	 * @return the enclosureId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getEnclosureId() {
		return enclosureId;
	}
	/**
	 * @param enclosureId the enclosureId to set
	 */
	public void setEnclosureId(Integer enclosureId) {
		this.enclosureId = enclosureId;
	}
	/**
	 * @return the animal
	 */
	public String getAnimal() {
		return animal;
	}
	/**
	 * @param animal the animal to set
	 */
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	/**
	 * @return the numberOfAnimals
	 */
	public Integer getNumberOfAnimals() {
		return numberOfAnimals;
	}
	/**
	 * @param numberOfAnimals the numberOfAnimals to set
	 */
	public void setNumberOfAnimals(Integer numberOfAnimals) {
		this.numberOfAnimals = numberOfAnimals;
	}
	/**
	 * @return the feedingTime
	 */
	public Timestamp getFeedingTime() {
		return feedingTime;
	}
	/**
	 * @param feedingTime the feedingTime to set
	 */
	public void setFeedingTime(Timestamp feedingTime) {
		this.feedingTime = feedingTime;
	}
	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @return the enclosureName
	 */
	public String getEnclosureName() {
		return enclosureName;
	}
	/**
	 * @param enclosureName the enclosureName to set
	 */
	public void setEnclosureName(String enclosureName) {
		this.enclosureName = enclosureName;
	}

}
