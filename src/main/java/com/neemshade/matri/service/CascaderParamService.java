package com.neemshade.matri.service;

import com.neemshade.matri.service.dto.CascaderParamDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.neemshade.matri.domain.CascaderParam}.
 */
public interface CascaderParamService {

    /**
     * Save a cascaderParam.
     *
     * @param cascaderParamDTO the entity to save.
     * @return the persisted entity.
     */
    CascaderParamDTO save(CascaderParamDTO cascaderParamDTO);

    /**
     * Get all the cascaderParams.
     *
     * @return the list of entities.
     */
    List<CascaderParamDTO> findAll();


    /**
     * Get the "id" cascaderParam.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CascaderParamDTO> findOne(Long id);

    /**
     * Delete the "id" cascaderParam.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
