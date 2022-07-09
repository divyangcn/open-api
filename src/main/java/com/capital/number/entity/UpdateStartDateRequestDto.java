package com.capital.number.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
public class UpdateStartDateRequestDto {

	@JsonSerialize(as = Date.class)
	@NotNull(message = "Start Date cannot be null.")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date startDate;
	
}