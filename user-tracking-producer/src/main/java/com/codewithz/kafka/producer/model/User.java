package com.codewithz.kafka.producer.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

import com.codewithz.kafka.producer.enums.UserId;

@Data
@Builder
public class User {

    private UserId userId;

    private String username;

    private Date dateOfBirth;

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
    

}
