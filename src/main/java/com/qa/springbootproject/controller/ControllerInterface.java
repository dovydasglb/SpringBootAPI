package com.qa.springbootproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {

	ResponseEntity<T> createRequest(T body);

	ResponseEntity<List<T>> readAllRequest();

	ResponseEntity<T> readByIdRequest(Long id);

	ResponseEntity<T> updateByIdRequest(Long id, T body);

	ResponseEntity<Object> deleteByIdRequest(Long id);

}