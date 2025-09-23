package com.sih.michael.civilized_reporting_api.services;

import com.sih.michael.civilized_reporting_api.domain.entities.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    List<Department> listAllDepartments();

    Department createNewDepartment(Department department);

    void deleteDepartment(Integer id);

    Department findDepartmentById(Integer id);
}
