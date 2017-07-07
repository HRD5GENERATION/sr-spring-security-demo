package com.sr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sr.model.User;
import com.sr.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//TODO: query user object and roles from database
		User user = userRepository.loadUserByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("-> User not found!");		
		System.out.println("loadUserByUsername() : " + user);
		return user;
	}

}
