package com.geekster.EmployeeAddress.service;

import com.geekster.EmployeeAddress.model.Address;
import com.geekster.EmployeeAddress.repository.IAddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo iAddressRepo;


    public String addAddress(Address address) {
        iAddressRepo.save(address);
        return "added successfully";
    }

    public List<Address> getAddress() {
        return (List<Address>) iAddressRepo.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return iAddressRepo.findById(id);
    }

    @Transactional
    public String updateAddress(Address address) {
        iAddressRepo.updateAddressDetails(address.getAddressId(),address.getStreet(),address.getCity(),address.getState(),address.getZipcode());
        return "address updated";
    }

    public String deleteAddressById(Long id) {
        iAddressRepo.deleteById(id);
        return  "address details deleted";
    }
}
