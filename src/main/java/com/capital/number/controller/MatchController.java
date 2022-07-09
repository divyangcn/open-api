package com.capital.number.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capital.number.entity.UpdateStartDateRequestDto;
import com.capital.number.entity.UpdateTeamRequestDto;
import com.capital.number.entity.common.ResponseDto;
import com.capital.number.service.MatchService;
import com.capital.number.util.MatchUtil;

@RestController
@RequestMapping("/api/match")
public class MatchController {

	@Autowired
	private MatchService matchService;
		
	@DeleteMapping("/deleteUpcomingMatch")
	public ResponseEntity<ResponseDto> deleteUpcomingMatch() {
		ResponseDto responseDto = new ResponseDto();
		ResponseEntity<ResponseDto> responseEntity = null;
		try {
			responseDto = matchService.deleteUpcomingMatch();
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
		}catch (Exception e) {
			MatchUtil.failure(responseDto, e.getMessage());
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@GetMapping("/getAllWinnerTeam")
	public ResponseEntity<ResponseDto> getAllWinnerTeam() {
		ResponseDto responseDto = new ResponseDto();
		ResponseEntity<ResponseDto> responseEntity = null;
		try {
			responseDto = matchService.getAllWinnerTeam();
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
		}catch (Exception e) {
			MatchUtil.failure(responseDto, e.getMessage());
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@GetMapping("/getAllTeamWithTeamId")
	public ResponseEntity<ResponseDto> getAllTeamWithTeamId() {
		ResponseDto responseDto = new ResponseDto();
		ResponseEntity<ResponseDto> responseEntity = null;
		try {
			responseDto = matchService.getAllTeamWithTeamId();
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
		}catch (Exception e) {
			MatchUtil.failure(responseDto, e.getMessage());
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@GetMapping("/getAllUpcomingMatchWithTeamId")
	public ResponseEntity<ResponseDto> getAllUpcomingMatchWithTeamId() {
		ResponseDto responseDto = new ResponseDto();
		ResponseEntity<ResponseDto> responseEntity = null;
		try {
			responseDto = matchService.getAllUpcomingMatchWithTeamId();
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
		}catch (Exception e) {
			MatchUtil.failure(responseDto, e.getMessage());
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@GetMapping("/getAllMatchWithTeamId")
	public ResponseEntity<ResponseDto> getAllMatchWithTeamId() {
		ResponseDto responseDto = new ResponseDto();
		ResponseEntity<ResponseDto> responseEntity = null;
		try {
			responseDto = matchService.getAllMatchWithTeamId();
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
		}catch (Exception e) {
			MatchUtil.failure(responseDto, e.getMessage());
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PutMapping("/updateStartDate/{id}")
	public ResponseEntity<ResponseDto> updateStartDate(@PathVariable("id") @NotNull Integer id, @RequestBody @Valid UpdateStartDateRequestDto request) {
		ResponseDto responseDto = new ResponseDto();
		ResponseEntity<ResponseDto> responseEntity = null;
		try {
			responseDto = matchService.updateStartDate(id, request);
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
		}catch (Exception e) {
			MatchUtil.failure(responseDto, e.getMessage());
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PutMapping("/updateTeamName/{id}")
	public ResponseEntity<ResponseDto> updateTeamName(@PathVariable("id") @NotNull Integer id, @RequestBody @Valid UpdateTeamRequestDto request) {
		ResponseDto responseDto = new ResponseDto();
		ResponseEntity<ResponseDto> responseEntity = null;
		try {
			responseDto = matchService.updateTeamName(id, request);
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
		}catch (Exception e) {
			MatchUtil.failure(responseDto, e.getMessage());
			responseEntity = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
}
