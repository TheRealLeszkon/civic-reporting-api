package com.sih.michael.civilized_reporting_api.services.impl;

import com.sih.michael.civilized_reporting_api.domain.entities.Department;
import com.sih.michael.civilized_reporting_api.repositories.DepartmentRepository;
import com.sih.michael.civilized_reporting_api.services.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public List<Department> listAllDepartments() {
        return departmentRepository.findAllWithOptimization();
    }

    @Override
    public Department createNewDepartment(Department department) {
        if(departmentRepository.existsByNameIgnoreCase(department.getName()))
            throw new IllegalArgumentException("Department Already exists with name : "+department.getName());

        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isPresent()){
            if (!department.get().getPosts().isEmpty()){
                throw new IllegalStateException("Department has post associated with it!");
            }
            departmentRepository.deleteById(id);
        }
    }

    @Override
    public Department findDepartmentById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("No Department by that name exists!"));
    }
}
