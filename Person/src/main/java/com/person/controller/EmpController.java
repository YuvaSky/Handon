package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.person.entities.Emp;
import com.person.service.EmpService;



@RestController
public class EmpController {
	@Autowired
	private EmpService empservice;
	
	@GetMapping("/emps")
	public List<Emp> getEmp(){
		return this.empservice.getAllEmp();
	}
	
	@PostMapping("/emps")
	public Emp addEmp(@RequestBody Emp ep) {
		Emp e = this.empservice.addBook(ep);
		return e;
	}
    @DeleteMapping("/emps/{eid}")
    public void deleteEmp(@PathVariable("eid") int eid) {
		this. empservice.deleteEmp(eid);
    }
    
}
