package com.example.DBConnected.Employee;

import com.example.DBConnected.Employee.Employee;
import org.springframework.data.repository.CrudRepository;

//this is simple middle man between model and controller
//if used CrudRepo we don't need to define any CRUD operation
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
}
