package com.example.DBConnected.Employee;

import com.example.DBConnected.Employee.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//this is simple middle man between model and controller
//if used CrudRepo we don't need to define any CRUD operation
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    @Query("SELECT em FROM Employee em WHERE em.username = :username")
    Employee findByUsername(@Param("username") String username);
}
