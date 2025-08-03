package com.locus_narrative.projects_service.persistence.repositories;

import com.locus_narrative.projects_service.persistence.models.ProjectUserModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaProjectUserRepository extends JpaRepository<ProjectUserModel, Long> {

    @EntityGraph(attributePaths = {"project"})
    @Query("""
            SELECT pum
            FROM ProjectUserModel pum
            JOIN FETCH ProjectModel pm ON pm.id = pum.project.id
            WHERE
                pm.uuid = :projectUuid AND
                pum.userUuid = :userUuid
            """)
    Optional<ProjectUserModel> findByProjectUuidAndUserUuid(@Param("projectUuid") UUID projectUuid, @Param("userUuid") UUID userUuid);

    @EntityGraph(attributePaths = {"project"})
    @Query("""
            SELECT pum
            FROM ProjectUserModel pum
            JOIN FETCH ProjectModel pm ON pm.id = pum.project.id
            WHERE pm.uuid = :projectUuid
            """)
    List<ProjectUserModel> findAllByProjectUuid(@Param("projectUuid") UUID projectUuid);
}
