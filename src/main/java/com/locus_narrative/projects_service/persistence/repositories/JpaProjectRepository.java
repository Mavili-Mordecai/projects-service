package com.locus_narrative.projects_service.persistence.repositories;

import com.locus_narrative.projects_service.persistence.models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaProjectRepository extends JpaRepository<ProjectModel, Long> {
    Optional<ProjectModel> findByUuid(UUID uuid);

    @Query("""
            SELECT pm
            FROM ProjectModel pm
            JOIN FETCH ProjectUserModel pum ON pum.project.id = pm.id
            WHERE
                pum.userUuid = :userUuid AND
                pum.role = 'OWNER'
            """
    )
    List<ProjectModel> findAllByOwnerUuid(@Param("userUuid") UUID userUuid);
}
