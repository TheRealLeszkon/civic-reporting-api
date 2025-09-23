package com.sih.michael.civilized_reporting_api.repositories;

import com.sih.michael.civilized_reporting_api.domain.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByStatusAndDepartmentAndTagsContaining(Status Status, Department department, Tag tag);
    List<Post> findAllByStatusAndTags(Status status,Tag tag);
    List<Post> findAllByStatusAndDepartment(Status status,Department department);
    List<Post> findAllByStatus(Status status);
    List<Post> findAllByUserAndStatus(User user, Status status);
}
