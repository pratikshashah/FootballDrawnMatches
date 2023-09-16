package com.example.footballmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.footballmatch.entity.FootballMatch;
import com.example.footballmatch.respository.FootballMatchRepository;

@RestController
@RequestMapping("/api/task1")
public class Task1Controller {

	@Autowired
	private FootballMatchRepository footballMatchRepository; // Inject your repository here

	@GetMapping("/matches")
	public ResponseEntity<List<FootballMatch>> getMatchesForYear(@RequestParam("year") int year) {
		List<FootballMatch> matches = footballMatchRepository.findByYear(year);
		return new ResponseEntity<>(matches, HttpStatus.OK);
	}

}
