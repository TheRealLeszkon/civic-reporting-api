package com.sih.michael.civilized_reporting_api.domain.mappers;

import com.sih.michael.civilized_reporting_api.domain.dtos.DepartmentDTO;
import com.sih.michael.civilized_reporting_api.domain.dtos.PostDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Department;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;

public interface DepartmentMapper {
    DepartmentDTO toDTO(Department department);
    Department fromDTO(DepartmentDTO departmentDTO);
}
