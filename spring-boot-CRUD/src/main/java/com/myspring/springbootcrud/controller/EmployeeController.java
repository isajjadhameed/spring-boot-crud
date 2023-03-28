package com.myspring.springbootcrud.controller;

import com.myspring.springbootcrud.model.Employee;
import com.myspring.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

   @PostMapping("/api/employee")
   public Employee saveEmployee(@RequestBody Employee employee){
       return employeeService.saveEmployee(employee);
   }
   @GetMapping("/api/employee")
   public List<Employee>getAllEmployee(){
       return employeeService.getAllEmployee();
   }
   @GetMapping("/api/employee/{id}")
   public Employee getEmployeeById(@PathVariable("id") Long id){
       return employeeService.getEmployeeById(id);
   }

   @PutMapping("/api/employee/{id}")
   public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") long id){
       return employeeService.updateEmployee(employee,id);
}
   @DeleteMapping("/api/employee/{id}")
   public void deleteEmployee(@PathVariable("id") long id){
       employeeService.deleteEmployee(id);
   }
}
