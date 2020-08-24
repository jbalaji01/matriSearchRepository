package com.neemshade.matri.service.impl;

import com.neemshade.matri.service.CascaderParamService;
import com.neemshade.matri.domain.CascaderParam;
import com.neemshade.matri.repository.CascaderParamRepository;
import com.neemshade.matri.service.dto.CascaderParamDTO;
import com.neemshade.matri.service.mapper.CascaderParamMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link CascaderParam}.
 */
@Service
@Transactional
public class CascaderParamServiceImpl implements CascaderParamService {

    private final Logger log = LoggerFactory.getLogger(CascaderParamServiceImpl.class);

    private final CascaderParamRepository cascaderParamRepository;

    private final CascaderParamMapper cascaderParamMapper;

    public CascaderParamServiceImpl(CascaderParamRepository cascaderParamRepository, CascaderParamMapper cascaderParamMapper) {
        this.cascaderParamRepository = cascaderParamRepository;
        this.cascaderParamMapper = cascaderParamMapper;
    }

    @Override
    public CascaderParamDTO save(CascaderParamDTO cascaderParamDTO) {
        log.debug("Request to save CascaderParam : {}", cascaderParamDTO);
        CascaderParam cascaderParam = cascaderParamMapper.toEntity(cascaderParamDTO);
        cascaderParam = cascaderParamRepository.save(cascaderParam);
        return cascaderParamMapper.toDto(cascaderParam);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CascaderParamDTO> findAll() {
        log.debug("Request to get all CascaderParams");
        return cascaderParamRepository.findAll().stream()
            .map(cascaderParamMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CascaderParamDTO> findOne(Long id) {
        log.debug("Request to get CascaderParam : {}", id);
        return cascaderParamRepository.findById(id)
            .map(cascaderParamMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CascaderParam : {}", id);
        cascaderParamRepository.deleteById(id);
    }
}
