package com.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.person.Dao.EmpDao;
import com.person.entities.Emp;


@Component
public class EmpService {
	
	@Autowired
	private EmpDao empdao;
	
	public List<Emp> getAllEmp(){
		List<Emp> list =(List<Emp>)this.empdao.findAll() ;
		return list;
	}
	public Emp getEmpById(int id) {
		Emp emp =null;
		//book = list.stream().filter(e->e.getId()==id).findFirst().get();
		emp =this.empdao.findById(id);	
		return emp;
	}
	// add Emp
	public Emp addBook(Emp e) {
		Emp result =this.empdao.save(e);
		return result;		
	}
	public void deleteEmp(int eid) {
		empdao.deleteById(eid);
	}

}
