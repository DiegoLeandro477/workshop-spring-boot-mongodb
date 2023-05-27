package com.ferruje.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferruje.workshopmongo.domain.User;
import com.ferruje.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository rap;
	
	public List<User> findAll() {
		return rap.findAll();
	}
	
}
