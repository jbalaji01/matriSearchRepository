package com.neemshade.matri.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.neemshade.matri.domain.Profile;
import com.neemshade.matri.domain.User;
import com.neemshade.matri.service.dto.ProfileDTO;
import com.neemshade.matri.service.mapper.ProfileMapper;

@Service
public class CommonService {
	private final Logger log = LoggerFactory.getLogger(CommonService.class);
	
	private final UserService userService;
	private final ProfileService profileService;
	private final ProfileMapper profileMapper;
	
	public CommonService(UserService userService, ProfileService profileService, ProfileMapper profileMapper) {
		this.profileMapper = profileMapper;
		this.userService = userService;
		this.profileService = profileService;
	}
	
	public Profile fetchFocusedProfile() {
		
		log.debug("going to fetch profile");
		
		Optional<User> userOptional = userService.getUserWithAuthorities();
		if(!userOptional.isPresent()) {
			return null;
		}
		
		log.debug("got user");
		
		// TBD - check if webMaster, if so, check if focus Profile is stored in session
		
		User user = userOptional.get();
		Optional<ProfileDTO> profileOptional = profileService.findOneByUserId(user.getId());
		if(!profileOptional.isPresent()) {
			return null;
		}
		
		log.debug("got profile");
		
		ProfileDTO profileDTO = profileOptional.get();
		return profileMapper.toEntity(profileDTO);
	}
}
