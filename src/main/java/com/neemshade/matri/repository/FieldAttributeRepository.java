package com.neemshade.matri.repository;

import com.neemshade.matri.domain.FieldAttribute;
import com.neemshade.matri.domain.MalaParam;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the FieldAttribute entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldAttributeRepository extends JpaRepository<FieldAttribute, Long> {

	Optional<FieldAttribute> findTopByFieldIdAndAttributeName(Long fieldId, String attributeName);

	void deleteByFieldId(Long fieldId);

	@Query("SELECT fa FROM FieldAttribute fa WHERE fa.field.id IN (:fieldIds)")
	List<FieldAttribute> findAttributesOfFields(@Param("fieldIds")List<Long> fieldIds);
	
}
