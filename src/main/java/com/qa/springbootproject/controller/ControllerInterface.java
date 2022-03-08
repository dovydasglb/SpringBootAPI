package com.qa.springbootproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<DTO, T> {

	ResponseEntity<DTO> createRequest(T body);

	ResponseEntity<List<DTO>> readAllRequest();

	ResponseEntity<DTO> readByIdRequest(Long id);

	ResponseEntity<DTO> updateByIdRequest(Long id, T body);

	ResponseEntity<Object> deleteByIdRequest(Long id);

}