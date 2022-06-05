package com.company.PDPOnline.service;

import com.company.PDPOnline.dto.DepartmentDTO;
import com.company.PDPOnline.entity.DepartmentEntity;
import com.company.PDPOnline.exception.ItemNotFoundException;
import com.company.PDPOnline.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getDepartment(){
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        List<DepartmentEntity> entities = departmentRepository.findAll();

        entities.forEach(departmentEntity -> {
            departmentDTOS.add(toDTO(departmentEntity));
        });
        if (departmentDTOS.isEmpty()){
            return new LinkedList<>();
        }
        return departmentDTOS;
    }

    public DepartmentEntity get(Integer id) {
        return departmentRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("Not found"));
    }

    public DepartmentDTO getById(Integer id) {
        return toDTO(get(id));
    }

    public DepartmentDTO create(DepartmentDTO dto) {
        DepartmentEntity department = new DepartmentEntity();
        department.setName(dto.getName());
        department.setCompanyId(dto.getCompanyId());
        departmentRepository.save(department);
        dto.setId(department.getId());
        return dto;
    }

    public String  update(Integer departmentId, DepartmentDTO dto) {
        DepartmentEntity entity = get(departmentId);
        entity.setName(dto.getName());
        entity.setCompanyId(dto.getCompanyId());
        departmentRepository.save(entity);
        return "Success";
    }

    public String delete(Integer departmentId) {
        DepartmentEntity entity = get(departmentId);
        departmentRepository.delete(entity);
        return "Success";
    }

    public DepartmentDTO toDTO(DepartmentEntity entity){
        DepartmentDTO dto = new DepartmentDTO();
        dto.setCompanyId(entity.getCompanyId());
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        return dto;
    }
}
