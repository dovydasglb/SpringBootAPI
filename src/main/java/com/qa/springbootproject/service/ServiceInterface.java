package com.qa.springbootproject.service;

import java.util.List;

public interface ServiceInterface<DTO, T> {

	DTO create(T body);

	List<DTO> readAll();

	DTO readById(Long id);

	DTO updateById(Long id, T body);

	boolean deleteById(Long id);

}