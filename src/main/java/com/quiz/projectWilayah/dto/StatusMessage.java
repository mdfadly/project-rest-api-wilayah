package com.quiz.projectWilayah.dto;

import java.util.List;

import lombok.Data;

@Data
public class StatusMessage<T> {
	private Integer status;
	private String message;
	private T data;
}
