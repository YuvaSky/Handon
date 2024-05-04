package com.person.Dao;

import org.springframework.data.repository.CrudRepository;

import com.person.entities.Emp;

public interface EmpDao extends CrudRepository<Emp, Integer> {
	
	public Emp findById(int id);

}
