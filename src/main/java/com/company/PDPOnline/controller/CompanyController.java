package com.company.PDPOnline.controller;

import com.company.PDPOnline.dto.CompanyDTO;
import com.company.PDPOnline.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<CompanyDTO> create(@RequestBody CompanyDTO dto){
        return ResponseEntity.ok(companyService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer companyId,
                                         @RequestBody CompanyDTO dto){
        return ResponseEntity.ok(companyService.update(companyId, dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CompanyDTO> getById(@PathVariable("id") Integer companyId){
        return ResponseEntity.ok(companyService.getById(companyId));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CompanyDTO>> getList(){
        return ResponseEntity.ok(companyService.getList());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer companyId){
        return ResponseEntity.ok(companyService.delete(companyId));
    }

}

