package com.qa.springbootproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {

	ResponseEntity<T> createRequest(T body);

	ResponseEntity<List<T>> readAllRequest();

	ResponseEntity<T> readByIdRequest(long id);

	ResponseEntity<T> updateByIdRequest(long id, T body);

	ResponseEntity<Object> deleteByIdRequest(long id);

}