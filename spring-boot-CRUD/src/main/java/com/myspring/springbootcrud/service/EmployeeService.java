package com.myspring.springbootcrud.service;

import com.myspring.springbootcrud.model.Employee;

import java.util.List;

public interface EmployeeService {
  Employee saveEmployee(Employee employee);
  List<Employee> getAllEmployee();
  Employee getEmployeeById(Long id);
  Employee updateEmployee(Employee employee,long id);
  void deleteEmployee(long id);
}
