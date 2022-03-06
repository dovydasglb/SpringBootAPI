package com.qa.springbootproject.service;

import java.util.List;

public interface ServiceInterface<T> {

	T create(T body);

	List<T> readAll();

	T readById(long id);

	T updateById(long id, T body);

	boolean deleteById(long id);

}