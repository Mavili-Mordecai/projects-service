package com.locus_narrative.projects_service.persistence.repositories;

import com.locus_narrative.projects_service.persistence.models.BoardModel;
import com.locus_narrative.projects_service.persistence.models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface JpaBoardRepository extends JpaRepository<BoardModel,Long> {

}
