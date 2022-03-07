package com.qa.springbootproject.service;

import java.util.List;

public interface ServiceInterface<T> {

	T create(T body);

	List<T> readAll();

	T readById(Long id);

	T updateById(Long id, T body);

	boolean deleteById(Long id);

}