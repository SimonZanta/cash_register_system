package com.example.DBConnected.Employee;

import jakarta.persistence.Entity;

public class EmployeeDTO {
    private String username;
    private String password;

    public EmployeeDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}