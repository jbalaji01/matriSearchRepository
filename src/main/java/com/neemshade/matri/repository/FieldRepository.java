package com.neemshade.matri.repository;

import com.neemshade.matri.domain.Field;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Field entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
}
