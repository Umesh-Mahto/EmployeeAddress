package com.geekster.EmployeeAddress.controller;

import com.geekster.EmployeeAddress.model.Address;
import com.geekster.EmployeeAddress.model.Employees;
import com.geekster.EmployeeAddress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("/address")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }
    @GetMapping(value = "/allAddress")
    public List<Address> getAllAddress() {
        return addressService.getAddress();
    }
    @GetMapping("/address/{id}")
    public Optional<Address>getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }
    @PutMapping("/updateAddress")
    public String updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }
    @DeleteMapping("/deleteAddressById/{id}")
    public String deleteAddressById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }
}
