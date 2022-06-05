package com.company.PDPOnline.controller;

import com.company.PDPOnline.dto.AddressDTO;
import com.company.PDPOnline.entity.AddressEntity;
import com.company.PDPOnline.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/costumer")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResponseEntity<List<AddressEntity>> getAddresses(){
         return ResponseEntity.ok(addressService.getAddresses());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressEntity> getAddress(@PathVariable("id") Integer id){
        return ResponseEntity.ok(addressService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AddressDTO> create(@RequestBody @Valid AddressDTO dto){
        return ResponseEntity.ok(addressService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer addressId,
                                         @RequestBody AddressDTO dto){
        return ResponseEntity.ok(addressService.update(addressId, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer addressId){
        return ResponseEntity.ok(addressService.delete(addressId));
    }
}
