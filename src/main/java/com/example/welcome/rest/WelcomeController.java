package com.example.welcome.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.welcome.service.OrderingService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class WelcomeController {

	@Autowired
	private OrderingService orderingService;
	
	@PostMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> welcome(@RequestBody List<Integer> list) {
		log.debug("Request: {}", () -> list);
		List<Integer> orderedList = orderingService.sort(list);
		log.debug("Response: {}", () -> orderedList);
		return ResponseEntity.ok(orderedList);
    }
	
}
