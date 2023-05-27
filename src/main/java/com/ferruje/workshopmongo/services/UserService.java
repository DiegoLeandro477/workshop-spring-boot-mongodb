package com.ferruje.workshopmongo.services;

import java.util.List;
import java.util.Optional;

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

	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

}
