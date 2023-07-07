package com.geekster.EmployeeAddress.service;

import com.geekster.EmployeeAddress.model.Employees;
import com.geekster.EmployeeAddress.repository.IEmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;


    public void add(Employees employees) {
        iEmployeeRepo.save(employees);
    }

    public Iterable<Employees> getAllEmployee() {
        return iEmployeeRepo.findAll();
    }

    public Optional<Employees> getById(Long id) {
        return iEmployeeRepo.findById(id);
    }

    public String deleteEmployeeById(Long id) {
        iEmployeeRepo.deleteById(id);
        return "employee details deleted";
    }

    @Transactional
    public String updateEmployee(Employees employeeObj) {
        iEmployeeRepo.updateEmployee(employeeObj.getFirstName() , employeeObj.getLastName(),employeeObj.getId()) ;
        return "updated";
    }


}
