package com.blinkx.ProfileImage.serviceImpl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkx.ProfileImage.dto.ProfileImageDto;
import com.blinkx.ProfileImage.entity.ProfileImage;
import com.blinkx.ProfileImage.repository.ProfileImageRepository;
import com.blinkx.ProfileImage.service.ProfileImageService;

@Service
public class ProfileImageServiceImpl implements ProfileImageService {
	
	@Autowired
	private ProfileImageRepository profileImageRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	

	@Override
	public ProfileImageDto getProfileByUserId(String userId) {
	ProfileImage profileImage = profileImageRepository.getByUserId(userId);	
	ProfileImageDto profileImageDto = modelMapper.map(profileImage, ProfileImageDto.class);
			return profileImageDto;
	}


	@Override
	public String deleteProfileByUserId(String userId) {
		ProfileImage profileImage = profileImageRepository.getByUserId(userId);
		if(profileImage!=null) {
			profileImageRepository.deleteById(profileImage.getProfileId());
			return "profile Image Deleted Sccessfully";
		}
		else {
		return "User Details not found by UserId";
		}
	}



	@Override
	public void uploadImage(ProfileImageDto profileImageDto,String userId) {
		//ProfileImage profileImage = modelMapper.map(profileImageDto, ProfileImage.class);
		ProfileImage profileImage2 = profileImageRepository.getByUserId(userId);
		if(profileImage2==null) {
		ProfileImage profileImage =new ProfileImage();
		profileImage.setData(profileImageDto.getData());
		profileImage.setName(profileImageDto.getName());
		profileImage.setUserId(profileImageDto.getUserId());
		profileImageRepository.save(profileImage);	
		}
		else {
			
		}
	}



	@Override
	public void updateProfileByUserId(String userID, ProfileImageDto profileImageDto) {
		ProfileImage profileImage = profileImageRepository.getByUserId(userID);
		if(profileImage!=null) {
			profileImage.setData(profileImageDto.getData());
			profileImage.setName(profileImageDto.getName());
			profileImage.setUserId(userID);
			profileImageRepository.save(profileImage);
		}
		else {
			//futureScope
		}
	}

}
