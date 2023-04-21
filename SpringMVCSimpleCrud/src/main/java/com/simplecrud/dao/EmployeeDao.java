package com.simplecrud.dao;

import com.simplecrud.beans.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface EmployeeDao {

    int save(Employee employee);
    
    int update(Employee employee);
    
    int delete(int id);
    
    Employee getEmployeeById(int id);

    List<Employee> getEmployees();

}
