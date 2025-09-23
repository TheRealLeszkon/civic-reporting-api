package com.sih.michael.civilized_reporting_api.domain.mappers.impl;

import com.sih.michael.civilized_reporting_api.domain.dtos.DepartmentDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Department;
import com.sih.michael.civilized_reporting_api.domain.mappers.DepartmentMapper;
import com.sih.michael.civilized_reporting_api.domain.mappers.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDTO toDTO(Department department) {
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                //.posts(department.getPosts().stream().map(postMapper::toDTO).toList())
                .postCount(
                        (department.getPosts()!=null) ?department.getPosts().size() :0
                )
                .build();
    }

    @Override
    public Department fromDTO(DepartmentDTO departmentDTO) {
        return Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                //.posts(departmentDTO.getPosts().stream().map(postMapper::fromDTO).toList())
                .build();
    }
}
