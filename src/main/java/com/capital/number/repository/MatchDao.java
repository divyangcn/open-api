package com.capital.number.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capital.number.entity.MatchDetails;

@Repository
public class MatchDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void save(MatchDetails matchDetails) {
		jdbcTemplate.update("insert into match_details (match_start_date, home_team, away_team, home_team_score, away_team_score) values(?, ?, ?, ?, ?)",
				matchDetails.getMatchStartDate(), 
				matchDetails.getHomeTeam(),
				matchDetails.getAwayTeam(),
				matchDetails.getHomeTeamScore(),
				matchDetails.getAwayTeamScore());
	}

	public void deleteUpcomingMatch() {
		jdbcTemplate.update("delete from match_details where match_start_date > ?", new Date()); 
	}

	@SuppressWarnings("deprecation")
	public List<MatchDetails> findAllByMatchStartDateLessThanEqual() {
		List<MatchDetails> list = jdbcTemplate.query(
				"SELECT * FROM match_details WHERE match_start_date < ? order by id",
				new Object[] {new Date()},
				new RowMapper<MatchDetails>() {
					public MatchDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
						MatchDetails details = new MatchDetails();
						details.setId(rs.getInt(1));
						details.setMatchStartDate(rs.getDate(2));
						details.setHomeTeam(rs.getString(3));
						details.setAwayTeam(rs.getString(4));
						details.setHomeTeamScore(rs.getInt(5));
						details.setAwayTeamScore(rs.getInt(6));
						return details;
					}
				});
		return list;
	}

	public List<MatchDetails> findAll() {
		List<MatchDetails> list = jdbcTemplate.query(
				"SELECT * FROM match_details order by id",
				new RowMapper<MatchDetails>() {
					public MatchDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
						MatchDetails details = new MatchDetails();
						details.setId(rs.getInt(1));
						details.setMatchStartDate(rs.getDate(2));
						details.setHomeTeam(rs.getString(3));
						details.setAwayTeam(rs.getString(4));
						details.setHomeTeamScore(rs.getInt(5));
						details.setAwayTeamScore(rs.getInt(6));
						return details;
					}
				});
		return list;
	}

	@SuppressWarnings("deprecation")
	public List<MatchDetails> findAllByMatchStartDateGreaterThanEqualOrderByMatchStartDateAsc() {
		List<MatchDetails> list = jdbcTemplate.query(
				"SELECT * FROM match_details WHERE match_start_date >= ? order by id",
				new Object[] {new Date()},
				new RowMapper<MatchDetails>() {
					public MatchDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
						MatchDetails details = new MatchDetails();
						details.setId(rs.getInt(1));
						details.setMatchStartDate(rs.getDate(2));
						details.setHomeTeam(rs.getString(3));
						details.setAwayTeam(rs.getString(4));
						details.setHomeTeamScore(rs.getInt(5));
						details.setAwayTeamScore(rs.getInt(6));
						return details;
					}
				});
		return list;
	}

	public Optional<MatchDetails> findById(Integer id) {
		return namedParameterJdbcTemplate.queryForObject(
				"select * from match_details where id = :id",
				new MapSqlParameterSource("id", id),
				(rs, rowNum) ->
				Optional.of(new MatchDetails(
						rs.getInt(1),
						new java.util.Date(rs.getDate(2).getTime()),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6)
						))
				);
	}
}