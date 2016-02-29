package com.bradlarsenfinal.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This simply directs the user to the homepage
 * @author Bradley
 *
 */
@Controller
public class HomeController {

	/**
	 * Directs the user to /views/index.html 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/views/index.html";
	}
	
}
