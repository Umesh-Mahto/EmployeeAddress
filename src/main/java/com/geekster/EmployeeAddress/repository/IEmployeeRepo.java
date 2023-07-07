package com.geekster.EmployeeAddress.repository;

import com.geekster.EmployeeAddress.model.Address;
import com.geekster.EmployeeAddress.model.Employees;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends CrudRepository<Employees,Long> {

    @Modifying
    @Query(value = " update employee_table set first_name = :firstName, last_name = :lastName where id = :id" ,nativeQuery = true)
    void updateEmployee(String firstName,String lastName, Long id);

}
