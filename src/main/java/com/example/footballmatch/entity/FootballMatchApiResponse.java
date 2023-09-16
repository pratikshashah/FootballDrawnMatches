package com.example.footballmatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FootballMatchApiResponse {
	@JsonProperty("data")
	private List<FootballMatch> data;

	public List<FootballMatch> getData() {
		return data;
	}

	public void setData(List<FootballMatch> data) {
		this.data = data;
	}
}
