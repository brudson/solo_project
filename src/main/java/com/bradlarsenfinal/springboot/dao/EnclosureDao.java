package com.bradlarsenfinal.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bradlarsenfinal.springboot.entities.Enclosure;
import com.bradlarsenfinal.springboot.service.EnclosureService;

/**
 * Communicates with the database concerning enclosures
 * @author blarsen
 *
 */
@Transactional
@Component
public class EnclosureDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Add a new enclosure to the database
	 * @param enclosure
	 * @return
	 */

	public Enclosure newEnclosure(Enclosure enclosure) {
		
		em.persist(enclosure);
		em.flush();
		
		return enclosure;
		
	}
	
	/**
	 * Gets a list of all the enclosures and returns it to the front end
	 * @return
	 */
	public List<Enclosure> getAllEnclosures() {
		
		List<Enclosure> allEnclosures = em.createQuery("SELECT d FROM enclosure d", Enclosure.class).getResultList();
		
		return allEnclosures;
		
	}
	
	/**
	 * Merges the new enclosure with the existing one
	 * @param editedEnclosure
	 */
	public void editEnclosure(Enclosure editedEnclosure) {
		
		em.merge(editedEnclosure);
		em.flush();
		
	}

	/**
	 * Finds an enclosure based on an id and deletes it from the database
	 * @param enclosureId
	 */
	public void deleteEnclosure(Integer enclosureId) {
		
		Enclosure enclosure = em.find(Enclosure.class, enclosureId);
		em.remove(enclosure);
		em.flush();
		
	}
	
}
