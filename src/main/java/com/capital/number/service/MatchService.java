package com.capital.number.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capital.number.entity.MatchDetails;
import com.capital.number.entity.UpdateStartDateRequestDto;
import com.capital.number.entity.UpdateTeamRequestDto;
import com.capital.number.entity.common.ResponseDto;
import com.capital.number.repository.MatchDao;
import com.capital.number.util.MatchUtil;

@Service
public class MatchService {

	@Autowired
	private MatchDao matchDao;	

	// JPA interface
	/*
	@Autowired
	private MatchRepository matchRepository;
	*/
	
	@Transactional
	public void save(List<MatchDetails> list) {
		//matchRepository.saveAll(list); //JPA
		list.stream().forEach(matchDetails -> {
			matchDao.save(matchDetails);
		});
	}

	@Transactional
	public ResponseDto deleteUpcomingMatch() throws Exception {
		ResponseDto responseDto = new ResponseDto();
		try {
			//matchRepository.deleteAllByMatchStartDateGreaterThanEqual(new Date()); // JPA
			matchDao.deleteUpcomingMatch();
			MatchUtil.success(responseDto, "Upcoming match deleted sucessfully.");
			return responseDto;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Transactional(readOnly = true)
	public ResponseDto getAllWinnerTeam() throws Exception {
		ResponseDto responseDto = new ResponseDto();
		try {
			List<Map<String, String>> data = new ArrayList<>();
			//List<MatchDetails> list = matchRepository.findAllByMatchStartDateLessThanEqual(new Date()); //JPA
			List<MatchDetails> list = matchDao.findAllByMatchStartDateLessThanEqual();
			list.stream().forEach(matchDetails -> {
				Map<String, String> map = new HashMap<>();
				map.put("id", matchDetails.getId().toString());
				map.put("Match Date", MatchUtil.convertDateToString(matchDetails.getMatchStartDate()));
				if(matchDetails.getAwayTeamScore() > matchDetails.getHomeTeamScore()) {
					map.put("Winning Team", matchDetails.getAwayTeam());
				}else if(matchDetails.getHomeTeamScore() > matchDetails.getAwayTeamScore()) {
					map.put("Winning Team", matchDetails.getHomeTeam());
				}else {
					map.put("Winning Team", "Match Tie - Score Level");
				}
				data.add(map);
			});
			MatchUtil.success(responseDto, "Winner data fetch sucessfully.", data);
			return responseDto;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Transactional(readOnly = true)
	public ResponseDto getAllTeamWithTeamId() throws Exception {
		ResponseDto responseDto = new ResponseDto();
		try {
			List<Map<String, String>> data = new ArrayList<>();
			//List<MatchDetails> list = matchRepository.findAll(); // JPA
			List<MatchDetails> list = matchDao.findAll();
			list.stream().forEach(matchDetails -> {
				Map<String, String> map = new HashMap<>();
				map.put("id", matchDetails.getId().toString());
				map.put("Home Team", matchDetails.getHomeTeam());
				map.put("Away Team", matchDetails.getAwayTeam());
				data.add(map);
			});
			MatchUtil.success(responseDto, "All Team data fetch sucessfully.", data);
			return responseDto;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Transactional(readOnly = true)
	public ResponseDto getAllUpcomingMatchWithTeamId() throws Exception {
		ResponseDto responseDto = new ResponseDto();
		try {
			List<Map<String, String>> data = new ArrayList<>();
			//List<MatchDetails> list = matchRepository.findAllByMatchStartDateGreaterThanEqualOrderByMatchStartDateAsc(new Date()); //JPA
			List<MatchDetails> list = matchDao.findAllByMatchStartDateGreaterThanEqualOrderByMatchStartDateAsc();
			list.stream().forEach(matchDetails -> {
				Map<String, String> map = new HashMap<>();
				map.put("id", matchDetails.getId().toString());
				map.put("Home Team", matchDetails.getHomeTeam());
				map.put("Away Team", matchDetails.getAwayTeam());
				map.put("Match Start Date", MatchUtil.convertDateToString(matchDetails.getMatchStartDate()));
				data.add(map);
			});
			MatchUtil.success(responseDto, "Upcoming match data fetch sucessfully.", data);
			return responseDto;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Transactional(readOnly = true)
	public ResponseDto getAllMatchWithTeamId() throws Exception {
		ResponseDto responseDto = new ResponseDto();
		try {
			List<Map<String, String>> data = new ArrayList<>();
			//List<MatchDetails> list = matchRepository.findAll(); // JPA
			List<MatchDetails> list = matchDao.findAll();
			list.stream().forEach(matchDetails -> {
				Map<String, String> map = new HashMap<>();
				map.put("id", matchDetails.getId().toString());
				map.put("Home Team", matchDetails.getHomeTeam());
				map.put("Away Team", matchDetails.getAwayTeam());
				map.put("Match Start Date", MatchUtil.convertDateToString(matchDetails.getMatchStartDate()));
				data.add(map);
			});
			MatchUtil.success(responseDto, "All Team data fetch sucessfully.", data);
			return responseDto;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Transactional
	public ResponseDto updateStartDate(Integer id, UpdateStartDateRequestDto request) throws Exception {
		ResponseDto responseDto = new ResponseDto();
		try {
			// Optional<MatchDetails> optional = matchRepository.findById(id); // JPA
			Optional<MatchDetails> optional = matchDao.findById(id);
			if(optional.isPresent()) {
				MatchDetails details = optional.get();
				details.setMatchStartDate(request.getStartDate());
				//matchRepository.save(details); // JPA
				matchDao.save(details);
			}else {
				throw new Exception("Data not found.");
			}
			MatchUtil.success(responseDto, "Match Start time update sucessfully.");
			return responseDto;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Transactional
	public ResponseDto updateTeamName(Integer id, UpdateTeamRequestDto request) throws Exception {
		ResponseDto responseDto = new ResponseDto();
		try {
			// Optional<MatchDetails> optional = matchRepository.findById(id); // JPA
			Optional<MatchDetails> optional = matchDao.findById(id);
			if(optional.isPresent()) {
				MatchDetails details = optional.get();
				details.setHomeTeam(request.getHomeTeam());
				details.setAwayTeam(request.getAwayTeam());
				//matchRepository.save(details); // JPA
				matchDao.save(details);
			}else {
				throw new Exception("Data not found.");
			}
			MatchUtil.success(responseDto, "Team name updated sucessfuly.");
			return responseDto;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}