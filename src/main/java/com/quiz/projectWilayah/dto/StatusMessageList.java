package com.quiz.projectWilayah.dto;

import lombok.Data;

@Data
public class StatusMessageList<T> {
	private Integer status;
	private String message;
//	private <T> void data();
}
