package com.sih.michael.civilized_reporting_api.repositories;

import com.sih.michael.civilized_reporting_api.domain.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {
    boolean existsByNameIgnoreCase(String name);
    @Query("SELECT t FROM Tag t LEFT JOIN FETCH t.posts")
    List<Tag> findAllWithOptimization();
}
