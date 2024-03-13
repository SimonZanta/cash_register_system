package com.example.DBConnected;

import org.springframework.data.repository.CrudRepository;

//this is simple middle man between model and controller
//if used CrudRepo we don't need to define any CRUD operation
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
}
