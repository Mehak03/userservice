package com.au.asx.user.service;

import com.au.asx.user.entity.UserDetails;
import com.au.asx.user.model.UserDetailRequest;

public interface UserService {
	
	// update user details
    void updateUserDetails(Long userId, UserDetailRequest userReq);
 
    // Retrieve user details
    UserDetails retrieveUserDetails(Long userId);

}
