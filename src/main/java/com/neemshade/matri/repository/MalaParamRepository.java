package com.neemshade.matri.repository;

import com.neemshade.matri.domain.MalaParam;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MalaParam entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MalaParamRepository extends JpaRepository<MalaParam, Long> {
}
