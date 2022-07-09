package com.capital.number.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateTeamRequestDto {

	@NotNull(message = "Home Team cannot be null.")
	@NotEmpty(message = "Home Team cannot be Empty.")
	private String homeTeam;

	@NotNull(message = "Away Team cannot be null.")
	@NotEmpty(message = "Away Team cannot be Empty.")
	private String awayTeam;

}