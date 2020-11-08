package com.neemshade.matri.service;

import com.neemshade.matri.domain.ProfileParam;
import com.neemshade.matri.service.dto.ProfileParamDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.neemshade.matri.domain.ProfileParam}.
 */
public interface ProfileParamService {

    /**
     * Save a profileParam.
     *
     * @param profileParamDTO the entity to save.
     * @return the persisted entity.
     */
    ProfileParamDTO save(ProfileParamDTO profileParamDTO);

    
    /**
     * Save list of profileParam.
     *
     * @param profileParamDTO the entity to save.
     * @return the persisted entity.
     */
    List<ProfileParamDTO> saveList(List<ProfileParamDTO> profileParamDTOList);

    
    /**
     * Get all the profileParams.
     *
     * @return the list of entities.
     */
    List<ProfileParamDTO> findAll();


    /**
     * Get the "id" profileParam.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProfileParamDTO> findOne(Long id);

    /**
     * Delete the "id" profileParam.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    /**
     * gather all profileParam of given fieldIds
     * @param fieldIds
     * @return
     */
    List<ProfileParam> findByFieldIds(Long profileId, List<Long> fieldIds);
}
