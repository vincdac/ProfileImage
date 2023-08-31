package com.blinkx.ProfileImage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blinkx.ProfileImage.dto.ProfileImageDto;
import com.blinkx.ProfileImage.entity.ProfileImage;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long>{
	
	@Query(value="select * from public.t_profile_photo where user_id ILIKE :userId",nativeQuery = true)
	ProfileImage getByUserId(@Param("userId") String userId);
	
	
	
	

}
