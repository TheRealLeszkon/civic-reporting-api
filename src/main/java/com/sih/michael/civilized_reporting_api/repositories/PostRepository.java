package com.sih.michael.civilized_reporting_api.repositories;

import com.sih.michael.civilized_reporting_api.domain.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findAllByUser(User user);
}
