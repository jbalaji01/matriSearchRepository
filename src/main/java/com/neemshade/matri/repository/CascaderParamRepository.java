package com.neemshade.matri.repository;

import com.neemshade.matri.domain.CascaderParam;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CascaderParam entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CascaderParamRepository extends JpaRepository<CascaderParam, Long> {
}
