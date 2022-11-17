package com.au.asx.user.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.au.asx.user.exception.ExceptionAdvice;
import com.au.asx.user.model.UserDetailRequest;
import com.au.asx.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
public class UserDetailsApiControllerTest {
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserDetailsApiController userDetailsApiController;
	
	private MockMvc mockmvc;
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(UserDetailsApiControllerTest.class);
		mockmvc = MockMvcBuilders.standaloneSetup(userDetailsApiController).setControllerAdvice(new ExceptionAdvice()).build();
	}
	
	@Test
	public void retrieveUserDetails() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/userDetails/123")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void updateUserDetails() throws Exception {
		UserDetailRequest userReq = new UserDetailRequest();
		Mockito.doNothing().when(userService).updateUserDetails(anyLong(),any(UserDetailRequest.class));
		mockmvc.perform(MockMvcRequestBuilders.post("/userDetails/123").content(objectMapper.writeValueAsString(userReq)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
