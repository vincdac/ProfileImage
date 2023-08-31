package com.blinkx.ProfileImage.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="t_profile_photo")
public class ProfileImage implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long profileId;
	
	@Column
	private String name;
	
	@Column
	private byte[] data;
	
	@Column
	@CreationTimestamp
	private Date createDate;
	
	@Column
	@UpdateTimestamp
	private Date updateDate;
	
	@Column
	private String userId;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public ProfileImage(long profileId, String name, byte[] data, Date createDate, Date updateDate, String userId) {
		super();
		this.profileId = profileId;
		this.name = name;
		this.data = data;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userId = userId;
	}

	public ProfileImage() {
		super();
	}

	
	

	

}
