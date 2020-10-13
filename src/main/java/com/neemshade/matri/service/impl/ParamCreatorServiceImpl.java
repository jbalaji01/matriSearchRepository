package com.neemshade.matri.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.neemshade.matri.service.CascaderParamService;
import com.neemshade.matri.service.CascaderService;
import com.neemshade.matri.service.ParamCreatorService;
import com.neemshade.matri.service.mapper.CascaderMapper;
import com.neemshade.matri.service.mapper.CascaderParamMapper;
import com.neemshade.matri.service.paramCreator.ParamEngine;

@Service
@Transactional
public class ParamCreatorServiceImpl implements ParamCreatorService{
	private final Logger log = LoggerFactory.getLogger(ParamCreatorServiceImpl.class);

	@Autowired
	private CascaderService cascaderService;
	
	@Autowired
	private CascaderMapper cascaderMapper;
	
	@Autowired
	private CascaderParamService cascaderParamService;
	
	@Autowired
	private CascaderParamMapper cascaderParamMapper;
	
	
	@Override
	public String extractData(MultipartFile[] files) {
		
		Map<String, Object> servicesMap = new HashMap<>();
		servicesMap.put("CascaderService", cascaderService);
		servicesMap.put("CascaderMapper", cascaderMapper);
		servicesMap.put("CascaderParamService", cascaderParamService);
		servicesMap.put("CascaderParamMapper", cascaderParamMapper);
		
		ParamEngine.setServicesMap(servicesMap);
		
		String result = "<ul>";
		
		System.out.println(files.length + " files");
		
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
            System.out.println(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
            ParamEngine pe = ParamEngine.getInstance(file);
            pe.performParsing();
            result += pe.announceCount();
            log.info(result);
        }
		
		result += "</ul>";
		
		return result;
	}

}
