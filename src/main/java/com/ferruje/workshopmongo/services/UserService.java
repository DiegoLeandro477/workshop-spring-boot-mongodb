package com.ferruje.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferruje.workshopmongo.domain.User;
import com.ferruje.workshopmongo.dto.UserDTO;
import com.ferruje.workshopmongo.repository.UserRepository;
import com.ferruje.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository rep;

	public List<User> findAll() {
		return rep.findAll();
	}

	public User findById(String id) {
		return rep.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return rep.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

}
