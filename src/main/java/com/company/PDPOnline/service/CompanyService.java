package com.company.PDPOnline.service;

import com.company.PDPOnline.dto.CompanyDTO;
import com.company.PDPOnline.entity.CompanyEntity;
import com.company.PDPOnline.exception.ItemNotFoundException;
import com.company.PDPOnline.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressService addressService;

    public CompanyDTO create(CompanyDTO dto) {
        CompanyEntity entity = new CompanyEntity();
        entity.setCompanyName(dto.getCompanyName());
        entity.setAddressId(dto.getAddressId());
        entity.setDirectorName(dto.getDirectorName());
        companyRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public String update(Integer companyId, CompanyDTO dto) {
        CompanyEntity entity = get(companyId);
        entity.setAddressId(dto.getAddressId());
        entity.setCompanyName(dto.getCompanyName());
        entity.setDirectorName(dto.getDirectorName());
        companyRepository.save(entity);
        return "Success";
    }

    public CompanyDTO getById(Integer companyId) {
        CompanyEntity entity = get(companyId);
        return toDTO(entity);
    }

    public CompanyEntity get(Integer companyId){
        return companyRepository.findById(companyId).orElseThrow(() -> new ItemNotFoundException("Not Found"));
    }

    public List<CompanyDTO> getList() {
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        companyEntities.forEach(entity -> {
            companyDTOS.add(toDTO(entity));
        });

        return companyDTOS;
    }

    public String delete(Integer companyId) {
        CompanyEntity entity = get(companyId);
        companyRepository.delete(entity);
        return "Success";
    }

    public CompanyDTO toDTO(CompanyEntity entity){
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyName(entity.getCompanyName());
        dto.setDirectorName(entity.getDirectorName());
        dto.setAddressDTO(addressService.toDTO(entity.getAddress()));
        dto.setId(entity.getId());
        return dto;
    }


}
