package com.blinkx.ProfileImage.service;


import com.blinkx.ProfileImage.dto.ProfileImageDto;
import com.blinkx.ProfileImage.entity.ProfileImage;

public interface ProfileImageService {
	
	void uploadImage(ProfileImageDto profileImageDto,String userId);
	
	ProfileImageDto getProfileByUserId(String userId);
	
	void updateProfileByUserId(String userID,ProfileImageDto profileImageDto);
	
	String deleteProfileByUserId(String userId);

}
