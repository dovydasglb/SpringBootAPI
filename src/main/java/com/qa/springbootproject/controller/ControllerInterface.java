package com.qa.springbootproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {

	ResponseEntity<T> create(T body);

	ResponseEntity<List<T>> readAll();

	ResponseEntity<T> readById(long id);

	ResponseEntity<T> updateById(long id, T body);

	ResponseEntity<Object> deleteById(long id);

}