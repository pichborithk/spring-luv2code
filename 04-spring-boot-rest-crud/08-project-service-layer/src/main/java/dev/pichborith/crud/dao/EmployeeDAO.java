package dev.pichborith.crud.dao;

import dev.pichborith.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
