package com.sih.michael.civilized_reporting_api.repositories;

import com.sih.michael.civilized_reporting_api.domain.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.posts") //addresses n + 1 problem
    List<Department> findAllWithOptimization();

    boolean existsByNameIgnoreCase(String name);
}
