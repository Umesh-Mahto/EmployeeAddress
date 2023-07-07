package com.geekster.EmployeeAddress.repository;

import com.geekster.EmployeeAddress.model.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends CrudRepository<Address,Long> {

    @Modifying
    @Query(value = " update address_table set street = :street,city = :city,state = :state,zipcode = :zipcode where address_id = :addressId",nativeQuery = true)
    void updateAddressDetails(Long addressId, String street, String city, String state, String zipcode);
}
