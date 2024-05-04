package com.person.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.person.entities.Emp;
import com.person.entities.Emp_temp;
import com.person.helper.Helper;
import com.person.service.EmpService;


@CrossOrigin("*")
@RestController
public class ExcelController {
	
	@Autowired
	EmpService empService;
	
	 @PostMapping("/upload")
	  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {	   

	    if (Helper.checkExcelFormat(file)) {
	      this.empService.save(file);
	      return ResponseEntity.ok(Map.of("message", getAllEmptemp()));
	        
	    }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload only");
	     }
	 @GetMapping("/")
	 public List<Emp> getAllEmp(){
		 return this.empService.getAllEmployees();
	 }
	 @GetMapping("/emptemp")
	 public List<Emp_temp> getAllEmptemp(){
		 return this.empService.getAllEmptemp();
	 }
}
	
