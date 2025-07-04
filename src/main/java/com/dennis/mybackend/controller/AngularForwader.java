package com.dennis.mybackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller // forward all to angular index.html
@Slf4j
public class AngularForwader {
	@RequestMapping(value = "/{path:[^\\.]*}/**", produces = "text/html")
	public String forwardSpaRoutes(HttpServletRequest request) {

//  	FORWARD BROWESR REFRESH to angular index.html		
//		String requestURI = request.getRequestURI();
//		String requestURL = request.getRequestURL().toString(); // Includes protocol, host, port
//		String queryString = request.getQueryString();
//
//		log.info("Forwarding SPA route to index.html.");
//		log.info("Original Request URI: {}", requestURI);
//		log.info("Original Request URL: {}", requestURL);
//		if (queryString != null) {
//			log.info("Query String: {}", queryString);
//		}
//
		return "forward:/index.html";
	}
}
