package com.simplecrud.dao.impls;

import com.simplecrud.beans.Employee;
import com.simplecrud.dao.EmployeeDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Employee employee) {

        String query = "INSERT INTO Employee (name, salary, designation) VALUES (?, ?, ?)";

        return jdbcTemplate.update(query,employee.getName(),employee.getSalary(),employee.getDesignation());
    }

    @Override
    public int update(Employee employee) {

        String query = "UPDATE Employee SET name = ?, salary = ?,  designation = ? WHERE id = ?";

        return jdbcTemplate.update(query,employee.getName(),employee.getSalary(),employee.getDesignation());
    }

    @Override
    public int delete(int id) {

        String query = "DELETE FROM Employee WHERE id = ?";


        return jdbcTemplate.update(query,id);
    }

    @Override
    public Employee getEmployeeById(int id) {

        String query = "SELECT * FROM Employee WHERE id = ?";

        return jdbcTemplate.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public List<Employee> getEmployees() {

        String query = "SELECT * FROM Employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>();

        return jdbcTemplate.query(query,rowMapper);
    }
}
