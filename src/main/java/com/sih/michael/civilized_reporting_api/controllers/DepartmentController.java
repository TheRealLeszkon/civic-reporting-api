package com.sih.michael.civilized_reporting_api.controllers;

import com.sih.michael.civilized_reporting_api.domain.dtos.CreateDepartmentRequest;
import com.sih.michael.civilized_reporting_api.domain.dtos.DepartmentDTO;
import com.sih.michael.civilized_reporting_api.domain.mappers.DepartmentMapper;
import com.sih.michael.civilized_reporting_api.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;
    @GetMapping
    public List<DepartmentDTO> showAllDepartments(){
        return departmentService.listAllDepartments().stream().map(departmentMapper::toDTO).toList();
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@Valid @RequestBody CreateDepartmentRequest createRequest){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(createRequest.getName());
        return new ResponseEntity<>(
                departmentMapper.toDTO(
                        departmentService.createNewDepartment(departmentMapper.fromDTO(departmentDTO))
                ), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
