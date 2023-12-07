package dev.pichborith.crud.dao;

import dev.pichborith.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// the @RepositoryRestResource is needed only when we need to customer path name
@RepositoryRestResource(path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
