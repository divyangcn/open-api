package com.capital.number.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capital.number.entity.MatchDetails;

@Repository
public interface MatchRepository extends JpaRepository<MatchDetails, Integer> {

	List<MatchDetails> findByMatchStartDateGreaterThanEqual(Date date);

	void deleteAllByMatchStartDateGreaterThanEqual(Date date);

	List<MatchDetails> findAllByMatchStartDateLessThanEqual(Date date);

	List<MatchDetails> findAllByMatchStartDateGreaterThanEqualOrderByMatchStartDateAsc(Date date);

}