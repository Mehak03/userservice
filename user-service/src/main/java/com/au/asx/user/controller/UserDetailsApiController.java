package com.au.asx.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.au.asx.user.entity.UserDetails;
import com.au.asx.user.model.UserDetailRequest;
import com.au.asx.user.service.UserService;

/**
 * UserDetailsApiController : contains api to get and update user details
 *
 */
@Controller
public class UserDetailsApiController {	
	
	private static Logger logger = LoggerFactory.getLogger(UserDetailsApiController.class);
	
	private UserService userService;	
	
	@Autowired
	public UserDetailsApiController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param userId
	 * @return UserDetails
	 */
	@GetMapping(value = "/userDetails/{userId}", produces = {"application/json"})
	public ResponseEntity<UserDetails> retrieveUserDetails(@PathVariable("userId") Long userId){
		logger.info("inside retrieveUserDetails for user: " + userId);
		UserDetails user = userService.retrieveUserDetails(userId);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
	
	/**
	 * @param userId
	 * @param userRequest
	 * @return
	 */
	@PostMapping(value = "/userDetails/{userId}", produces = {"application/json"}, consumes = {"application/json"})
	public ResponseEntity<Void> updateUserDetails(@PathVariable("userId") Long userId, @RequestBody UserDetailRequest userRequest){
		logger.info("inside updateUserDetails for user: " + userId);
		userService.updateUserDetails(userId, userRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
