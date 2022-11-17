package com.au.asx.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.au.asx.user.entity.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Long> {

}
