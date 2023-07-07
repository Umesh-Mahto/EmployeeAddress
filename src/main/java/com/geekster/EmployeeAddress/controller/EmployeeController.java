package com.geekster.EmployeeAddress.controller;

import com.geekster.EmployeeAddress.model.Employees;
import com.geekster.EmployeeAddress.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
   @PostMapping("/AddEmployee")
    public void addEmployee(@RequestBody Employees employees){
     employeeService.add(employees);
   }
    @GetMapping("getAllEmployee")
    public Iterable<Employees> employeesList(){
    return employeeService.getAllEmployee();
   }
   @GetMapping("/employeeById/{id}")
    public Optional<Employees>getById(@PathVariable Long id){
   return employeeService.getById(id);
   }
   @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employees employeeObj){
        return employeeService.updateEmployee(employeeObj);
   }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
       return employeeService.deleteEmployeeById(id);
    }
}
