package com.capital.number.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.capital.number.entity.common.ResponseDto;

@Component
public class MatchUtil {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMMM yyyy hha");

	public static Date convertStringToDate(String stringDate) {
		try {
			return simpleDateFormat.parse(stringDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String convertDateToString(Date date) {
		try {
			return simpleDateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void success(ResponseDto responseDto, String successMsg) {
		setResponseDtoStatus(responseDto, "SUCCESS", successMsg, null);
	}

	public static void success(ResponseDto responseDto, String successMsg, Object data) {
		setResponseDtoStatus(responseDto, "SUCCESS", successMsg, data);
	}

	public static void failure(ResponseDto responseDto, String failureMessage) {
		setResponseDtoStatus(responseDto, "FAIL", failureMessage, null);
	}

	private static void setResponseDtoStatus(ResponseDto responseDto, String status, String statusMsg, Object data) {
		responseDto.setStatus(status);
		responseDto.setData(data);
		responseDto.setStatusMessage(statusMsg);
	}
	

}