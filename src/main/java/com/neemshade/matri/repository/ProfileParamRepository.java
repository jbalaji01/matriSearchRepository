package com.neemshade.matri.repository;

import com.neemshade.matri.domain.FieldAttribute;
import com.neemshade.matri.domain.ProfileParam;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProfileParam entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProfileParamRepository extends JpaRepository<ProfileParam, Long> {
	
	@Query("SELECT pp FROM ProfileParam pp WHERE pp.field.id IN (:fieldIds) and pp.profile.id IN :profileId")
	List<ProfileParam> findProfileParamOfFields(@Param("profileId") Long profileId, @Param("fieldIds")List<Long> fieldIds);
	
}
