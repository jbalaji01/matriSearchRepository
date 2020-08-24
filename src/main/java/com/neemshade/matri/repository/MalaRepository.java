package com.neemshade.matri.repository;

import com.neemshade.matri.domain.Mala;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Mala entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MalaRepository extends JpaRepository<Mala, Long> {
}
