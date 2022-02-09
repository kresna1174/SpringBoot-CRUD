package net.javadev.crud.controller;

import net.javadev.crud.exception.ResourceNotFoundException;
import net.javadev.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javadev.crud.model.employee;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<employee> getAllEmployees () {
        return employeeRepository.findAll();
    }

    @PostMapping
    public  employee createEmployee (@RequestBody employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<employee> getEmployeeById (@PathVariable long id) {
        employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee does not exists" + id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public  ResponseEntity<employee> updateEmployee (@PathVariable long id, @RequestBody employee employee) {
        employee updateEmployee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee does not exists" + id));
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmailId(employee.getEmailId());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<employee> deleteEmployee(@PathVariable  long id) {
        employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist " + id)
        );
        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
