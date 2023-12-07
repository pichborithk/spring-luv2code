package dev.pichborith.crud.service;

import dev.pichborith.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
