package com.company.PDPOnline.controller;

import com.company.PDPOnline.dto.DepartmentDTO;
import com.company.PDPOnline.service.CompanyService;
import com.company.PDPOnline.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<DepartmentDTO> create(@RequestBody DepartmentDTO dto){
        return ResponseEntity.ok(departmentService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer companyId,
                                         @RequestBody DepartmentDTO dto){
        return ResponseEntity.ok(departmentService.update(companyId, dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DepartmentDTO> getById(@PathVariable("id") Integer companyId){
        return ResponseEntity.ok(departmentService.getById(companyId));
    }

    @GetMapping("/list")
    public ResponseEntity<List<DepartmentDTO>> getList(){
        return ResponseEntity.ok(departmentService.getDepartment());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer companyId){
        return ResponseEntity.ok(departmentService.delete(companyId));
    }
}
