package com.neemshade.matri.service.impl;

import com.neemshade.matri.service.CommonService;
import com.neemshade.matri.service.FieldAttributeService;
import com.neemshade.matri.service.FieldService;
import com.neemshade.matri.service.ProfileParamService;
import com.neemshade.matri.domain.Field;
import com.neemshade.matri.domain.FieldAttribute;
import com.neemshade.matri.domain.Mala;
import com.neemshade.matri.domain.MalaParam;
import com.neemshade.matri.domain.Profile;
import com.neemshade.matri.domain.ProfileParam;
import com.neemshade.matri.repository.FieldRepository;
import com.neemshade.matri.service.dto.FieldDTO;
import com.neemshade.matri.service.mapper.FieldMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Fidelity;

/**
 * Service Implementation for managing {@link Field}.
 */
@Service
@Transactional
public class FieldServiceImpl implements FieldService {

    private final Logger log = LoggerFactory.getLogger(FieldServiceImpl.class);

    private final FieldRepository fieldRepository;

    private final FieldMapper fieldMapper;
    
    private final CommonService commonService;
    
    private final FieldAttributeService fieldAttributeService;
    private final ProfileParamService profileParamService;

    public FieldServiceImpl(FieldRepository fieldRepository, FieldMapper fieldMapper,
    		CommonService commonService, FieldAttributeService fieldAttributeService, ProfileParamService profileParamService) {
        this.fieldAttributeService = fieldAttributeService;
		this.profileParamService = profileParamService;
		this.commonService = commonService;
		this.fieldRepository = fieldRepository;
        this.fieldMapper = fieldMapper;
    }

    @Override
    public FieldDTO save(FieldDTO fieldDTO) {
        log.debug("Request to save Field : {}", fieldDTO);
        Field field = fieldMapper.toEntity(fieldDTO);
        field = fieldRepository.save(field);
        return fieldMapper.toDto(field);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FieldDTO> findAll() {
        log.debug("Request to get all Fields");
        return fieldRepository.findAll().stream()
            .map(fieldMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<FieldDTO> findOne(Long id) {
        log.debug("Request to get Field : {}", id);
        return fieldRepository.findById(id)
            .map(fieldMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Field : {}", id);
        fieldRepository.deleteById(id);
    }

	@Override
	public Optional<FieldDTO> findMaxPeckOrder() {
		log.debug("Request to get Field with max peckOrder");
        return fieldRepository.findTopByOrderByPeckOrderDesc()
            .map(fieldMapper::toDto);
	}

	@Override
	public Optional<FieldDTO> findUniqueFieldUnderMala(String malaName, String fieldName) {
		log.debug("Request to get unique Field : {}", fieldName);
        return fieldRepository.findTopByMalaParamsMalaMalaNameAndFieldName(malaName, fieldName)
            .map(fieldMapper::toDto);
	}

	@Override
	public void fillAttributesAndParams(Map<Long, Field> fieldMap) throws Exception {
		log.debug("Get all attributes and profileParams of given list of field");
		
		Profile focusedProfile = commonService.fetchFocusedProfile();
		if(focusedProfile == null || focusedProfile.getId() == null)
			throw new Exception("Login detail missing");
		
		List<Long> fieldIds = new ArrayList<>(fieldMap.keySet());
		List<FieldAttribute> fieldAttributes = fieldAttributeService.findByFieldIds(fieldIds);
		log.debug("size of fa list={}", fieldAttributes.size());
		
		for (FieldAttribute fieldAttribute : fieldAttributes) {
			
			log.debug("inside FA loop id {}, field {}", fieldAttribute.getId(), fieldAttribute.getField());
			
			if(fieldAttribute == null || fieldAttribute.getField() == null || fieldAttribute.getField().getId() == null)
				continue;
			
			Field field = fieldMap.get(fieldAttribute.getField().getId());
			if(field == null)
				continue;
			
			log.debug("FA id {} with field id {}", fieldAttribute.getId(), field.getId());
			
//			fieldAttribute.setField(null);
			field.addFieldAttribute(fieldAttribute);
		}
		
		
		List<ProfileParam> profileParams = profileParamService.findByFieldIds(focusedProfile.getId(), fieldIds);
		
		for(ProfileParam profileParam : profileParams) {
			
			if(profileParam == null || profileParam.getField() == null || profileParam.getField().getId() == null)
				continue;
			
			Field field = fieldMap.get(profileParam.getField().getId());
			if(field == null)
				continue;
			
			log.debug("PP id {} with field id {}", profileParam.getId(), field.getId());
			
			
//			profileParam.setField(null);
//			profileParam.setProfile(null);
			field.addProfileParam(profileParam);
		}
	}
}
