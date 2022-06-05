package com.company.PDPOnline.service;

import com.company.PDPOnline.dto.AddressDTO;
import com.company.PDPOnline.entity.AddressEntity;
import com.company.PDPOnline.exception.ItemNotFoundException;
import com.company.PDPOnline.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository customerRepository;

    public List<AddressEntity> getAddresses(){
        return customerRepository.findAll();
    }

    public AddressEntity getById(Integer id) {
        return customerRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("Not found"));
    }

    public AddressDTO create(AddressDTO dto) {
        AddressEntity address = new AddressEntity();
        address.setStreet(dto.getStreet());
        address.setHomeNumber(dto.getHomeNumber());
        customerRepository.save(address);
        dto.setId(address.getId());
        return dto;
    }

    public String  update(Integer addressId, AddressDTO dto) {
        AddressEntity entity = getById(addressId);
        entity.setHomeNumber(dto.getHomeNumber());
        entity.setStreet(dto.getStreet());
        customerRepository.save(entity);
        return "Success";
    }

    public String delete(Integer addressId) {
        AddressEntity entity = getById(addressId);
        customerRepository.delete(entity);
        return "Success";
    }

    public AddressDTO toDTO(AddressEntity entity){
        AddressDTO dto = new AddressDTO();
        dto.setStreet(entity.getStreet());
        dto.setHomeNumber(entity.getHomeNumber());
        dto.setId(entity.getId());
        return dto;
    }
}
