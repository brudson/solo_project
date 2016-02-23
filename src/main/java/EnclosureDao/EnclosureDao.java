package EnclosureDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bradlarsenfinal.springboot.entities.Enclosure;

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
	
}
