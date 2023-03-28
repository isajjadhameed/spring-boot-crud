package com.myspring.springbootcrud.service.impl;

import com.myspring.springbootcrud.exception.ResourceNotFoundException;
import com.myspring.springbootcrud.model.Employee;
import com.myspring.springbootcrud.repository.EmployeeRepository;
import com.myspring.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
//         Optional<Employee>employee = employeeRepository.findById(id);
//        if (employee.isPresent()) {
//            return employee.get();
//        }
//        else {
//            throw new ResourceNotFoundException("Employee","id",id);
//        }

        return employeeRepository.findById(id).orElseThrow(()->
        new ResourceNotFoundException("Employee","id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //Check required employee exist in the Db or not
        Employee CurEmployee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","id",id));
        CurEmployee.setFirstName(employee.getFirstName());
        CurEmployee.setLastName(employee.getLastName());
        CurEmployee.setEmail(employee.getEmail());

        employeeRepository.save(CurEmployee);
        return CurEmployee;
    }

    @Override
    public void deleteEmployee(long id){
        //Check required employee exist in the Db or not
        employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","id",id));
       employeeRepository.deleteById(id);
    }
}
