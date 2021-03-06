package com.bradlarsenfinal.springboot.webservices;

import java.util.List;

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
	@RequestMapping(value="/addEnclosure", method = RequestMethod.POST)
	public void addNewEnclosure(@RequestBody Enclosure enclosure){
		
		enclosureService.newEnclosure(enclosure);
		
	}
	
	/**
	 * Calls the getAllEnclosure service and then returns that data
	 * to the front end
	 * @return
	 */
	@RequestMapping(value="/viewEnclosure", method = RequestMethod.GET)
	public List<Enclosure> getEnclosures(){
		
		return enclosureService.getAllEnclosures();
		
	}
	
	/**
	 * Passes on the editedEnclosure object from the front end to the 
	 * enclosureService
	 * @param editedEnclosure
	 */
	@RequestMapping(value="/editEnclosure", method = RequestMethod.PUT)
	public void updateEnclosure(@RequestBody Enclosure editedEnclosure){
		
		enclosureService.editEnclosure(editedEnclosure);
		
	}
	
	/**
	 * Passes the id of the deleted enclosure to the enclosureService
	 * @param enclosureId
	 */
	@RequestMapping(value="/deleteEnclosure/{enclosureId}", method = RequestMethod.DELETE)
	public void deleteEnclosure(@PathVariable Integer enclosureId){
	
		enclosureService.deleteEnclosure(enclosureId);
		
	}

	
}