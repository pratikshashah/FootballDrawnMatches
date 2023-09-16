package com.example.footballmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.footballmatch.service.FootballMatchService;

@RestController
@RequestMapping("/api/football-matches")
public class FootballMatchController {
	@Autowired
	private FootballMatchService footballMatchService;

	@GetMapping("/draw-matches")
	@PreAuthorize("hasRole('TASK2_ROLE')")
	public ResponseEntity<Integer> getDrawMatchCountForYear(@RequestParam("year") int year) {
		int drawMatchCount = footballMatchService.getDrawMatchCountForYear(year);
		return new ResponseEntity<>(drawMatchCount, HttpStatus.OK);
	}

}