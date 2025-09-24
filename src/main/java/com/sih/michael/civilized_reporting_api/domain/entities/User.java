package com.sih.michael.civilized_reporting_api.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Slf4j
public class User {
    @Id
    private String id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    private String email;
    private String aadhaar;
    private boolean verified;
    private String mobile;
    private String avatarUrl;
    private String bio;
    @Enumerated(value = EnumType.STRING)
    private Role type;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts =new ArrayList<>();
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments;

    private Instant joinedDate;


}
