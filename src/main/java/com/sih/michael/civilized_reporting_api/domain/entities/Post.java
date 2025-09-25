package com.sih.michael.civilized_reporting_api.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sih.michael.civilized_reporting_api.domain.dtos.LocationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
@Slf4j
public class Post {
    @Id
    private String id;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String authorAvatar;

    @Enumerated(value = EnumType.STRING)
    private Status pubStatus;

    @Enumerated(value = EnumType.STRING)
    private CompletionStatus status;

//    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments =new ArrayList<Comment>();

//    private Integer votes;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "dept_id")
//    private Department department;

//    @ManyToMany
//    @JoinTable(
//            name = "post_tags",
//            joinColumns = @JoinColumn(name = "post_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id")
//    )
//    private Set<Tag> tags = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "post_tags", // table to store the strings
            joinColumns = @JoinColumn(name = "post_id")
    )
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();
    @Column(precision = 10, scale = 7)
    private BigDecimal lat;

    @Column(precision = 10, scale = 7)
    private BigDecimal lon;

    private Instant createdAt;
    private LocalDateTime updatedAt;

    private String imageUrl;
    private Integer upvotes;
    private Integer reposts;
    private String resolvedImageUrl;
    @PrePersist
    protected void creationInitialization(){
//        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
        log.info("A  New Post was added.");
    }
}
