package com.locus_narrative.projects_service.persistence.models;

import com.locus_narrative.projects_service.domain.entities.ProjectUserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "project_users")
public class ProjectUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    @Column(nullable = false)
    private UUID userUuid;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectUserRole role;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
}
