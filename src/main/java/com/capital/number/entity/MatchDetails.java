package com.capital.number.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "match_details")
public @Data class MatchDetails {

	@Id
	@GeneratedValue
	private Integer id;
	private Date matchStartDate; 
	private String homeTeam;
	private String awayTeam;
	private Integer homeTeamScore;
	private Integer awayTeamScore;

	@Transient
	private String startDate;
	
	public MatchDetails() {
		
	}
	
	public MatchDetails(int id, Date matchStartDate, String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore) {
		this.id = id;
		this.matchStartDate = matchStartDate;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
	}

}