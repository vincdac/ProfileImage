package com.blinkx.ProfileImage.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.ProfileImage.dto.ErrorResponseDto;
import com.blinkx.ProfileImage.dto.ProfileImageDto;
import com.blinkx.ProfileImage.dto.SuccessResponseDto;
import com.blinkx.ProfileImage.service.ProfileImageService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"*"})
public class ProfileImageController {

	@Autowired(required = true)
	private ProfileImageService profileImageService;
	
	@Value("${upload.dir}")
    private String uploadDir;
	
	
	
	@PostMapping("uploadProfileImage/{userId}")
	public ResponseEntity<?> uploadProfileImage(@RequestParam("file")MultipartFile file,@PathVariable String userId) throws IOException{
		try {
		ProfileImageDto profiledto=new ProfileImageDto();
		profiledto.setName(file.getOriginalFilename());
		profiledto.setData(file.getBytes());
		profiledto.setUserId(userId);
		profileImageService.uploadImage(profiledto,userId);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Profile data is uploaded successfully"),HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("Failure", "Failed to upload Profile data"),HttpStatus.BAD_REQUEST);
		}
		}
	
	@GetMapping("getProfileByUserId/{userId}")
	public ResponseEntity<?> getProfileByUserId(@PathVariable String userId){
		ProfileImageDto profileByUserId = profileImageService.getProfileByUserId(userId);
		if(profileByUserId!=null) {
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Profile photo by user ID::", profileByUserId),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new ErrorResponseDto("Failure","Profile not found by UsedId::"+userId),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("updateProfileByUserId/{userId}")
	public ResponseEntity<?> updateProfileByUserId(@PathVariable String userId,@RequestParam("file")MultipartFile file) throws IOException{
		try {
		ProfileImageDto profiledto=new ProfileImageDto();
		profiledto.setData(file.getBytes());
		profiledto.setName(file.getOriginalFilename());
		profiledto.setUserId(userId);
		profileImageService.updateProfileByUserId(userId, profiledto);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Profile is updated SuccessFully"),HttpStatus.CREATED);
		}
		catch (Exception e) {
		return new ResponseEntity<>(new ErrorResponseDto("Failure", "Failed to update profile by userId:->"+userId),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("deleteProfileByUserId/{userId}")
	public ResponseEntity<?> deleteProfileByUserId(@PathVariable String userId){
		try {
		String profileByUserId = profileImageService.deleteProfileByUserId(userId);
		return new ResponseEntity<>(new SuccessResponseDto("Success", profileByUserId),HttpStatus.OK);
		}
		catch (Exception e) {
		return new ResponseEntity<>(new ErrorResponseDto("failure", "failed to dlete profile by useId ->"+userId),HttpStatus.BAD_REQUEST);
		}
	}
	
}
