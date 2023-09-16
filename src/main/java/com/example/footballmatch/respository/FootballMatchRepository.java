package com.example.footballmatch.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.footballmatch.entity.FootballMatch;

public interface FootballMatchRepository extends JpaRepository<FootballMatch, Long> {

	List<FootballMatch> findByMatchDateBetween(String startDate, String endDate);

	List<FootballMatch> findByYear(int year);
}