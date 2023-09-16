package com.example.footballmatch.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.footballmatch.entity.FootballMatch;
import com.example.footballmatch.entity.FootballMatchApiResponse;

@Service
public class FootballMatchService {
	private final RestTemplate restTemplate;

	@Autowired
	public FootballMatchService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public int getDrawMatchCountForYear(int year) {

		int randomDelay = ThreadLocalRandom.current().nextInt(3000, 6001);
		try {
			Thread.sleep(randomDelay);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		// Perform REST API call to fetch football match data
		String apiUrl = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=1";
		ResponseEntity<FootballMatchApiResponse> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, null,
				FootballMatchApiResponse.class);

		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			FootballMatchApiResponse apiResponse = responseEntity.getBody();
			if (apiResponse != null) {
				List<FootballMatch> matches = apiResponse.getData();

				// Filter and count draw matches (where team1goals == team2goals)
				long drawMatchCount = matches.stream().filter(match -> match.getTeam1goals() == match.getTeam2goals())
						.count();

				return (int) drawMatchCount;
			}
		}
		return 0; // Return 0 if there's an issue with the API call or response
	}
}