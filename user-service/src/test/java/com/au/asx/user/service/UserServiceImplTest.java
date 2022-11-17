package com.au.asx.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.au.asx.user.entity.UserDetails;
import com.au.asx.user.exception.CustomException;
import com.au.asx.user.repository.UserRepository;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserRepository userRepo;
	
	@BeforeEach
	public void before() {
		userRepo = Mockito.mock(UserRepository.class);
		userService = new UserServiceImpl(userRepo);		
	}

	@Test
	public void testRetrieveUserDetails() {
		UserDetails userDetails = new UserDetails();
		userDetails.setTitle("MR");
		Optional<UserDetails> userDetailsOptional = Optional.of(userDetails);
		when(userRepo.findById(anyLong())).thenReturn(userDetailsOptional);
		assertEquals("MR", userService.retrieveUserDetails(anyLong()).getTitle());
	}
	
	@Test
	public void testRetrieveUserDetailsExce() {
		when(userRepo.findById(anyLong())).thenReturn(Optional.empty());
		CustomException thrown = Assertions.assertThrows(CustomException.class, () -> {
			userService.retrieveUserDetails(anyLong());
	  });
	}


}
