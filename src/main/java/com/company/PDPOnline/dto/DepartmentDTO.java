package com.company.PDPOnline.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DepartmentDTO {
    private Integer id;
    private String name;
    private Integer companyId;
}
