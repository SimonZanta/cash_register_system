package com.example.DBConnected.Employee;

import com.example.DBConnected.Authorization.Authorization;
import jakarta.persistence.*;

//example of model representing table and its columns
//table name only with underscore, camelCase will be converted to camel_case
@Entity
@Table(name = "employees")
public class Employee {

    //private fields, without notation means they are also column names in the table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    @OneToOne
    @JoinColumn(name="authorization_id")
    private Authorization authorization;

    protected Employee() {}

    public Employee(String first_name, String last_name, String email, Authorization authorization){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.authorization = authorization;
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public Authorization getAuthorization() {
        return authorization;
    }
}
