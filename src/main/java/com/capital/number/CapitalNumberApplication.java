package com.capital.number;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capital.number.entity.MatchDetails;
import com.capital.number.service.MatchService;
import com.capital.number.util.MatchUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CapitalNumberApplication {

	@Autowired
	private MatchService matchService;

	public static void main(String[] args) {
		SpringApplication.run(CapitalNumberApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<MatchDetails>> typeReference = new TypeReference<>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");
			try {
				List<MatchDetails> list = mapper.readValue(inputStream, typeReference);
				list.stream().forEach(matchDetails -> {
					matchDetails.setMatchStartDate(MatchUtil.convertStringToDate(matchDetails.getStartDate()));
				});
				matchService.save(list);
			} catch (Exception e){
				e.printStackTrace();
			}
		};
	}

}