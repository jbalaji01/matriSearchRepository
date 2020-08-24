package com.neemshade.matri.service;

import com.neemshade.matri.service.dto.CascaderDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.neemshade.matri.domain.Cascader}.
 */
public interface CascaderService {

    /**
     * Save a cascader.
     *
     * @param cascaderDTO the entity to save.
     * @return the persisted entity.
     */
    CascaderDTO save(CascaderDTO cascaderDTO);

    /**
     * Get all the cascaders.
     *
     * @return the list of entities.
     */
    List<CascaderDTO> findAll();


    /**
     * Get the "id" cascader.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CascaderDTO> findOne(Long id);

    /**
     * Delete the "id" cascader.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
