package com.capital.number.entity.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	private Object data;
	private String statusMessage;

}