package com.bradlarsenfinal.springboot.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bradlarsenfinal.springboot.entities.Enclosure;
import com.bradlarsenfinal.springboot.service.EnclosureService;


/**
 * Communicates with the front end to pass data to the service layer
 * app/views/partials/enclosure.html
 * @author blarsen
 *
 */
@RestController
public class EnclosureWebService {
	
	@Autowired(required=true)
	EnclosureService enclosureService;
	
	/**
	 * @param enclosureService the enclosureService to set
	 */
	public void setEnclosureService(EnclosureService enclosureService) {
		
		this.enclosureService = enclosureService;
		
	}
	
	/**
	 * Calls the newEnclosure service and passes the users new enclosure in
	 * @param enclosure object created from user data
	 */
	@RequestMapping(value="/enclosure", method = RequestMethod.POST)
	public void addNewEnclosure(@RequestBody Enclosure enclosure){
		
		enclosureService.newEnclosure(enclosure);
		
	}

	
}
