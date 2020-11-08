package com.neemshade.matri.repository;

import com.neemshade.matri.domain.Profile;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Profile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	Optional<Profile> findOneByUserId(Long id);
}
