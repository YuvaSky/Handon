package com.person.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.person.Dao.EmpDao;
import com.person.Dao.Emp_tempDao;
import com.person.entities.Emp;
import com.person.entities.Emp_temp;
import com.person.helper.Helper;

@Service
public class EmpService {

    @Autowired
    private EmpDao empDao;

    @Autowired
    private Emp_tempDao empTempDao;

 
    public void save(MultipartFile file) {
        try {
            List<Emp> employees = Helper.excelToEmps(file.getInputStream());
            for (Emp employee : employees) {
                if (empDao.existsByNameAndRole(employee.getName(), employee.getRole())) {
                    // If duplicate data found, save to temporary table
            
                    saveToTemporaryTable(employee,"failure","this data is duplicate");
                } else {
                    // If no duplicate is found, save the employee object to the main table
                    empDao.save(employee);
                    saveToTemporaryTable(employee, "success","this data is not duplicate");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public void printEmpTempData() {
        List<Emp_temp> empTempList = empTempDao.findAll();
        System.out.println("Emp_temp Data:");
        for (Emp_temp empTemp : empTempList) {
            System.out.println("Name: " + empTemp.getName() + ", Role: " + empTemp.getRole() + ", Status: " + empTemp.isStatus() + ", Message: " + empTemp.getMeassage());
        }
    }*/



	private void saveToTemporaryTable(Emp employee, String status,String meassage) {
        Emp_temp empTemp = new Emp_temp();
        empTemp.setName(employee.getName());
        empTemp.setRole(employee.getRole());
        empTemp.setStatus(status);
        if (status.equals("failure")) {
            empTemp.setMeassage("this data is duplicate");
        } else {
            empTemp.setMeassage("data saved successfully");
        }
        empTemp.setMeassage(meassage);
        empTempDao.save(empTemp);
    }

    public List<Emp> getAllEmployees() {
         List<Emp> all = empDao.findAll();         
		return all;        
    }
    public List<Emp_temp> getAllEmptemp() {
        List<Emp_temp> all = empTempDao.findAll();         
		return all;        
   }
}
