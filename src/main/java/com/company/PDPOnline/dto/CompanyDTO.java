package com.company.PDPOnline.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyDTO {
    private Integer id;
    private String companyName;
    private String directorName;
    private Integer addressId;
    private AddressDTO addressDTO;
}
