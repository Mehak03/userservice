package com.au.asx.user.util;

import java.util.Objects;

import org.springframework.util.StringUtils;

import com.au.asx.user.entity.Address;
import com.au.asx.user.entity.UserDetails;
import com.au.asx.user.model.UserAddress;
import com.au.asx.user.model.UserDetailRequest;

/**
 * UserDetailsUtil : utility
 *
 */
public class UserDetailsUtil {	
	
	public static UserDetails mapUserDetails(UserDetails user, UserDetailRequest userReq) {
		if (StringUtils.hasLength(userReq.getFirstName())) {
			user.setFirstName(userReq.getFirstName());
		}
		
		if (StringUtils.hasLength(userReq.getLastName())) {
			user.setLastName(userReq.getLastName());
		}
		if (StringUtils.hasLength(userReq.getTitle())) {
			user.setTitle(userReq.getTitle());
		}
		if (StringUtils.hasLength(userReq.getGender())) {
			user.setGender(userReq.getGender());
		}
		if (Objects.nonNull(userReq.getAddress())) {
			Address address = user.getAddress();
			UserAddress userAddress = userReq.getAddress();
			if (StringUtils.hasLength(userAddress.getCity())) {
				address.setCity(userAddress.getCity());
			}
			if (Objects.nonNull(userAddress.getPostcode())) {
				address.setPostcode(userAddress.getPostcode());
			}
			if (StringUtils.hasLength(userAddress.getState())) {
				address.setState(userAddress.getState());
			}
			if (StringUtils.hasLength(userAddress.getStreet())) {
				address.setStreet(userAddress.getStreet());
			}
			user.setAddress(address);
		}
		
		return user;
	}
}
