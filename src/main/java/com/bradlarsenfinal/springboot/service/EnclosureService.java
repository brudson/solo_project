package com.bradlarsenfinal.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bradlarsenfinal.springboot.entities.Enclosure;

import EnclosureDao.EnclosureDao;


/**
 * Service layer to pass data from EnclosureWebService to EnclosureDao
 * @author blarsen
 *
 */
@Service
public class EnclosureService {
	
	@Autowired(required=true)
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

}