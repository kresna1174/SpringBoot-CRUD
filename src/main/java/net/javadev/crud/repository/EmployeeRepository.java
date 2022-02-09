package net.javadev.crud.repository;

import net.javadev.crud.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface EmployeeRepository extends JpaRepository<employee, Long> {
    //
}
