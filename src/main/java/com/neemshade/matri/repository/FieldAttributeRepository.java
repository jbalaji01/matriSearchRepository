package com.neemshade.matri.repository;

import com.neemshade.matri.domain.FieldAttribute;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the FieldAttribute entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldAttributeRepository extends JpaRepository<FieldAttribute, Long> {
}
