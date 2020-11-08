package com.neemshade.matri.repository;

import com.neemshade.matri.domain.Mala;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Mala entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MalaRepository extends JpaRepository<Mala, Long> {
	Optional<Mala> findTopByMalaName(String malaName);

//	@Query("SELECT m FROM Mala m " +
//			" join MalaParam mp " +
//			" on m.id = mp.mala.id " +
//			" WHERE m.id = ?1")
//	Mala findMalaDetail(Long malaId);
}
