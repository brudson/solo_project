package com.bradlarsenfinal.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bradlarsenfinal.springboot.dao.EnclosureDao;
import com.bradlarsenfinal.springboot.entities.Enclosure;




/**
 * Service layer to pass data from EnclosureWebService to EnclosureDao
 * @author blarsen
 *
 */
@Service
public class EnclosureService {
	
	@Autowired(required = true)
	private EnclosureDao enclosureDao;
	
	/**
	 * @param enclosureDao the enclosureDao to set
	 */
	public void setEnclosureDao(EnclosureDao enclosureDao) {
		
		this.enclosureDao = enclosureDao;
		
	}
	
	/**
	 * Passes the enclosure object to the Dao
	 * @param enclosure
	 */
	public void newEnclosure(Enclosure enclosure){
		
		enclosureDao.newEnclosure(enclosure);
		
	}

	/**
	 * Returns the list of enclosures to the webservice
	 * @return
	 */
	public List<Enclosure> getAllEnclosures() {
		
		return enclosureDao.getAllEnclosures();
		
	}

	/**
	 * Passes on the new enclosure object to be merged into the database
	 * @param editedEnclosure
	 */
	public void editEnclosure(Enclosure editedEnclosure) {
		
		enclosureDao.editEnclosure(editedEnclosure);
		
	}

	/**
	 * Passes the enclosure Id to the Dao for deletion
	 * @param enclosureId
	 */
	public void deleteEnclosure(Integer enclosureId) {
		
		enclosureDao.deleteEnclosure(enclosureId);
		
	}

}
