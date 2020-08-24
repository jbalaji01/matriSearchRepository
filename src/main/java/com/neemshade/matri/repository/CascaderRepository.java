package com.neemshade.matri.repository;

import com.neemshade.matri.domain.Cascader;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Cascader entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CascaderRepository extends JpaRepository<Cascader, Long> {
}
